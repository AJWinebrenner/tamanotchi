import { useState, useEffect } from "react";
import ActivityContainer from "../containers/ActivityContainer";
import PetContainer from "../containers/PetContainer";

const GamePage = ({petId}) => {

    const [currentPet, setCurrentPet] = useState()

    return (
        <>
            <section id="banner" className="middle-flex break">
                <div id="banner__stage" className="pixel-box center-text">
                    1
                </div>
                <div id="banner__name" className="pixel-box center-text">
                    JEFF
                </div>
                <div id="banner__money" className="pixel-box center-text">
                    999
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