import { useState, useEffect } from "react";

const Food = ({id, name, price, energy, happiness, heals, unhealthy, feedPet, money}) => {

    console.log(money);
    const handleEatingClick = (event) => {
        console.log(event.target.id)
        console.log(money);
        if(money >= price){
            feedPet(event.target.id)
        }
        // trigger function higher up passed in but give it food 'id'
    }
    return(
        <div className = "space-flex break">
            <div className="middle-flex">
                <img className="coin icon" src={require(`../sprites/icons/coin.png`)}></img>
                <p className="coin-text">{price}</p> 
                <p>{name}</p>
                
            </div>
            <button id={id} className="bare-btn" onClick={handleEatingClick}>
                <img id={id} className="icon" src={require(`../sprites/foods/${id}.png`)}/>
            </button>
        </div>
    );
}

export default Food;