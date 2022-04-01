import { useState, useEffect } from "react";

const House = ({houseNum, money, upgradeHouse}) => {

    const [currentHouse, setCurrentHouse] = useState({"id": 3,"name": "bungalow","price": 10,"happiness_bonus": 0,"size": 1,"upgrade": 2});
    const [upgradePrice, setUpgradePrice]= useState(99);
    const [canUpgrade, setCanUpgrade] = useState(false);

    // fetch the house
    const loadHouse = () => {
        fetch(`http://localhost:8080/houses/${houseNum}`)
            .then(response => response.json())
            .then(house => {
                setCurrentHouse(house);
                if(house.upgrade==0){
                    setCanUpgrade(false)
                }else{
                    setCanUpgrade(true)
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

    useEffect(loadHouse, [houseNum]);

    //Create another function 
    //Put request to update the house of the pet 
    
    const handleClickUpgrade = () => {
        console.log(money);
        if(money >= upgradePrice&&currentHouse.upgrade!=0){
            upgradeHouse()
            console.log("upgrading house function performed")
        }else{
            console.log("no more upgrade")
        }
        if(currentHouse.upgrade==0){
            setCanUpgrade(false)
        }
        loadHouse()
    }



    

    return(
        <div className="column-flex">
            {/* I assume will eventually be an image of the house */}
            <h2>{currentHouse.name}</h2>
            {canUpgrade? <button id="upgrade-btn" onClick={handleClickUpgrade} >Upgrade- {upgradePrice}</button>: null}
            <img className="sprite" alt="alternate image of house" src={require(`../sprites/houses/${currentHouse.id}.png`)}/> 
        </div>
    );
}

export default House;