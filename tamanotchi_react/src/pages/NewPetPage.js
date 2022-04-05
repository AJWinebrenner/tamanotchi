import { useEffect, useState } from "react";

const NewPetPage = ({setPetId}) => {

    const[animation, setAnimation] = useState("egg");
    const[babies, setBabies] = useState([]);
    const[hatched, setHatched] = useState(false);
    const[babyId, setBabyId] = useState(3);
    const[petName, setPetName] = useState("");


    const pickEgg = () => {
        fetch(`http://localhost:8080/variants/`)
        .then(response => response.json())
        .then(variants => { 
            const babyObjects = variants.filter(variant => (variant.stage===1));
            setBabies(babyObjects.map(baby => (baby.id)));
        })
        .catch(error => console.error(error)); 
    }


    let clicked = false;
    const handleEggClick = async() => {
        if (clicked) {
            return
        }
        clicked = true; 
        setAnimation("hatch");
        const timer = setTimeout(() => {
            if(babies.length > 0) {
                setBabyId(babies[Math.floor(Math.random() * babies.length)]);
            }
            setAnimation("poof");
            }, 4000);
           
        const timer2 = setTimeout(() => {
            setHatched(true);
            }, 7000);
        
            // handleFormSubmit();    
        //submit form - take to gamePage 

        //set to id - like for saveCards 
        // return () => clearTimeout(timer);
    }

    const handleNameChange = (e) => {
        setPetName(e.target.value);
    }

    const handleFormSubmit = (e) => {
        e.preventDefault();
        if (petName) {
            fetch(`http://localhost:8080/pets/`, {
                method:"POST",
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                "name": petName,
                "house": 3,
                "variant": babyId,
                "happiness": 1,
                "energy": 10,
                "max_happiness": 10,
                "max_energy": 10,
                "mood": 1,
                "exp": 0,
                "money": 10
            }),
           })
            .then(response => response.json())
            .then(variants => { 
                const babyObjects = variants.filter(variant => (variant.stage===1));
                setBabies(babyObjects.map(baby => (baby.id)));
            })
            .catch(error => console.error(error));     
            setPetId();
        }
    }
    

    useEffect(pickEgg, []);

    console.log("new pet")
    if (!hatched) {
        return(
            <>
            <div className="break"></div>
            <h1 className="center-text">New Pet</h1>
            <section className="column-flex">
                <img onClick={handleEggClick} className="sprite" src={require(`../sprites/misc/${animation}.gif`)} />
            </section>
            </>
        );

    } else {
        return(
            <>
                <div className="break"></div>
                <h1 className="center-text">Welcome!</h1>
                <section className="column-flex">
                    <img className="sprite" src={require(`../sprites/variants/${babyId}/2.gif`)}/>
                    <form onSubmit={handleFormSubmit} id="new-pet-name-form">
                        <label htmlFor="name-input">Name:</label>
                        <input onChange={handleNameChange} type="text" id="name-input" name="name-input" value={petName} placeholder="Enter Name Here"/>
                        <input type="submit"></input>
                    </form>
                </section>
            
            </>
        );
    }
}

export default NewPetPage;