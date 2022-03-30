import { useState, useEffect, useLayoutEffect } from "react";

const PetDisplay = (variant, mood, food) => {

    const [folder, setFolder] = useState(3);
    const [displayMood, setDisplayMood] = useState(1);
    const [emote, setEmote] = useState(0); //0 is blank sprite

    const findFolder = (variant) => {
        if (Number.isInteger(variant)){
            setFolder(variant);
        } else {
            setFolder(3);
        }
    }

    useEffect(findFolder, [variant]);

    if (true) {
        return(
            <div id="pet-display" className="pixel-box column-flex display break">
                <img id="emote-sprite" className="sprite" src={require(`../sprites/emotes/${emote}.png`)}/>
                <img id="pet-sprite" className="sprite" src={require(`../sprites/variants/${folder}/${displayMood}.gif`)}/>
            </div>
        );
    } else {
        return(
            <div id="pet-display" className="pixel-box">
                <img id="food-sprite" className="sprite" src={`../sprites/foods/${food}.png`}></img>
                <img id="pet-sprite" className="sprite" src={`../sprites/variants/${variant}/eat.gif`}></img>
            </div>
        );
    }
}

export default PetDisplay;