-- DROP TABLE IF EXISTS ta;
-- DROP TABLE IF EXISTS tb;
-- DROP TABLE IF EXISTS tc;
-- DROP TABLE IF EXISTS td;

-- CREATE TABLE ta (x INT, y INT);
-- CREATE TABLE tb (x INT);
-- CREATE TABLE tc (x INT);
-- CREATE TABLE td (x INT);

-- INSERT INTO ta VALUES (1, 1);
-- INSERT INTO ta VALUES (2, 2);
-- INSERT INTO ta VALUES (3, 3);

-- INSERT INTO tb VALUES (1);
-- INSERT INTO tb VALUES (2);
-- INSERT INTO tb VALUES (4);

-- INSERT INTO tc VALUES (1);
-- INSERT INTO tc VALUES (2);
-- INSERT INTO tc VALUES (3);

-- INSERT INTO td VALUES (1);
-- INSERT INTO td VALUES (3);
-- INSERT INTO td VALUES (4);

-- SELECT * FROM ta;
-- SELECT * FROM tb;
-- SELECT * FROM tc;
-- SELECT * FROM td;

use join_test3;

SELECT a.x AS 'x of ta', b.x AS 'x of tb' 
FROM ta a 
LEFT OUTER 
JOIN tb b 
ON b.x = a.x;

SELECT a.x AS 'x of ta', b.x AS 'x of tb' 
FROM ta a 
RIGHT OUTER 
JOIN tb b 
ON b.x = a.x;

SELECT a.x AS 'x of ta', b.x AS 'x of tb' 
FROM ta a 
LEFT OUTER 
JOIN tb b 
ON b.x = a.x 
WHERE a.x > 1;

SELECT a.x AS 'x of ta', b.x AS 'x of tb' 
FROM ta a 
LEFT OUTER 
JOIN tb b 
ON b.x = a.x AND a.x > 1;