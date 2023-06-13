USE sakila;

-- 1. actor 테이블 내 모든 컬럼이 포함된 전체 데이터(행) 조회
SELECT * FROM actor;

-- 2. actor 테이블에서 last_name 컬럼만 포함된 전체 데이터 조회
SELECT last_name FROM actor;

-- 3. film 테이블에서 영화 제목, 영화 설명, 대여 기간(rental_duration), 대여 비용(rental_rate), 총 렌탈 비용(직접 생성할 새로운 컬럼)에 해당하는 데이터를 상위 10개만 조회
SELECT title, description, rental_duration, rental_rate, rental_duration * rental_rate FROM film GROUP BY title LIMIT 10;
/*
컬럼 설명
-   `rental_duration`: 대여 기간(day 기준), 
→ The length of the rental period, in days
-   `rental_rate`: `rental_duration` 컬럼에 저장된 기간 동안 film을 대여하는데 필요한 비용
The cost to rent the film for the period specified in the `rental_duration` column
*/


-- 4. actor 테이블에서 서로 다른(겹치지 않는) last_name열에 해당하는 모든 데이터 조회
SELECT DISTINCT last_name FROM actor;

-- 5. address 테이블에서 postal_code열에 해당하는 중복 제거된 모든 데이터 조회
SELECT DISTINCT postal_code FROM address;

-- 6. film 테이블에서 영화 제목, 줄거리, rating(영화 등급), length(영화 러닝타임, minutes 기준) 열에 해당하는 모든 데이터를 조회하되, 러닝타임이 3시간 이상인 데이터만 필터링하여 조회
SELECT title, description, rating, length FROM film WHERE length >= 180;

-- 7. payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 모든 데이터를 조회하되, 2005년 8월 23일 자정 이후에 지불된 데이터만 필터링하여 조회
SELECT payment_id, amount, payment_date FROM payment WHERE payment_date > '2005-08-23';

-- 8. payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 모든 데이터를 조회하되, 지불날짜가 2005년 8월 23일만 해당하는 모든 데이터 조회
SELECT payment_id, amount, payment_date FROM payment WHERE payment_date BETWEEN '2005-08-23' AND '2005-08-24';

-- 9. customer 테이블에서 모든 열에 해당하는 데이터를 조회하되, last_name이 s로 시작하고, first_name이 n으로 끝나는 데이터만 필터링하여 조회
SELECT * FROM customer WHERE last_name LIKE 'S%' AND first_name LIKE '%N';

-- 10. customer 테이블에서 모든 열에 해당하는 데이터를 조회하되, 휴면 사용자(active 컬럼 참고) 이면서, last_name이 m으로 시작하는 데이터만 필터링하여 조회
SELECT * FROM customer WHERE active = 0 AND last_name LIKE 'M%';

-- 11. category 테이블에서 모든 열에 해당하는 데이터를 조회하되, category_id가 4보다 크고, name 열에 해당하는 데이터가 c로 시작하거나, s로 시작하거나, t로 시작하는 데이터로 필터링하여 조회
SELECT * FROM category WHERE category_id > 4 AND (name LIKE 'C%' OR 'S%' OR 'T%');

-- 12. address 테이블에서 phone, 구역(district) 컬럼을 조회하되, 구역이 California, England, Taipei,  West Java에 해당하는 구역만 필터링하고, district 컬럼을 기준으로 오름차순 정렬하여 조회
SELECT phone, district FROM address WHERE district IN ('California', 'England', 'Taipei', 'West Java') ORDER BY district ASC;

-- 13. payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 데이터를 조회하되, 지불날짜가 2005년 8월 23일, 24일, 25일에 해당하는 데이터만 조회(`IN, Date()` 활용)
SELECT payment_id, amount, payment_date FROM payment WHERE payment_date BETWEEN '2005-08-23' AND '2005-08-26';

-- 14. film 테이블에서 모든 열에 해당하는 데이터를 조회하되, rate(등급)가 G, PG-13, NC-17에 해당되는 데이터만 조회
SELECT * FROM film WHERE rating IN ('G', 'PG-13', 'NC-17');

-- 15. payment 테이블에서 모든 열에 해당하는 데이터를 조회하되, payment_date가 2005년 8월 23일에만 해당하는 데이터 조회
SELECT * FROM payment WHERE payment_date BETWEEN '2005-08-23' AND '2005-08-24';

-- 16. film 테이블에서 제목, 줄거리, 출시연도, 총 대여비용(rental_duration, rental_rate 활용)열에 해당하는 데이터를 조회하되, 러닝타임이 100 ~ 120분 사이에 해당하는 데이터만 조회
select * from film;
SELECT title, description, release_year, rental_duration * rental_rate 
FROM film WHERE length BETWEEN 100 AND 120;

-- 17. film 테이블에서 제목, 줄거리, 출시연도에 해당하는 데이터를 조회하되, 줄거리가 'A Thoughtful'로 시작하는 데이터를 영화 제목을 기준으로 오름차순 정렬하여 조회
SELECT title, description, release_year FROM film WHERE description LIKE 'A Thoughtful%' ORDER BY title ASC;

