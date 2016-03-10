CREATE KEYSPACE "movies_keyspace"
  WITH REPLICATION = {
    'class': 'SimpleStrategy',
    'replication_factor': 1
  };

use movies_keyspace;

CREATE TABLE "movies" (
	"name" text,
	"id" timeuuid,
	"year_released" text,
	"directed_by" text,
	PRIMARY KEY ("name", "id")
);

INSERT INTO "movies" ("name", "id", "year_released", "directed_by")
VALUES (
  'Pulp Fiction',
  97719c50-e797-11e3-90ce-5f98e903bf02,
  '1994',
  'Quentin Tarantino'
);

INSERT INTO "movies" ("name", "id", "year_released", "directed_by")
VALUES (
  'Goodfellas',
  97729c50-e797-11e3-90ce-5f98e903bf02,
  '1990',
  'Martin Scorsese'
);

INSERT INTO "movies" ("name", "id", "year_released", "directed_by")
VALUES (
  'Casino',
  97729c50-e792-11e3-90ce-5f98e903bf02,
  '1995',
  'Martin Scorsese'
);