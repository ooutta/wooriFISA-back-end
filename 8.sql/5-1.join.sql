-- DROP TABLE IF EXISTS ta;
-- DROP TABLE IF EXISTS tb;
-- DROP TABLE IF EXISTS tc;

-- CREATE TABLE ta (x INT, PRIMARY KEY (x));
-- CREATE TABLE tb (x INT, PRIMARY KEY (x));
-- CREATE TABLE tc (x INT, PRIMARY KEY (x));

-- INSERT INTO ta VALUES (1);
-- INSERT INTO ta VALUES (2);
-- INSERT INTO ta VALUES (3);

-- INSERT INTO tb VALUES (1);
-- INSERT INTO tb VALUES (2);

-- INSERT INTO tc VALUES (1);
-- INSERT INTO tc VALUES (3);

-- SELECT * FROM ta; 
-- SELECT * FROM tb;
-- SELECT * FROM tc;

-- USE join_test;

SELECT a.x AS 'x of ta', b.x AS 'x of tb' FROM ta a, tb b;

SELECT a.x AS 'x of ta', b.x AS 'x of tb' 
FROM ta a
NATURAL JOIN tb b;

SELECT a.x AS 'x of ta', b.x AS 'x of tb' 
FROM ta a, tb b
WHERE b.x >= a.x;