CREATE TABLE movies (
  id BINARY(16) not null PRIMARY KEY,
  name varchar(100),
  year_released INT,
  directed_by VARCHAR(100),
  trailer_link VARCHAR(200)
)