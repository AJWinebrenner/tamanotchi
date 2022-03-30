import { useState, useEffect, useLayoutEffect } from "react";

const PetDisplay = ({variant, mood, food}) => {

    const [folder, setFolder] = useState(0); //needs default
    const [displayMood, setDisplayMood] = useState(1);
    const [emote, setEmote] = useState(0); //0 is blank sprite

    useEffect(() => setFolder(variant), [variant]);

    if (true) {
        return(
            <div id="pet-display" className="pixel-box column-flex display break">
                <img id="emote-sprite" className="sprite" src={require(`../sprites/emotes/${emote}.gif`)}/>
                <img id="pet-sprite" className="sprite" src={require(`../sprites/variants/${folder}/${displayMood}.gif`)}/>
            </div>
        );
    } else {
        return(
            <div id="pet-display" className="pixel-box">
                <img id="food-sprite" className="sprite" src={`../sprites/foods/${food}.png`}></img>
                <img id="pet-sprite" className="sprite" src={`../sprites/variants/${folder}/eat.gif`}></img>
            </div>
        );
    }
}

export default PetDisplay;