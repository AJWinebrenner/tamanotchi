import { useState, useEffect } from "react";
import Bar from "../components/Bar";
import PetDisplay from "../components/PetDisplay";

const PetContainer = ({pet}) => {

    // test
    const [fakePet, setFakePet] = useState(
        {
            "id": 1,
            "name": "jeff",
            "house": 3,
            "variant": 3,
            "happiness": 1,
            "energy": 10,
            "max_happiness": 10,
            "max_energy": 10,
            "mood": 1,
            "exp": 0,
            "money": 15
        }
    )

    return(
        <section>
            {/* placeholder values*/}
            <PetDisplay variant={fakePet.variant} mood={fakePet.mood} food={0}/>
            <Bar value={fakePet.happiness} max={fakePet.max_happiness} className={"happiness"}/>
            <Bar value={fakePet.energy} max={fakePet.max_energy} className={"energy"}/>
        </section>
    );
}

export default PetContainer;