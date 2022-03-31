import { useEffect, useState } from "react";
import House from "../components/House";
import Food from "../components/Food";


const ActivityContainer = ({currentPet,currentHouseNum, feedPet}) => {

// what to display intially
const [showHouse, setShowHouse] = useState(true);
const [showShop, setShowShop] = useState(false);
const [showGame, setShowGame] = useState(false);

// function that turns all buttons to their opposite

const handleShowHouseClick = () => {
    setShowShop(false)
    setShowGame(false)
    setShowHouse(true)
}

const handleShowShopClick = () => {
    setShowShop(true)
    setShowGame(false)
    setShowHouse(false)
}

const handleShowGameClick = () => {
    setShowShop(false)
    setShowGame(true)
    setShowHouse(false)
}


// fetch all food here, pass as prop to shop

const [allFoods, setAllFoods] = useState([]);

const getFoods = () => {
    fetch("http://localhost:8080/foods")
        .then(response => response.json())
        .then(foods => {
            const newFoodList = [];
            for (const food of foods) {
                newFoodList.push(
                    <Food
                        key={food.foodId}
                        id={food.foodId}
                        name={food.name}
                        price={food.price}
                        energy={food.energy}
                        happiness={food.happiness}
                        heals={food.heals}
                        unhealthy={food.unhealthy}
                        feedPet={feedPet}
                    />
                );
            }
            setAllFoods(...allFoods, newFoodList);
        })
        // catch error
        .catch(error => console.error(error))   
}

useEffect(getFoods, []);

    return(
        <section>
            {/* conditional render */}
            <div className="pixel-box display break">
           { showHouse ? <House currentHouseNum={currentHouseNum}/> : null}
           { showShop ? <>{allFoods}</> : null}
           { showGame ? <p>an amazing game</p> : null}
            </div>
            <div className="middle-flex break">
                <button onClick={handleShowHouseClick} id="house-btn" className="btn pixel-box selected">House</button>
                <button onClick={handleShowShopClick} id="shop-btn" className="btn pixel-box">Shop</button>
                <button onClick={handleShowGameClick} id="game-btn" className="btn pixel-box">Game</button>
            </div>
        </section>
    );
}

export default ActivityContainer;