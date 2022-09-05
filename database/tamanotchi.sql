--CREATE DATABASE tamanotchi;

CREATE TABLE IF NOT EXISTS foods(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    price INT,
    energy INT,
    happiness INT,
    isUnhealthy BOOLEAN,
    heals BOOLEAN
    );
CREATE TABLE IF NOT EXISTS houses(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    price INT,
    happiness_bonus INT,
    size INT,
    upgrade INT references houses(id)
    );
CREATE TABLE IF NOT EXISTS variants(
	id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    stage INT,
    fave_food INT references foods(id),
    max_exp INT,
    upgrade INT references variants(id)
);
CREATE TABLE IF NOT EXISTS pets(
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

INSERT INTO foods(id, name, price, energy, happiness, isunhealthy, heals)
VALUES 
(1,'medicine', 8, 0, 0, FALSE, TRUE), 
(2,'carrot', 2, 2, 0, FALSE, FALSE),
(3, 'candy', 6, 0, 2, TRUE, FALSE),
(4, 'pizza', 4, 2, 1, TRUE, FALSE),
(5, 'fish', 4, 4, 0, FALSE, FALSE),
(6, 'apple', 5, 2, 1, FALSE, FALSE)
ON CONFLICT (id)
DO NOTHING;

INSERT INTO houses(id, name, price, happiness_bonus, size, upgrade)
VALUES 
(1,'mansion', 30, 2, 3, null), 
(2,'house', 20, 1, 2, 1),
(3, 'bungalow', 10, 0, 1, 2)
ON CONFLICT (id)
DO NOTHING;

INSERT INTO variants(id, name, stage, fave_food, max_exp, upgrade)
VALUES 
(1,'impeckable', 3, 5, 40, null), 
(2,'nugget', 2, 4, 25, 1),
(3, 'chickpea', 1, 2, 10, 2),
(4,'firecracker', 3, 4, 45, null), 
(5,'big eatie', 2, 6, 30, 4),
(6, 'rexy', 1, 5, 15, 5)
ON CONFLICT (id)
DO NOTHING;