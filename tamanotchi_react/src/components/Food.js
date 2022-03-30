import { useState, useEffect } from "react";

const Food = ({id, name, price, energy, happiness, heals, unhealthy}) => {

    const handleEatingClick = () => {
        // trigger function higher up passed in but give it food 'id'
    }
    return(
        <div>
            <h3>{name}</h3>
            <p>Price: {price}</p>
            <button onClick={handleEatingClick}>Eat!</button>
            {/* <img className="food" src={require(`../sprites/foods/${id}.png`)}/> */}
        </div>
    );
}

export default Food;