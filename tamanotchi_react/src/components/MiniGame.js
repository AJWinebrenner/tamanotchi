import {React, Component, useEffect, useRef, useState } from "react";
import '../App.css';
import Cards from "./Cards";

const MiniGame = () => {
    return (

    <div className="minigame-container">
      <h1>Mini-Game</h1>
         { <Cards /> ? <Cards/> : null}
    </div>
        
    )
}

export default MiniGame;