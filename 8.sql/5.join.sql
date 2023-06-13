SELECT c.first_name, c.last_name, a.address FROM customer AS c JOIN address AS a LIMIT 5;

-- 표준 문법(ANSI)
SELECT c.first_name, c.last_name, a.address 
FROM customer c 
JOIN address a
ON c.address_id = a.address_id -- ON절 : JOIN 조건을 기술하는 부분
WHERE a.postal_code = 52137; -- WHERE : 일반 조건을 기술하는 부분