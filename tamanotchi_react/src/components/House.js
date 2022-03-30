import { useState, useEffect } from "react";

const House = ({currentHouseNum}) => {

    const [currentHouse, setCurrentHouse] = useState({
        "id": 0,
        "name": "bungalow",
        "price": 10,
        "happiness_bonus": 0,
        "size": 1,
        "upgrade": 2
    });

    const [currentHouseName, setCurrentHouseName] = useState(currentHouse.name);
    const [currentHouseId, setCurrentHouseId] = useState(currentHouseNum);


    // fetch the house
    const loadHouse = () => {
        fetch(`http://localhost:8080/houses/${currentHouseId}`)
          .then(response => response.json())
          .then(house => {
              setCurrentHouseName(house.name);
              setCurrentHouseId(house.id);
            }) // not sure we need this here or after if statement
            .catch(error => console.error(error)); 
          }

          useEffect(loadHouse, [currentHouseId]);
          useEffect(loadHouse, [currentHouseName]);

    return(
        <>
            {/* I assume will eventually be an image of the house */}
            <h2>{currentHouseName}</h2>
            <img className="sprite" alt="alternate image of house" src={require(`../sprites/houses/${currentHouseId}.png`)}/> 
        </>
    );
}

export default House;