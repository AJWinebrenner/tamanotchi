

CREATE TABLE foods(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    price INT,
    energy INT,
    happiness INT,
    isUnhealthy BOOLEAN,
    heals BOOLEAN
    );
CREATE TABLE houses(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    price INT,
    happiness_bonus INT,
    size INT,
    upgrade INT
--    foreign key (upgrade) references houses(id)
    );
CREATE TABLE variants(
	id IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    stage INT,
    fave_food INT,
--    FOREIGN KEY (FAVE_FOOD) REFERENCES FOODS(ID),
    max_exp INT,
    upgrade INT
--    FOREIGN KEY (upgrade) REFERENCES variants(id)
);
--ALTER TABLE variants ADD FOREIGN KEY (fave_food) REFERENCES foods(id) ;

--CREATE TABLE PLANETICKETS(
--  DESTINATION VARCHAR(10) NOT NULL,
--  TICKETPRICE NUMERIC(8,2) NOT NULL,
--  TOURISTINFO_ID INT,
--  foreign key (TOURISTINFO_ID) references touristinfo(TOURISTINFO_ID)
--)
CREATE TABLE pets(
	id IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    house INT,
--    foreign key (house) references houses(id),
    variant INT,
--    foreign key (variant) references variants(id)
    happiness INT,
    energy INT,
    mood INT,
    exp INT,
    money INT
);


INSERT INTO foods(
--    id,
    name,
    price,
    energy,
    happiness,
    isUnhealthy,
    heals
)
VALUES(
--    1,
    'medicine',
    8,
    0,
    0,
    FALSE,
    TRUE
);

INSERT INTO foods(
--    id,
    name,
    price,
    energy,
    happiness,
    isUnhealthy,
    heals
)
VALUES(
--    2,
    'carrot',
    2,
    3,
    0,
    FALSE,
    FALSE
);


INSERT INTO houses(
--    id,
    name,
    price,
    happiness_bonus,
    size,
    upgrade
)
VALUES(
--    1,
    'mansion',
    30,
    2,
    3,
    null
);
INSERT INTO houses(
--    id,
    name,
    price,
    happiness_bonus,
    size,
    upgrade
)
VALUES(
--    2,
    'house',
    20,
    1,
    2,
    1
);


INSERT INTO variants(
--    id,
    name,
    stage,
    fave_food,
    max_exp,
    upgrade
)
VALUES(
--    1,
    'impeckable',
    3,
    5,
    40,
    null
);
INSERT INTO variants(
--    id,
    name,
    stage,
    fave_food,
    max_exp,
    upgrade
)
VALUES(
--    2,
    'nugget',
    2,
    4,
    25,
    1
);


INSERT INTO pets(
--    id,
    name,
    house,
    variant,
    happiness,
    energy,
    mood,
    exp,
    money
)
VALUES(
--    1,
    'Jeff',
    3,
    3,
    1,
    10,
    1,
    0,
    10
);

INSERT INTO pets(
--    id,
    name,
    house,
    variant,
    happiness,
    energy,
    mood,
    exp,
    money
)

VALUES(
--    2,
    'Malcolm',
    3,
    2,
    1,
    10,
    1,
    0,
    10
);