CREATE TABLE users(
      id SERIAL PRIMARY KEY UNIQUE NOT NULL,
      login TEXT not null UNIQUE,
      password TEXT not null,
      role TEXT NOT NULL,
      createdAt timestamp not null,
);