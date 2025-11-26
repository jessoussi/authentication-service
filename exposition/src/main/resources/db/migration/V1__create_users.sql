CREATE TABLE IF NOT EXISTS users
    (
        uid SERIAL PRIMARY KEY,
        firstname VARCHAR(255),
        lastname VARCHAR(255),
        mail VARCHAR(255),
        password VARCHAR(255)
    );