import { useEffect, useState } from "react";
import NewSave from "../components/NewSave";
import SaveFile from "../components/SaveFile";

const HomePage = ({setPetId}) => {

    const [saveCards, setSaveCards] = useState([]);
    
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
                        />
                    );
                }
                setSaveCards(newPetList);
            })
            // catch error
            .catch(error => console.error(error))   
    }

    useEffect(getPets, []);

    return(
        <>
            <div className="break"/>
            <h1 className="break center-text">TAMA-NOT-CHI</h1>
            <h2 className="center-text">Your Pets</h2>
            <section className="save-flex">
                {saveCards}
                <NewSave key={"newPet"}/>
            </section>
        </>
    );
}

export default HomePage;