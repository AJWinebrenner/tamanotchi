  
function Card({item, id, handleClick, itemStat, itemImg}){
    const itemClass = itemStat ? " active " + itemStat : ""

    return (
        <div className={"card" + itemClass} onClick={() => handleClick(id)}>
            <img id="pet-sprite" className="sprite" src={require(itemImg)} alt="" />
        </div>
    )
}

export default Card