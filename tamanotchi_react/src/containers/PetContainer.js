import Bar from "../components/Bar";
import PetDisplay from "../components/PetDisplay";

const PetContainer = ({pet, foodId, idleEmote}) => {

    return(
        <section>
            <PetDisplay variant={pet.variant} mood={pet.mood} foodId={foodId} idleEmote={idleEmote}/>
            <Bar value={pet.happiness} max={pet.max_happiness} className={"happiness"}/>
            <Bar value={pet.energy} max={pet.max_energy} className={"energy"}/>
        </section>
    );
}

export default PetContainer;