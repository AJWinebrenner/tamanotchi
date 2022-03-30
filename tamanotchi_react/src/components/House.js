import { useState, useEffect } from "react";

const House = (currentHouse) => {

    return(
        <>
            {currentHouse.name}
            {/* I assume will eventually be an image of the house */}
            <p>image of the house</p>
        </>
    );
}

export default House;