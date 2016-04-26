CREATE KEYSPACE "movies_keyspace"
  WITH REPLICATION = {
    'class': 'SimpleStrategy',
    'replication_factor': 1
  };

use movies_keyspace;

CREATE TABLE "movies" (
    "id" timeuuid,
	"name" text,
	"year_released" text,
	"directed_by" text,
	"trailer_link" text,
	PRIMARY KEY ("id", "name")
);

CREATE TABLE users (
	"email" text,
	"password" text,
	PRIMARY KEY ("email")
);

CREATE TABLE users_roles (
	"email" text,
	"role_name" text,
	PRIMARY KEY ("email", "role_name")
);

INSERT INTO users ("email", "password")
VALUES (
	'd.dubson@gmail.com',
	'$2a$10$VNtKqoVvlRyXyIZm5NE2L.HCQPM5nENOry8TOB.6xaY0JOC5G0hHy'
);

INSERT INTO users_roles ("email", "role_name")
VALUES (
	'd.dubson@gmail.com',
	'ADMIN'
);

INSERT INTO "movies" ("name", "id", "year_released", "directed_by", "trailer_link")
VALUES (
  'Pulp Fiction',
  97719c50-e797-11e3-90ce-5f98e903bf02,
  '1994',
  'Quentin Tarantino',
  'https://www.youtube.com/embed/s7EdQ4FqbhY'
);

INSERT INTO "movies" ("name", "id", "year_released", "directed_by", "trailer_link")
VALUES (
  'Goodfellas',
  97729c50-e797-11e3-90ce-5f98e903bf02,
  '1990',
  'Martin Scorsese',
  'https://www.youtube.com/embed/2ilzidi_J8Q'
);

INSERT INTO "movies" ("name", "id", "year_released", "directed_by", "trailer_link")
VALUES (
  'Casino',
  97729c50-e792-11e3-90ce-5f98e903bf02,
  '1995',
  'Martin Scorsese',
  'https://www.youtube.com/embed/EJXDMwGWhoA'
);