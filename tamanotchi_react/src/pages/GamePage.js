import { useState, useEffect } from "react";
import ActivityContainer from "../containers/ActivityContainer";
import PetContainer from "../containers/PetContainer";

const GamePage = ({petId}) => {

    const [currentPet, setCurrentPet] = useState({
        "id": 0,
        "name": "-",
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
    const [currentStage, setCurrentStage] = useState(1);
    const[foodId, setFoodId]= useState(0);
    
    const loadPet = () => {
    console.log(currentPet);
    fetch(`http://localhost:8080/pets/${petId}`)
      .then(response => response.json())
      .then(pet => {
          setCurrentPet(pet);
          fetch(`http://localhost:8080/variants/${pet.variant}`)
            .then(response => response.json())
            .then(variant => setCurrentStage(variant.stage))
            .catch(error => console.error(error)); 
        })
      .catch(error => console.error(error)); 
    }

    let blocked = false;
    
    const feedPet = (selectedFoodId) => {
        if (blocked) return;
        blocked = true;
        //back end fetch to feed foodId to petId
        setFoodId(selectedFoodId)
        const timer = setTimeout(() => {
            setFoodId(0);
            loadPet();
            blocked = false;
            }, 4000);
        return () => clearTimeout(timer);
    }

    useEffect(loadPet, [petId]);

    return (
        <>
            <div className="break"/>
            <h1 className="break center-text">TAMA-NOT-CHI</h1>
            <section id="banner" className="middle-flex break gap">
                <div id="banner__stage" className="pixel-box center-text">
                    {currentStage}
                </div>
                <div id="banner__name" className="pixel-box center-text">
                    {currentPet.name}
                </div>
                <div id="banner__money" className="pixel-box center-text">
                    {currentPet.money}
                </div>
            </section>
            <div className="middle-flex gap">

                <PetContainer pet={currentPet} foodId={foodId} />
                <ActivityContainer pet={currentPet} feedPet={feedPet}/>

            </div>
        </>
    );
}

export default GamePage;