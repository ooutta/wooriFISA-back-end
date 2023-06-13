SELECT * FROM customer WHERE first_name = 'KAREN';

SELECT first_name, last_name FROM actor WHERE first_name = 'NICK';

-- WHERE 절은 SELECT 수행 전에 먼저 판단되기 때문에 
-- WHERE를 평가하는 시점에는 fn이 아직 존재하지 않음
-- SELECT first_name AS fn, last_name AS ln FROM actor WHERE fn = 'NICK';

-- concatenation(문자열 접합) 내장 함수
SELECT concat(title, '의 줄거리: ', description) AS summary FROM film;

-- 무작위 행 데이터(Record) 반환(MySQL Syntax) rand() 내장 함수
SELECT * FROM actor ORDER BY rand();

SELECT * FROM customer WHERE first_name = 'VIRGINIA' AND last_name = 'GREEN';

SELECT * FROM film_category, category 
WHERE film_category.category_id = category.category_id 
AND (category.name= 'Animation' OR category.name = 'Games');

SELECT * FROM customer 
WHERE (first_name = 'STEVEN' OR last_name = 'YOUNG') 
AND create_date >= '2006-01-01';
-- SELECT * FROM customer 
-- WHERE (first_name = 'STEVEN' OR last_name = 'YOUNG') 
-- AND date_format(create_date, '%Y-%m-%d') >= '2006-01-01';

-- SELECT * FROM category WHERE name != 'Family';
SELECT * FROM category WHERE name <> 'Family';

SELECT customer_id, rental_date FROM rental WHERE rental_date <= '2005-05-25';

SELECT rental_date FROM rental WHERE rental_date >= '2005-05-24' AND rental_date <= '2005-05-25';
SELECT rental_date FROM rental WHERE rental_date BETWEEN '2005-05-24' AND '2005-05-25';

-- 시간 없이 날짜만 쓰면 해당 날짜의 자정부터이다.
SELECT rental_date FROM rental WHERE rental_date BETWEEN '2005-05-24 23:00:00' AND '2005-05-25';
SELECT rental_date FROM rental WHERE rental_date BETWEEN '2005-05-25' AND '2005-05-25 01:00:00';

SELECT * FROM payment WHERE amount BETWEEN 10.0 AND 10.99;

SELECT rental_id, customer_id, return_date FROM rental WHERE customer_id = 155;

-- null과 null이 서로 같을 수 없다. 따라서 return_date = NULL로 하면 출력 결과 데이터가 없다.
SELECT rental_id, customer_id, return_date FROM rental WHERE return_date IS NULL;

SELECT rental_id, customer_id, return_date FROM rental WHERE rental_date IS NOT NULL LIMIT 50;

SELECT rental_id, customer_id, return_date FROM rental WHERE return_date NOT BETWEEN '2005-05-01' AND '2005-09-01';
SELECT rental_id, customer_id, return_date FROM rental 
WHERE return_date IS NULL 
OR return_date NOT BETWEEN '2005-05-01' AND '2005-09-01';

-- 가급적 LIKE는 쓰지 않기.
SELECT last_name, first_name FROM customer
WHERE last_name LIKE '_A_T%S';

SELECT last_name, first_name FROM customer
WHERE last_name LIKE 'Q%' OR last_name LIKE 'Y%';