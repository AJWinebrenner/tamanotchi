import { useState, useEffect } from "react";
import Bar from "../components/Bar";
import PetDisplay from "../components/PetDisplay";

const PetContainer = ({pet,foodId}) => {
// console.log(pet);
    // test
    // const [fakePet, setFakePet] = useState(
    //     {
    //         "id": 1,
    //         "name": "jeff",
    //         "house": 3,
    //         "variant": 3,
    //         "happiness": 1,
    //         "energy": 10,
    //         "max_happiness": 10,
    //         "max_energy": 10,
    //         "mood": 1,
    //         "exp": 0,
    //         "money": 15
    //     }
    // )

    // console.log(pet);

    return(
        <section>
            {/* placeholder values*/}
            <PetDisplay variant={pet.variant} mood={pet.mood} foodId={foodId}/>
            <Bar value={pet.happiness} max={pet.max_happiness} className={"happiness"}/>
            <Bar value={pet.energy} max={pet.max_energy} className={"energy"}/>
        </section>
    );
}

export default PetContainer;