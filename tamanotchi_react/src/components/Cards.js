import { useState } from 'react'
import Card from './Card'
import GameComplete from './GameComplete'

function Cards({wonGame, handleSetGame}){
    const [items, setItems] = useState([
        { id: 1, img: '/img/candy.png', stat: "" },
        { id: 1, img: '/img/candy.png', stat: "" },
        { id: 2, img: '/img/medicine.png', stat: "" },
        { id: 2, img: '/img/medicine.png', stat: "" },
        { id: 3, img: '/img/carrot.png', stat: "" },
        { id: 3, img: '/img/carrot.png', stat: "" },
        { id: 4, img: '/img/bread.png', stat: "" },
        { id: 4, img: '/img/bread.png', stat: "" },
        { id: 5, img: '/img/fish.png', stat: "" },
        { id: 5, img: '/img/fish.png', stat: "" },
        { id: 6, img: '/img/apple.png', stat: "" },
        { id: 6, img: '/img/apple.png', stat: "" },
        { id: 7, img: '/img/mansion.png', stat: "" },
        { id: 7, img: '/img/mansion.png', stat: "" },
        { id: 8, img: '/img/house.png', stat: "" },
        { id: 8, img: '/img/house.png', stat: "" }
    ].sort(() => Math.random() - 0.5)) // randomly assign cards each time page is refreshed/game restarted


    // audio attempt
    let audio = new Audio("/audio/We'll-Be-Right-Back.mp3")

    const startWinningAudio = () => {
    audio.play()
  }

    // saving the index of the previous card clicked
    const [prev, setPrev] = useState(-1)

    const [gameWonDisplay, setGameWonDisplay] = useState(false)
    const [gameComplete, setGameComplete] = useState(false)

    function check(current){
        // compares the second cards id to the first cards id
        if(items[current].id == items[prev].id){
            // if it's a match, both cards are given the "correct" className (css attributes)
            items[current].stat = "correct"
            items[prev].stat = "correct"
            setItems([...items])
            setPrev(-1)
        }else{
            items[current].stat = "wrong"
            items[prev].stat = "wrong"
            setItems([...items])
            setTimeout(() => {
                items[current].stat = ""
                items[prev].stat = ""
                setItems([...items])
                setPrev(-1)
            }, 1000)
        }
        let counter = 0;
        for (let i = 0; i<16; i++){
            if (items[i].stat === "correct"){
                counter+=1
            }
        }
        if (counter === 16){
            startWinningAudio();
            wonGame();
            console.log("Player has won!")
            setGameComplete(true);
            setGameWonDisplay(true)
            setTimeout(() => {
                setGameComplete(false)
                setGameWonDisplay(false)
                handleSetGame()
            }, 2000);
        }
    }

    // the index of the card in the array is parsed in
    function handleClick(id){
        
        // prev set to -1 to indicate this is the first card (of a potential pair) being clicked.
        if(prev === -1){
            // the card we selected is given the "active" stat 
            // and given the active class in the card component below
            items[id].stat = "active"
            // now our original state is updated with our updated item
            setItems([...items])
            // prev is now set to the id of the item/card clicked
            setPrev(id)
        }else{
            // the second card picked calls the 'check' function
            // and passes in the item/card index
            check(id)
        }
    }

    return (
        <div>
            
        <div className="container">
           
             
            { items.map((item, index) => (
                //  'id' is just this index within the map/array
                // handleclick function is passed down
                <Card key={index} item={item} id={index} handleClick={handleClick} />
            )) }
        </div>
            {gameWonDisplay ? <GameComplete/> : null }
        </div>
    )
}

export default Cards