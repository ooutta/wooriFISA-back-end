-- DROP TABLE IF EXISTS ta;
-- DROP TABLE IF EXISTS tb;

-- CREATE TABLE ta (x INT NOT NULL, y INT, z INT);
-- CREATE TABLE tb (x INT NOT NULL, y INT, z INT);

-- INSERT INTO ta VALUES (1, 1, 1);
-- INSERT INTO ta VALUES (2, 2, NULL);
-- INSERT INTO ta VALUES (3, 3, NULL);
-- INSERT INTO ta VALUES (4, NULL, NULL);
-- INSERT INTO tb VALUES (1, 1, 1);
-- INSERT INTO tb VALUES (2, 2, NULL);
-- INSERT INTO tb VALUES (3, NULL, 3);
-- INSERT INTO tb VALUES (4, NULL, NULL);

-- SELECT * FROM ta;
-- SELECT * FROM tb;

use join_test2;

SELECT a.x AS 'x of ta', a.y AS 'y of ta', a.z AS 'z of ta', b.x AS 'x of tb', b.y AS 'y of tb', b.z AS 'z of tb' 
FROM ta a 
INNER JOIN tb b 
ON b.x = a.x AND b.y = a.y;

SELECT a.x AS 'x of ta', a.y AS 'y of ta', a.z AS 'z of ta', b.x AS 'x of tb', b.y AS 'y of tb', b.z AS 'z of tb' 
FROM ta a 
INNER JOIN tb b
ON b.x = a.x AND b.y = a.y AND b.z = a.z;