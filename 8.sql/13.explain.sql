use sakila;
EXPLAIN SELECT * FROM film_actor WHERE film_id = 1;

EXPLAIN ANALYZE SELECT * FROM film_actor WHERE film_id = 1;

EXPLAIN SELECT customer_id, first_name, last_name 
FROM customer 
WHERE customer_id = (SELECT MAX(customer_id) FROM customer);

EXPLAIN SELECT NOW();

EXPLAIN SELECT * FROM rental WHERE rental_date BETWEEN '2005-05-24' AND '2005-05-25';