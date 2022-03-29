CREATE TABLE foods(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    price INT,
    energy INT,
    happiness INT,
    isUnhealthy BOOLEAN,
    heals BOOLEAN
    );
CREATE TABLE houses(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    price INT,
    happiness_bonus INT,
    size INT,
    upgrade INT references houses(id)
    );
CREATE TABLE variants(
	id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    stage INT,
    fave_food INT references foods(id),
    max_exp INT,
    upgrade INT references variants(id)
);
CREATE TABLE pets(
	id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    house INT references houses(id),
    variant INT references variants(id),
    happiness INT,
    energy INT,
    mood INT,
    exp INT,
    money INT
);