import { useState, useEffect, useRef } from "react";
import ActivityContainer from "../containers/ActivityContainer";
import PetContainer from "../containers/PetContainer";
import { useNavigate } from "react-router-dom";

const GamePage = ({petId, toggleAudio, audioPlaying}) => {

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
    const [currentVariant, setCurrentVariant] = useState({
            "name": "-",
            "stage": 1,
            "fave_food": 1,
            "max_exp": 99,
            "upgrade": 2,
            "id": 3
    });
    const [foodId, setFoodId] = useState(0);
    const [idleEmote, setIdleEmote] = useState(0);
    
    const loadPet = () => {
    fetch(`http://localhost:8080/pets/${petId}`)
        .then(response => response.json())
        .then(pet => {
            setCurrentPet(pet);
            fetch(`http://localhost:8080/variants/${pet.variant}`)
            .then(response => response.json())
            .then(variant => setCurrentVariant(variant))
            .catch(error => console.error(error)); 
        })
        .catch(error => console.error(error)); 
    }

    const checkIdleEmote = () => {
        if (currentPet.exp >= currentVariant.max_exp && !currentVariant.upgrade && currentPet.mood != 5) {
            setIdleEmote("crown");
        } else {
            setIdleEmote(0);
        }
    }

    let blocked = false;
    const feedPet = (selectedFoodId) => {
        if (blocked) return;
        if (currentPet.mood == 5) return;
        blocked = true;
        //back end fetch to feed foodId to petId
        setFoodId(selectedFoodId);
        fetch(`http://localhost:8080/pets/${petId}/feed/${selectedFoodId}`, {
            method: "PATCH"
        })
        //
        const timer = setTimeout(() => {
            setFoodId(0);
            loadPet();
            blocked = false;
            }, 2000);
        return () => clearTimeout(timer);
    }

    const upgradeHouse = () => {
        fetch(`http://localhost:8080/pets/${petId}/upgrade`, {
            method: "PATCH"
        })
        .then(loadPet)
    }

    const wonGame = () => {
        fetch(`http://localhost:8080/pets/${petId}/game-won`, {
            method: "PATCH"
        })
        .then(loadPet)
    }

    const step = () => {
        if (currentPet.mood == 5) return;
        fetch(`http://localhost:8080/pets/${petId}/step`, {
            method: "PATCH"
        })
        .then(loadPet)
    }

    const stepTime = useRef(null);
    useEffect(() => {
            stepTime.current = setInterval(() => {
                step();
                console.log("step");
            }, 20000);
            return() => {
                clearInterval(stepTime.current);
            }
    }, [])

 // ----------------------------------- 
    //audio attempt
    let mainAudio = new Audio("/audio/tamagotchi-main-theme-v1.mp3")

    const mainAudioFunc = () => {
         if (!audioPlaying){
            toggleAudio();
            mainAudio.volume = 0.1;
            mainAudio.muted = false;
            mainAudio.play()
            mainAudio.loop = true
        }
    }
    mainAudioFunc();
    // -----------------------------------

    let navigate = useNavigate(); 
    const routeChange = () => { 
        let path = "/"; 
        navigate(path);
    }

    useEffect(loadPet, [petId]);
    useEffect(checkIdleEmote, [currentVariant]);

    return (
        <>
            <div className="break"/>
            <h1 className="break center-text">TAMA-NOT-CHI</h1>
            <section id="banner" className="middle-flex break gap">
                <div id="banner__stage">
                <div className="crown"/>
                    <p className="onTop center-text">{currentVariant.stage}</p>
                </div>
                <div id="banner__name" className="pixel-box center-text">
                    {currentPet.name}
                </div>
                <div id="banner__money">
                    <div className="coin"/>
                    <p className="onTop center-text">{currentPet.money}</p>
                </div>
            </section>
            <div className="middle-flex gap">

                <PetContainer pet={currentPet} foodId={foodId} idleEmote={idleEmote}/>
                <ActivityContainer pet={currentPet} feedPet={feedPet} upgradeHouse={upgradeHouse} wonGame={wonGame}/>

            </div>
            <button id="back-btn" className="btn pixel-box center-box break" onClick={routeChange}>Back</button>

        </>
    );
}

export default GamePage;