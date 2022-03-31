import { useState, useEffect } from "react";

const House = ({houseNum}) => {

    const [currentHouse, setCurrentHouse] = useState({
        "id": 3,
        "name": "bungalow",
        "price": 10,
        "happiness_bonus": 0,
        "size": 1,
        "upgrade": 2
    });

    // fetch the house
    const loadHouse = () => {
        fetch(`http://localhost:8080/houses/${houseNum}`)
            .then(response => response.json())
            .then(house => {
                setCurrentHouse(house);
            }) // cleaned up state a bit
            .catch(error => console.error(error)); 
        }

    useEffect(loadHouse, [houseNum]);

    return(
        <div className="column-flex">
            {/* I assume will eventually be an image of the house */}
            <h2>{currentHouse.name}</h2>
            <img className="sprite" alt="alternate image of house" src={require(`../sprites/houses/${currentHouse.id}.png`)}/> 
        </div>
    );
}

export default House;