-- 18. film 테이블에서 제목, 줄거리, 대여기간에 해당하는 데이터를 조회하되, 줄거리가 '~Boat'로 끝나는 데이터를 영화 제목을 기준으로 내림차순 정렬하여 조회
SELECT title, description, rental_duration FROM film WHERE description LIKE '%Boat';

-- 19. film 테이블에서 제목, 러닝타임, 줄거리, 대여 비용에 해당하는 모든 데이터를 조회하되, 줄거리에 'database'라는 텍스트가 포함되어 있고, 
-- 러닝타임이 180분 보다 긴 데이터를 제목을 기준으로 오름차순 정렬하여 조회
SELECT title, length, description, rental_rate FROM film
WHERE description LIKE '%database%' AND length > 180
ORDER BY title ASC;

-- 20. payment 테이블에서 모든 열에 해당하는 데이터를 조회하되, 상위 20개의 행만 조회
SELECT * FROM payment LIMIT 20;

-- 21. payment 테이블에서 지불날짜와 금액에 해당하는 데이터를 조회하되, 금액이 5달러보다 높고, 상위 10개 행으로 제한하되, 20번째 행부터 조회
-- → 20번째 행부터 상위 10개 데이터 조회
SELECT payment_date, amount FROM payment 
WHERE amount > 5 LIMIT 10 OFFSET 20;

-- 22. customer 테이블에서 모든 열에 해당하는 데이터를 조회하되, 200번째 행부터 상위 100개 데이터 조회
-- → 101 ~ 200번째 행 조회
SELECT * FROM customer LIMIT 100 OFFSET 200;

-- 23. film 테이블에서 제목, 줄거리, 영화 특징(special_features), 러닝타임, 대여 기간에 해당하는 데이터를 조회하되, 영화 특징으로 'Behind the Scenes'만 해당되고, 
-- 러닝타임은 2시간 미만이고 대여기간은 5일에서 7일 사이에 해당하는 모든 데이터를 조회, 정렬 조건은 러닝타임을 기준으로 내림차순 정렬하여 상위 10개 데이터만 조회
SELECT title, description, special_features, length, rental_duration FROM film
WHERE special_features = 'Behind the Scenes' AND length < 120 AND rental_duration BETWEEN 5 AND 7
ORDER BY length DESC LIMIT 10;

-- 24. customer와 actor 테이블의 데이터를 활용하여 customer와 actor가 서로 이름이 같은 사람의 데이터를 찾으려고 할 때,
SELECT c.first_name AS customer_first_name, c.last_name AS customer_last_name, a.first_name AS actor_first_name, a.last_name AS actor_last_name
FROM customer c LEFT OUTER JOIN actor a
ON c.first_name = a.first_name AND c.last_name = a.last_name;

/*
`비교 조건`
customer의 first_name과 actor의 first_name이 같고, 
customer의 last_name과 actor의 last_name이 같은 경우

`조인 조건`
customer, actor 순으로 LEFT JOIN 활용

`별칭`
customer_first_name
customer_last_name
actor_first_name
actor_last_name
*/

-- 25. 24번 문제의 예시를 RIGHT JOIN으로 조회
SELECT c.first_name AS customer_first_name, c.last_name AS customer_last_name, a.first_name AS actor_first_name, a.last_name AS actor_last_name
FROM customer c RIGHT OUTER JOIN actor a
ON c.first_name = a.first_name AND c.last_name = a.last_name;

-- 26. 24번 문제의 예시를 INNER JOIN으로 조회
SELECT c.first_name AS customer_first_name, c.last_name AS customer_last_name, a.first_name AS actor_first_name, a.last_name AS actor_last_name
FROM customer c INNER JOIN actor a
ON c.first_name = a.first_name AND c.last_name = a.last_name;

-- 27. city 테이블에서 city 이름, country 테이블에서 country 이름에 해당하는 데이터 조회,
SELECT city.city, country.country
FROM city LEFT OUTER JOIN country
ON city.country_id = country.country_id
ORDER BY country;

/*
`조인 조건`
city의 country_id와 country의 country_id
LEFT JOIN 활용

`정렬 조건`
country 테이블 기준
*/


-- 28. film 테이블에서 title, description, release_year, language 테이블에서 name열에 해당하는 모든 데이터를 조회
SELECT f.title, f.description, f.release_year, l.name
FROM film f LEFT OUTER JOIN language l
ON f.language_id = l.language_id
ORDER BY l.name;

/*
`조인 조건`
film 테이블의 language_id와 language 테이블의 language_id
LEFT JOIN 활용

`정렬 조건`
language 테이블 기준
*/

-- 29. staff 테이블에서 first_name, last_name, address, address2, district, postal_code, city 테이블에서 city 열에 해당하는 모든 데이터 조회
select * from address;
SELECT s.first_name, s.last_name, a.address, a.address2, a.district, a.postal_code, c.city
FROM staff s 
LEFT OUTER JOIN address a
ON s.address_id = a.address_id
LEFT OUTER JOIN city c
ON a.city_id = c.city_id;

/*
`조인 조건`
staff 테이블의 address_id와 address 테이블의 address_id
address 테이블의 city_id와 city 테이블의 city_id
LEFT JOIN 활용
*/