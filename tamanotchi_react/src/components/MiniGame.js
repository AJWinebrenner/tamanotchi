import {React, Component, useEffect, useRef, useState } from "react";
import '../App.css';
import Cards from "./Cards";

const MiniGame = () => {

    const [startGame, setStartGame] = useState(false)

    const handleStartButtonClick = () => {
        setStartGame(!startGame)
    }
    return (

    <div className="viewboxactivity">
        { startGame ? null : <button onClick={handleStartButtonClick}>Start Game!</button>}
        { startGame ? <Cards/> : null}
    </div>
    )
}

export default MiniGame;