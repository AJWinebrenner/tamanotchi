  
  // remember, 'id' is just the index of the map/array
function Card({item, id, handleClick}){
    // by default item.stat (meaning status) === ""
    // cards are initially all given the "active" class
    // as soon as they render each 'card' component for the first time this is removed
    // by default this is falsy, and each item.stat is "" and each card's class is just "card"
    const itemClass = item.stat ? " active " + item.stat : ""

    // console.log(itemClass)
    
    return (
        // each card is given the ".card" class
        // but given ".card.active" (turns card around) because of the css applied

        // on click, the handleClick is called with the index of the card clicked
        <div className={"card" + itemClass} onClick={() => handleClick(id)}>

            {/* each image found by parsing the string - item.img */}
            <img className="icon" src={item.img} alt="" />
        </div>
    )
}

export default Card;