import { useNavigate } from "react-router-dom";

const NewSave = () => {

    let navigate = useNavigate(); 
    const routeChange = () => { 
        let path = `/new`; 
        navigate(path);
    }

    return(
        <div 
            onClick={() => {
            routeChange();
            }} className="pixel-box save column-flex"
        >
            <div className="save-header break middle-flex gap">
                <h2>New Pet</h2>
            </div>
            <img className="sprite" src={require(`../sprites/misc/egg.gif`)}/>
        </div>
    );
    
}

export default NewSave;