import { useState, useEffect, useMemo } from "react";

const Bar = ({value, max, className, foodId}) => {

    // const [happinessFromFood, setHappinessFromFood]= useState(5);

    // const loadingFoodHappiness= () => {
    //     fetch(`http://localhost:8080/foods/${foodId}`)
    //     .then(response=> response.json())
    //     .then(data=> setHappinessFromFood(data.happiness))
    // }
    // useEffect(loadingFoodHappiness,[foodId])


    const root = document.documentElement;

    const calcFraction = (n, d) => {
        let f = (n/d);
        if (typeof f == 'number') {
            return f;
        } else {
            return 0;
        }
    }

    const fraction = useMemo(() => calcFraction(value, max), [value,max]);

    const setCss = () => {
        console.log(value);
        console.log(fraction);
        root.style.setProperty(`--${className}-size`, fraction)
    }

    useEffect(setCss, [fraction])

   


    return(
        <div className={`pixel-box bar break ${className}`}></div>
    );
}

export default Bar;