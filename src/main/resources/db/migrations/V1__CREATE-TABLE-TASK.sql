CREATE TABLE tasks(
    id SERIAL PRIMARY KEY,
    description TEXT not null,
    status TEXT not null,
    createdAt timestamp not null,
);