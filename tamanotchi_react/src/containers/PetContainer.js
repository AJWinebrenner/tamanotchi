import { useState, useEffect } from "react";
import Bar from "../components/Bar";
import PetDisplay from "../components/PetDisplay";

const PetContainer = () => {

    return(
        <section>
            {/* placeholder values*/}
            <PetDisplay variant={3} mood={1} food={0}/>
            <Bar value={5} max={10} className={"happiness-bar"}/>
            <Bar value={5} max={10} className={"happiness-bar"}/>
        </section>
    );
}

export default PetContainer;