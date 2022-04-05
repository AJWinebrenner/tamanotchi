import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const SaveFile = ({id, name, mood, exp, variantId, setId}) => {
 
    const [crown, setCrown] = useState(false);

    let navigate = useNavigate(); 
    const routeChange = () => { 
        let path = `/game`; 
        navigate(path);
    }

    useEffect(() => {
        fetch(`http://localhost:8080/variants/${variantId}`)
            .then(response => response.json())
            .then(variant => {
                if (exp >= variant.max_exp) {
                    setCrown(true);
                }
            })
            .catch(error => console.error(error)); 
    }, [])

    return(
        // re the onClick - 1) we need to decide if want onclick to apply to the div or the image. If image, it'small area. If div, it's all the way out to black border. 
        // 2) This is NOT ACCESSIBLE to screenreaders etc but other ways to do this are much more complex
        <div 
            onClick={() => {
                setId(id);
                routeChange();
            }} 
            className="pixel-box save column-flex"
        >
            {(mood == 5)? <img className="icon corner" src={require(`../sprites/icons/ghost.png`)}/> : (crown? <img className="icon corner" src={require(`../sprites/icons/crown.png`)}/> : null)}
            <div className="save-header break middle-flex gap">
                <h2>{name}</h2>
            </div>
            <img className="sprite" src={require(`../sprites/variants/${variantId}/${mood}.gif`)}/>
        </div>
    );
    
}

export default SaveFile;