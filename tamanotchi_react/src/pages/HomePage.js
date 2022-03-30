import { useEffect, useState } from "react";
import SaveFile from "../components/SaveFile";

const HomePage = () => {

    const [petCards, setPetCards] = useState([]);
    
    const getPets = () => {
        fetch("http://localhost:8080/pets")
            .then(response => response.json())
            .then(pets => {
                const newPetList = [];
                for (const pet of pets) {
                    console.log(pet);
                    newPetList.push(
                        <SaveFile
                            key={pet.id}
                            pet={pet}
                            name={pet.name}
                            variant={pet.variant}
                        />
                    );
                }
                console.log(newPetList);
                setPetCards(newPetList);
            })
            // catch error
            .catch(error => console.error(error))   
    }

    useEffect(getPets, []);

    return(
        <>
            <h1>Home Page</h1>
            <section className="card-flex">
                {petCards}
            </section>
        </>
    );
}

export default HomePage;