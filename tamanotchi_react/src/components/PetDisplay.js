import { useState, useEffect, useLayoutEffect } from "react";

const PetDisplay = ({variant, mood, foodId, petId}) => {

    const [folder, setFolder] = useState(0); //needs default
    const [displayMood, setDisplayMood] = useState(1);
    const [emote, setEmote] = useState(0); //0 is blank sprite
    console.log(foodId)

    useEffect(() => setFolder(variant), [variant]);

    useEffect(() => setDisplayMood(mood), [mood]);

    const changeEmote = () => {
        fetch(`http://localhost:8080/pets/${petId}`)
          .then(response => response.json())
          .then(pet => {
              setDisplayMood(pet.mood);
              console.log(pet.mood);
            }) // not sure we need this here or after if statement
          .catch(error => console.error(error)); 
        }

    if (!foodId) {
        return(
            <div id="pet-display" className="pixel-box column-flex display break">
                <img id="emote-sprite" className="sprite" src={require(`../sprites/emotes/${emote}.gif`)}/>
                <img id="pet-sprite" className="sprite" src={require(`../sprites/variants/${folder}/${displayMood}.gif`)}/>
            </div>
        );
    } else {
        return(
            <div id="pet-display" className="pixel-box column-flex display break">
                <img id="food-sprite" className="sprite" src={require(`../sprites/foods/${foodId}.png`)}/>
                {/* <img id="pet-sprite" className="sprite" src={require(`../sprites/variants/${folder}/eat.gif`)}/> */}
            </div>
        );
    }
}

export default PetDisplay;