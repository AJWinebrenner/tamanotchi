import { useState, useEffect } from "react";

const SaveFile = ({name, variant}) => {
    
    return(

        <div className="pixel-box card column-flex">
            <h2 className="break">
                {name}
            </h2>
            <img className="sprite" src={require(`../sprites/variants/${variant}/1.gif`)}/>
        </div>
    );
    
}

export default SaveFile;