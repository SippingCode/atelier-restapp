CREATE TABLE IF NOT EXISTS PLAYER
(
id int,
firstname text,
lastname text,
weight int,
height int,
country_code text
);

CREATE TABLE IF NOT EXISTS PLAYER_LAST
(
player_id int,
last int
);



INSERT INTO PLAYER (id, firstname, lastname, weight, height)
VALUES (1, 'djo', 'novac', 90, 185);

INSERT INTO PLAYER_LAST (player_id, last)
VALUES (1, 1);
INSERT INTO PLAYER_LAST (player_id, last)
VALUES (1, 0);
INSERT INTO PLAYER_LAST (player_id, last)
VALUES (1, 3);