import { useState, useEffect } from "react";

const PetDisplay = ({variant, mood, foodId, idleEmote}) => {
    
    const [displayMood, setDisplayMood] = useState(1);
    const [emote, setEmote] = useState(0); //0 is blank sprite

    const startEmote = (moodNum) => {
        setEmote(moodNum);
        const timer = setTimeout(() => {
            setEmote(0);
            }, 4000);
        return () => clearTimeout(timer);
    }
    
    const checkMood = () => {
        if (displayMood === mood) return;
        setDisplayMood(mood);
        startEmote(mood);
    }         

    useEffect(checkMood, [mood]);

    if (foodId) {
        return(
            <div id="pet-display" className="pixel-box column-flex display break">
                <img id="food-sprite" className="sprite" src={require(`../sprites/foods/${foodId}.png`)}/>
                <img id="pet-sprite" className="sprite" src={require(`../sprites/variants/${variant}/eat.gif`)}/>
            </div>
        );
    } else if (emote) {
        return(
            <div id="pet-display" className="pixel-box column-flex display break">
                <img id="emote-sprite" className="sprite" src={require(`../sprites/emotes/${emote}.gif`)}/>
                <img id="pet-sprite" className="sprite" src={require(`../sprites/variants/${variant}/${displayMood}.gif`)}/>
            </div>
        );
    } else {
        return(
            <div id="pet-display" className="pixel-box column-flex display break">
                <img id="emote-sprite" className="sprite" src={require(`../sprites/emotes/${idleEmote}.gif`)}/>
                <img id="pet-sprite" className="sprite" src={require(`../sprites/variants/${variant}/${displayMood}.gif`)}/>
            </div>
        );
    }
}

export default PetDisplay;