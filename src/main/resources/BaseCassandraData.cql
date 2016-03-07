CREATE KEYSPACE "my_status"
  WITH REPLICATION = {
    'class': 'SimpleStrategy',
    'replication_factor': 1
  };

USE my_status;
CREATE TABLE "users" (
  "username" text PRIMARY KEY,
  "email" text,
  "encrypted_password" blob
);

INSERT INTO "users"
("username", "email", "encrypted_password")
VALUES (
  'alice',
  'alice@gmail.com',
  0x8914977ed729792e403da53024c6069a9158b8c4
);

INSERT INTO "users"
("username", "encrypted_password")
VALUES (
  'bob',
  0x10920941a69549d33aaee6116ed1f47e19b8e713
);

INSERT INTO "users"
("username", "email", "encrypted_password")
VALUES (
  'carol',
  'carol@gmail.com',
  0xed3d8299b191b59b7008759a104c10af3db6e63a
);

INSERT INTO "users"
("username", "email", "encrypted_password")
VALUES (
  'dave',
  'dave@gmail.com',
  0x6d1d90d92bbab0012270536f286d243729690a5b
);

CREATE TABLE "user_status_updates" (
  "username" text,
  "id" timeuuid,
  "body" text,
  PRIMARY KEY ("username", "id")
);

INSERT INTO "user_status_updates"
("username", "id", "body")
VALUES (
  'alice',
  76e7a4d0-e796-11e3-90ce-5f98e903bf02,
  'Learning Cassandra!'
);

INSERT INTO "user_status_updates"
("username", "id", "body")
VALUES (
  'bob',
  97719c50-e797-11e3-90ce-5f98e903bf02,
  'Eating a tasty sandwich.'
);

CREATE TABLE "status_update_replies" (
  "status_update_username" text,
  "status_update_id" timeuuid,
  "id" timeuuid,
  "author_username" text,
  "body" text,
  PRIMARY KEY (
    ("status_update_username", "status_update_id"),
    "id"
  )
);

CREATE TABLE "users_with_status_updates" (
  "username" text,
  "id" timeuuid,
  "email" text STATIC,
  "encrypted_password" blob STATIC,
  "body" text,
  PRIMARY KEY ("username", "id")
);

INSERT INTO "users_with_status_updates"
("username", "id", "email", "encrypted_password", "body")
VALUES (
  'alice',
  76e7a4d0-e796-11e3-90ce-5f98e903bf02,
  'alice@gmail.com',
  0x8914977ed729792e403da53024c6069a9158b8c4,
  'Learning Cassandra!'
);

INSERT INTO "users_with_status_updates"
("username", "id", "body")
VALUES ('alice', NOW(), 'Another status update');

INSERT INTO "users_with_status_updates"
("username", "email", "encrypted_password")
VALUES (
  'bob',
  'bob@gmail.com',
  0x10920941a69549d33aaee6116ed1f47e19b8e713
);
INSERT INTO "users_with_status_updates"
("username", "id", "body")
VALUES ('bob', NOW(), 'Bob status update');