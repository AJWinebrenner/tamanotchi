import { useState, useEffect } from "react";

const Food = ({id, name, price, energy, happiness, heals, unhealthy, feedPet, money}) => {

    const handleEatingClick = () => {
        if(money >= price){
            feedPet(id);
        }
        // trigger function higher up passed in but give it food 'id'
    }
    return(
        <button id={id} className="bare-btn space-flex break" onClick={handleEatingClick}>
                <div className="middle-flex">
                    <img className="icon" src={require(`../sprites/icons/coin.png`)}></img>
                    <p className="coin-text">{price}</p> 
                    <p>{name}</p>
                </div>
                <img className="icon" src={require(`../sprites/foods/${id}.png`)}/>
        </button>
    );
}

export default Food;