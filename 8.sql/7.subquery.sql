SELECT MAX(customer_id) FROM customer;

SELECT customer_id, last_name, first_name 
FROM customer
WHERE customer_id = 599;

SELECT customer_id, last_name, first_name 
FROM customer
WHERE customer_id = (SELECT MAX(customer_id) FROM customer);


SELECT * FROM city LIMIT 10;
SELECT * FROM country LIMIT 10;

SELECT city.city 
FROM city JOIN country
ON city.country_id = country.country_id
WHERE country.country = 'South Korea';

SELECT city_id, city
FROM city
WHERE country_id = (SELECT country_id FROM country WHERE country = 'South Korea');


SELECT *
FROM country
WHERE country != 'India';

SELECT city_id, city
FROM city
WHERE country_id != (select country_id FROM country WHERE country = 'India');

SELECT city_id, city
FROM city
WHERE country_id IN -- 특정 집합에 속하는지 확인할 때 사용한느 연산자
 (select country_id FROM country WHERE country != 'India');

SELECT city_id, city
FROM city
WHERE country_id IN 
(SELECT country_id FROM country WHERE country IN ('canada', 'mexico'));

