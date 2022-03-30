import { useEffect, useState } from "react";
import SaveFile from "../components/SaveFile";

const HomePage = () => {

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
                            name={pet.name}
                            variant={pet.variant}
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
            <h1>Home Page</h1>
            <section className="card-flex">
                {saveCards}
            </section>
        </>
    );
}

export default HomePage;