import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const NewPetPage = ({setPetId}) => {

    const[animation, setAnimation] = useState("egg");
    const[babies, setBabies] = useState([]);
    const[hatched, setHatched] = useState(false);
    const[babyId, setBabyId] = useState(3);
    const[petName, setPetName] = useState("");

    let navigate = useNavigate(); 
    const routeChange = () => { 
        let path = "/game"; 
        navigate(path);
    }

    const goBack = () => {
        navigate("/");
    }

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
            }, 3500);
           
        const timer2 = setTimeout(() => {
            setHatched(true);
            }, 6500);
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
            .then(pet => { 
                setPetId(pet.id);
                routeChange(); 
            })
            .catch(error => console.error(error));     
        } else {
            alert("Your new pet needs a name!");
        }
    }
    

    useEffect(pickEgg, []);

    console.log("new pet")
    if (!hatched) {
        return(
            <>
                <div className="break"/>
                <h1 className="big-break center-text">TAMA-NOT-CHI</h1>
                <h2 className="center-text big-break">CLICK THE EGG</h2>
                <section className="column-flex big-break">
                    <img onClick={handleEggClick} className="sprite" src={require(`../sprites/misc/${animation}.gif`)} />
                </section>
                <div className="middle-flex">
                    <button id="back-btn" className="btn pixel-box" onClick={goBack}>Back</button>
                </div>
            </>
        );

    } else {
        return(
            <>
                <div className="break"/>
                <h1 className="big-break center-text">TAMA-NOT-CHI</h1>
                <h2 className="center-text big-break">Welcome!</h2>
                <section className="column-flex big-break">
                    <img className="sprite big-break" src={require(`../sprites/variants/${babyId}/2.gif`)}/>
                    <form className="middle-flex gap" onSubmit={handleFormSubmit} id="new-pet-name-form">
                        <input id="submit-box" className="pixel-box" onChange={handleNameChange} type="text" name="name-input" value={petName} placeholder="Give me a name!"/>
                        <input id="submit-btn" className="pixel-box btn" type="submit" value="OK"/>
                    </form>
                </section>
            </>
        );
    }
}

export default NewPetPage;