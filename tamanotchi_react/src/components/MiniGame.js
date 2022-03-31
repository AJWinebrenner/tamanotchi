import {React, Component, useEffect, useRef, useState } from "react";
import '../App.css';
import Cards from "./Cards";

const MiniGame = () => {
    return (

    <div className="viewboxactivity">
         { <Cards /> ? <Cards/> : null}
    </div>
    )
}

export default MiniGame;