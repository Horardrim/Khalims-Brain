CREATE TABLE IF NOT EXISTS hdm_user_ (
    id       SERIAL PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO hdm_user_ (username, password)
VALUES
  ('Tom', '$2a$10$...'),
  ('Tomas', '$2a$10$...'),
  ('Tony', '$2a$10$...'),
  ('Peter', '$2a$10$...'),
  ('Maggie', '$2a$10$...'),
  ('Mark', '$2a$10$...'),
  ('Mary', '$2a$10$...');
