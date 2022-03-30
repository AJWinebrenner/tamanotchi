import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const SaveFile = ({id, name, variant, setId}) => {
 
    let navigate = useNavigate(); 
    const routeChange = () => { 
        let path = `/game`; 
        navigate(path);
    }

    return(
        // re the onClick - 1) we need to decide if want onclick to apply to the div or the image. If image, it'small area. If div, it's all the way out to black border. 
        // 2) This is NOT ACCESSIBLE to screenreaders etc but other ways to do this are much more complex
        <div onClick={() => {
            setId(id);
            routeChange();
            }} className="pixel-box card column-flex">
            <h2 className="break">
                {name}
            </h2>
            <img className="sprite" src={require(`../sprites/variants/${variant}/1.gif`)}/>
        </div>
    );
    
}

export default SaveFile;