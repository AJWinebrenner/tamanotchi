import { useState, useEffect } from "react";

const SaveFile = (pet) => {
    
    return(

        <div className="pixel-box card center-text">
            <h2>
                {`${pet.name}`}
            </h2>
            <img className="sprite" src={require(`../sprites/variants/${pet.variant}/1.gif`)}/>
        </div>
    );
    
}

export default SaveFile;