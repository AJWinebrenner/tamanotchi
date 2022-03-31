import { useState, useEffect } from "react";
import ActivityContainer from "../containers/ActivityContainer";
import PetContainer from "../containers/PetContainer";

const GamePage = ({petId}) => {

    const[foodId, setFoodId]= useState(0);

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
    
    const upgradeHouse = (updatedPet) => { 
        console.log("upgrading house")
            fetch ("http://localhost:8080/pets", {
                method: "PATCH", 
                headers:{
                    'Content-type':'application/json'
                },
                body: JSON.stringify(updatedPet)
    
                
            })
        }
    
    

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
    // const [currentMoney, setCurrentMoney] = useState(0);
    
        // put in money and stage in state 
    
    const loadPet = () => {
    console.log(currentPet);
    fetch(`http://localhost:8080/pets/${petId}`)
      .then(response => response.json())
      .then(pet => {
          setCurrentPet(pet);
        //   setCurrentPetName(pet.name);
        //   setCurrentMoney(pet.money);
          fetch(`http://localhost:8080/variants/${pet.variant}`)
            .then(response => response.json())
            .then(variant => setCurrentStage(variant.stage))
            console.log(pet.house)
        //   fetch(`http://localhost:8080/houses/${pet.house}`)
        //     .then(response =>response.json())
        //     .then(house => setCurrentHouse(house))
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
                <ActivityContainer pet={currentPet} feedPet={feedPet} upgradeHouse={upgradeHouse}/>

            </div>
        </>
    );
}


export default GamePage;