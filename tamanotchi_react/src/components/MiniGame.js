import {React, Component, useEffect, useRef, useState } from "react";
import '../App.css';
import Cards from "./Cards";

const MiniGame = ({wonGame}) => {

    const [startGame, setStartGame] = useState(false)

    const handleSetGame = () => {
        setStartGame(!startGame)
    }
    return (

    <div className="viewboxactivity">
        { startGame ? null : <button onClick={handleSetGame}>Start Game!</button>}
        { startGame ? <Cards wonGame={wonGame} handleSetGame={handleSetGame}/> : null}
    </div>
    )
}

export default MiniGame;