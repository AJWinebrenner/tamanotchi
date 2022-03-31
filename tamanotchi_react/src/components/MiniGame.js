import {React, Component, useEffect, useRef, useState } from "react";
import '../App.css';

const LEFT_KEY = ["27", "LeftKey"];
const RIGHT_KEY = ["27", "RightKey"];

// var block = document.getElementById("minigame-block")

const MiniGame = () => {

    const chick = document.querySelector("#minigame-chick")

    function moveLeft(){
        if (chick.classList != "animate-left"){
            chick.classList.add("animate-left")}
        setInterval(function(){chick.classList.remove("animate-left")},600)
    }

    function moveRight(){
        if (chick.classList != "animate-right"){
            chick.classList.add("animate-right")}
        setInterval(function(){chick.classList.remove("animate-right")},600)
    }

    
    return (
        <>
        <h1 id="minigame-title">MiniGame</h1>
            <div id="minigame-sky">
                <div id="minigame-chick"></div>
                <div id="minigame-block"></div>
                <button onClick={moveLeft}>Left</button>
                <button onClick={moveRight}>Right</button> 
            </div>
        </>
        
    )
}

export default MiniGame;