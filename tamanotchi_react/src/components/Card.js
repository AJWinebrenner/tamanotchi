  
function Card({item, id, handleClick}){
    const itemClass = item.stat ? " active " + item.stat : ""

    return (
        <div className={"card" + itemClass} onClick={() => handleClick(id)}>
            <img id="pet-sprite" className="sprite" src={item.img} alt="" />
        </div>
    )
}

export default Card