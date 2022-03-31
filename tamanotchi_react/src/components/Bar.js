import { useEffect, useMemo } from "react";

const Bar = ({value, max, className}) => {

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