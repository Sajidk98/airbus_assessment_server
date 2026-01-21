CREATE TABLE inventory (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    stock INT NOT NULL,
    price NUMERIC(10,2)
);