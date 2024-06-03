CREATE TABLE IF NOT EXISTS Usuario (
     id serial PRIMARY KEY,
     nome  varchar(50) UNIQUE NOT NULL,
     senha   varchar(11) NOT NULL
);