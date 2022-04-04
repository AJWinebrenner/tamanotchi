
CREATE TABLE foods(
    id INT auto_increment PRIMARY KEY,
    name VARCHAR(255),
    price INT,
    energy INT,
    happiness INT,
    isUnhealthy BOOLEAN,
    heals BOOLEAN
    );
CREATE TABLE houses(
    id INT auto_increment PRIMARY KEY,
    name VARCHAR(255),
    price INT,
    happiness_bonus INT,
    size INT,
    upgrade INT
    );
CREATE TABLE variants(
	id INT auto_increment PRIMARY KEY,
    name VARCHAR(255),
    stage INT,
    fave_food INT,
    max_exp INT,
    upgrade INT
);
CREATE TABLE pets(
	id INT auto_increment PRIMARY KEY,
    name VARCHAR(255),
    house INT,
    variant INT,
    happiness INT,
    energy INT,
    mood INT,
    exp INT,
    money INT
);

INSERT INTO foods(
    name,
    price,
    energy,
    happiness,
    isUnhealthy,
    heals
)
VALUES(
    'medicine',
    8,
    0,
    0,
    FALSE,
    TRUE
);

INSERT INTO foods(
    name,
    price,
    energy,
    happiness,
    isUnhealthy,
    heals
)
VALUES(
    'carrot',
    2,
    3,
    0,
    FALSE,
    FALSE
);


INSERT INTO houses(
    name,
    price,
    happiness_bonus,
    size,
    upgrade
)
VALUES(
    'mansion',
    30,
    2,
    3,
    null
);
INSERT INTO houses(
    name,
    price,
    happiness_bonus,
    size,
    upgrade
)
VALUES(
    'house',
    20,
    1,
    2,
    1
);
INSERT INTO houses(
    name,
    price,
    happiness_bonus,
    size,
    upgrade
)
VALUES(
    'bungalow',
    10,
    0,
    1,
    2
);

INSERT INTO variants(
    name,
    stage,
    fave_food,
    max_exp,
    upgrade
)
VALUES(
    'impeckable',
    3,
    5,
    40,
    null
);
INSERT INTO variants(
    name,
    stage,
    fave_food,
    max_exp,
    upgrade
)
VALUES(
    'nugget',
    2,
    4,
    25,
    1
);
INSERT INTO variants(
    name,
    stage,
    fave_food,
    max_exp,
    upgrade
)
VALUES(
    'chickpea',
    1,
    2,
    10,
    2
);

INSERT INTO pets(
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
    'Malcolm',
    3,
    2,
    1,
    10,
    1,
    0,
    10
);