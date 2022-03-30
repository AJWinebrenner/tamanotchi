import { useState, useEffect } from "react";

const Bar = ({value, max, className}) => {

    const root = document.documentElement;

    const setCss = () => {
        console.log(root);
        let fraction = value/max;
        root.style.setProperty(`--${className}-size`, fraction);
    }

    return(
        <div className={`pixel-box bar break ${className}`}></div>
    );
}

export default Bar;