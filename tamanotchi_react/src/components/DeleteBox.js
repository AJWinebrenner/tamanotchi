const DeleteBox = ({id, name, handleCancel, handleDelete}) => {

    return(
        <div id="pop_up" className="pixel-box column-flex center-text gap">
            <h2 className="caps">
                {`ARE YOU SURE YOU WANT TO DELETE ${name} FOREVER?`}
            </h2>
            
            <div className="middle-flex gap">
                <button className="pixel-box btn" onClick={() => handleDelete(id)}>DELETE</button>
                <button className="pixel-box btn" onClick={handleCancel}>CANCEL</button>
            </div>
            <p>THIS CANNOT BE UNDONE</p>
        </div>
    )
}

export default DeleteBox;