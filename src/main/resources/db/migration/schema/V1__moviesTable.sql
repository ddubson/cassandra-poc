CREATE SCHEMA IF NOT EXISTS filmfox;

CREATE TABLE filmfox.movies (
  id INT not null PRIMARY KEY,
  name varchar(100),
  year_released INT,
  directed_by VARCHAR(100),
  trailer_link VARCHAR(200)
);