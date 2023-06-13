USE sakila;

SELECT customer_id, count(rental_date) FROM rental GROUP BY customer_id;

SELECT customer_id, count(rental_date) 
FROM rental 
GROUP BY customer_id
-- ORDER BY 1; -- default
ORDER BY 2 DESC; -- 2번째 컬럼을 기준으로 내림차순

SELECT customer_id, count(rental_date) 
FROM rental 
GROUP BY customer_id
HAVING count(rental_date) < 40;

-- category별 film 갯수를 내림차순 정렬. 
SELECT fc.category_id, c.name, count(fc.category_id) AS 'count'
FROM film_category fc JOIN category c
ON fc.category_id = c.category_id
GROUP BY fc.category_id
ORDER BY 3 DESC;

-- EX1) film당 출연한 배우의 수 (film, film_actor)
SELECT f.title, count(f.title)
FROM film_actor fa JOIN film f
ON fa.film_id = f.film_id
GROUP BY f.title;

SELECT f.title, count(f.film_id)
FROM film_actor fa JOIN film f
ON fa.film_id = f.film_id
GROUP BY f.film_id;


-- EX2) 영화별 대여 횟수를 조회하고 싶을 때, film_id, title, 영화별 대여 횟수를 출력. 대여 횟수를 내림차순으로 정렬
SELECT f.film_id, f.title, count(r.rental_id)
FROM inventory i 
JOIN rental r 
ON r.inventory_id = i.inventory_id
JOIN film f
ON i.film_id = f.film_id
GROUP BY f.film_id
ORDER BY COUNT(r.rental_id) DESC;

-- EX3) 영화 카테고리 NAME과 각 카테고리마다 몇 개의 영화가 있는지 영화 개수 출력
SELECT c.name, count(fc.film_id)
FROM category c JOIN film_category fc
ON c.category_id = fc.category_id
GROUP BY c.category_id;

-- EX4) payment 테이블에서 고객 아이디 당 총 금액을 얼마 썼는지 조회 (총 금액 100 이상만)
SELECT customer_id, sum(amount)
FROM payment
GROUP BY customer_id
HAVING sum(amount) > 100;

-- EX5) 영화 제목별 보상 비용이 15~25인 데이터를 선택해서, 평균 보상 비용이 20 이상인 데이터를 조회한다.
SELECT title, AVG(replacement_cost) 
FROM film
WHERE replacement_cost BETWEEN 15 AND 25
GROUP BY title
HAVING AVG(replacement_cost) >= 20;

-- EX6) count 테이블에서 같은 맨 앞 글자로 시작하는 나라를 count 한다. count가 5 이상인 데이터를 첫 글자를 내림차순으로 정렬한다.
SELECT left(country, 1) AS first_letter, count(country_id) AS count_country
FROM country
GROUP BY first_letter
HAVING count_country >= 5
ORDER BY count_country DESC;

