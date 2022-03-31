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
        <div className = " middle-flex break">
            <h3>{name}:</h3> <span>{price}</span>
            <button id={id} onClick={handleEatingClick}>Eat!</button>
            {/* <img className="food" src={require(`../sprites/foods/${id}.png`)}/> */}
        </div>
    );
}

export default Food;