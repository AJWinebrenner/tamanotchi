import { useState, useEffect } from "react";
import ActivityContainer from "../containers/ActivityContainer";
import PetContainer from "../containers/PetContainer";

const GamePage = ({petId}) => {

    const [currentPet, setCurrentPet] = useState({
        "id": 0,
        "name": "blank",
        "house": 3,
        "variant": 0,
        "happiness": 1,
        "energy": 10,
        "max_happiness": 10,
        "max_energy": 10,
        "mood": 1,
        "exp": 0,
        "money": 0
    });
    const [currentPetName, setCurrentPetName] = useState("-");
    const [currentStage, setCurrentStage] = useState(1);
    const [currentMoney, setCurrentMoney] = useState(0);
    
        // put in money and stage in state 
    
    const loadPet = () => {
    console.log(currentPet);
    fetch(`http://localhost:8080/pets/${petId}`)
      .then(response => response.json())
      .then(pet => {
          setCurrentPet(pet);
          setCurrentPetName(pet.name);
          setCurrentMoney(pet.money);
          fetch(`http://localhost:8080/variants/${pet.variant}`)
            .then(response => response.json())
            .then(variant => setCurrentStage(variant.stage))
        }) // not sure we need this here or after if statement
      .catch(error => console.error(error)); 
    }


    // const getFields = () => {
    //     if (currentPet) {
    //         setCurrentPetName(currentPet.name);
    //         setCurrentMoney(currentPet.money);   
    //     }
    // }

    useEffect(loadPet, [petId]);
    // useEffect(getFields, [currentPet]);

    return (
        <>
            <section id="banner" className="middle-flex break">
                <div id="banner__stage" className="pixel-box center-text">
                    {currentStage}
                </div>
                <div id="banner__name" className="pixel-box center-text">
                    {currentPetName}
                </div>
                <div id="banner__money" className="pixel-box center-text">
                    {currentMoney}
                </div>
            </section>
            <div className="middle-flex">
                <PetContainer pet={currentPet}/>
                <ActivityContainer/>
            </div>
        </>
    );
}

export default GamePage;