import { useState, useEffect } from "react";

const House = ({houseNum, money, upgradeHouse, mood}) => {

    const [currentHouse, setCurrentHouse] = useState({
        "id": 3,
        "name": "bungalow",
        "price": 10,
        "happiness_bonus": 0,
        "size": 1,
        "upgrade": 2
    });
    const [upgradePrice, setUpgradePrice]= useState(99);
    const [canUpgrade, setCanUpgrade] = useState(false);

    // fetch the house
    const loadHouse = () => {
        fetch(`http://localhost:8080/houses/${houseNum}`)
            .then(response => response.json())
            .then(house => {
                setCurrentHouse(house);
                if(!house.upgrade||mood==5){
                    setCanUpgrade(false);
                }else{
                    setCanUpgrade(true);
                    fetch(`http://localhost:8080/houses/${house.upgrade}`)
                        .then(res=> res.json())
                        .then(upgrade => {
                            if(upgrade){
                                setUpgradePrice(upgrade.price);
                            }else{
                                setUpgradePrice(0)
                            }
                        })
                }               
            }) // cleaned up state a bit
            .catch(error => console.error(error)); 
        }

    useEffect(loadHouse, [houseNum,mood]);
    
    const handleClickUpgrade = () => {
        console.log(money);
        if(money >= upgradePrice && canUpgrade){
            upgradeHouse();
            console.log("upgrading house function performed");
        } //don't load house in function. load pet is the reference. use effect loads house.
    }  

    return(
        <div className="column-flex">
            <div id="house-info" className="center-text">
                <h2 className="break">{currentHouse.name}</h2>
                {canUpgrade? <button id="upgrade-btn" className="pixel-box" onClick={handleClickUpgrade} >Upgrade- {upgradePrice}</button>: null}
            </div>
            <img className="sprite" alt="alternate image of house" src={require(`../sprites/houses/${currentHouse.id}.png`)}/> 
        </div>
    );
}

export default House;