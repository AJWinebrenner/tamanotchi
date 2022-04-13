const DeleteBox = ({id, name, setPop_up}) => {

    return(
        <div id="pop_up" className="pixel-box column-flex center-text gap">
            <h2>
                {`ARE YOU SURE YOU WANT TO DELETE ${name} FOREVER?`}
            </h2>
            
            <div className="middle-flex gap">
                <button className="pixel-box btn">DELETE</button>
                <button className="pixel-box btn" onClick={() => setPop_up(null)}>CANCEL</button>
            </div>
        </div>
    )
}

export default DeleteBox;