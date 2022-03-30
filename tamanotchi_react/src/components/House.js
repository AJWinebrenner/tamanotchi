import { useState, useEffect } from "react";

const House = (currentHouse) => {

    return(
        <>
            {currentHouse.name}
            {/* I assume will eventually be an image of the house */}
            <p>image of the house</p>
            {/* <img className="food" src={require(`../sprites/houses/${currentHouse.id}.png`)}/>  */}
        </>
    );
}

export default House;