import { useState, useEffect } from "react";

const House = ({currentHouse}) => {

    
    return(
        <>
            {/* I assume will eventually be an image of the house */}
            <p>image of the house</p>
            <img className="sprite" alt="alternate image of house" src={require(`../sprites/houses/1.png`)}/> 
        </>
    );
}

export default House;