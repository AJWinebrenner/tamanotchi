import { useState, useEffect } from "react";
import House from "../components/House";

const ActivityContainer = () => {

    return(
        <section>
            {/* conditional render */}
            <div className="pixel-box display break">
                <House/>
            </div>
            <div className="middle-flex break">
                <button id="house-btn" className="btn pixel-box selected"></button>
                <button id="shop-btn" className="btn pixel-box"></button>
                <button id="game-btn" className="btn pixel-box"></button>
            </div>
        </section>
    );
}

export default ActivityContainer;