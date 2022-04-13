import { useEffect, useState } from "react";
import DeleteBox from "../components/DeleteBox";
import NewSave from "../components/NewSave";
import SaveFile from "../components/SaveFile";

const HomePage = ({setPetId}) => {

    const [saveCards, setSaveCards] = useState([]);
    const [deleteState, setDeleteState] = useState(false);
    const [pop_up, setPop_up] = useState(null);

    const showPop_up = (id, name) => {
        if (pop_up == null) {
            setPop_up(<DeleteBox id={id} name={name} setPop_up={setPop_up} handleCancel={toggleDelete} handleDelete={deletePet}/>)
        }
    }

    const toggleDelete = () => {
        setDeleteState(!deleteState);
        setPop_up(null);
    }

    const deletePet = (id) => {
        fetch(`http://localhost:8080/pets/${id}`, {
                method:"DELETE"
            })
        .then(() => {
            setDeleteState(false)
            setPop_up(null);
        })
    }
    
    const getPets = () => {
        fetch("http://localhost:8080/pets")
            .then(response => response.json())
            .then(pets => {
                const newPetList = [];
                for (const pet of pets) {
                    newPetList.push(
                        <SaveFile
                            key={pet.id}
                            id={pet.id}
                            name={pet.name}
                            mood={pet.mood}
                            exp={pet.exp}
                            variantId={pet.variant}
                            setId={setPetId}
                            del={deleteState}
                            showPop_up={showPop_up}
                        />
                    );
                }
                setSaveCards(newPetList);
            })
            // catch error
            .catch(error => console.error(error))   
    }

    useEffect(getPets, [deleteState]);

    return(
        <>
            {pop_up}
            <div className="break"/>
            <h1 className="big-break center-text">TAMA-NOT-CHI</h1>
            <h2 className="center-text">Your Pets</h2>
            <section className="save-flex">
                {saveCards}
                <NewSave key={"newPet"}/>
            </section>
            <div className="middle-flex break">
                <button id="del-btn" className="btn pixel-box" onClick={toggleDelete}>
                    {deleteState ? "CANCEL" : "DELETE"}
                </button>
            </div>
        </>
    );
}

export default HomePage;