-- 1. actor 테이블에서 first_name과 last_name을 연결하여(concat) 대문자(upper)로 출력되도록 쿼리 작성
SELECT upper(concat(first_name, ' ', last_name)) FROM actor;

-- 2. actor 테이블에서 actor_id, first_name, last_name을 조회하되, first_name이 Joe인 사람을 조회
-- 제약조건: 테이블 내 실제 값은 대문자인 JOE로 되어있지만, 'Joe'와 같이 대문자 외에 소문자로 섞어서 조회해도 조회가 가능하도록 쿼리 작성
SELECT actor_id, first_name, last_name
FROM actor
WHERE first_name = 'Joe';

-- 3. actor 테이블에서 last_name과 총 몇 명이 동일한 last_name을 가지고 있는지 조회
SELECT last_name, count(last_name) as 'count last_name'
FROM actor
GROUP BY last_name
ORDER BY  count(last_name) DESC, last_name ASC;

/*
`그룹핑 기준`
last_name

`정렬 기준`
1. actor_count 내림차순
2. last_name 오름차순
*/


-- 4. 3번 문제 내용으로 동일하게 조회하되, 그룹핑 조건으로 actor_count가 3보다 큰 데이터만 조회
SELECT last_name, count(last_name) as count_last_name
FROM actor
GROUP BY last_name
HAVING count_last_name > 3
ORDER BY count_last_name DESC, last_name ASC;

-- 5. address 테이블에 대한 테이블 생성 쿼리를 조회하기 위한 쿼리 작성
-- hint. `SHOW`  키워드
-- → address 테이블 생성 시 사용된 DDL 쿼리를 조회할 수 있음
SHOW CREATE TABLE address;

-- 6. JOIN을 활용하여 staff의 first_name과 last_name, address, district, postal_code, city_id를 조회
-- → 조인하는 테이블 간 공통되지 않는 컬럼은 별칭을 작성하지 않아도, 참조 가능(first_name, last_name 등)
-- address_id는 두 테이블에 모두 존재하기 때문에 각각 별칭 지정 필요
SELECT first_name, last_name, a.address, district, postal_code, city_id
FROM staff s JOIN address a
ON s.address_id = a.address_id;

-- 7. JOIN을 활용하여 각 staff가 2005년 8월에 집계한 총 금액, first_name, last_name 조회
SELECT * from staff;
SELECT sum(amount) AS total_amount, first_name, last_name
FROM staff s JOIN payment m
ON s.staff_id = m.staff_id
GROUP BY s.staff_id;

-- 8. 영화 제목과 해당 영화에 등장한 배우의 총 인원 수를 조회(INNER JOIN  활용)
SELECT f.title, count(fa.actor_id)
FROM film f JOIN film_actor fa
ON f.film_id = fa.film_id
GROUP BY f.title;

-- 9. 영화 제목이 'Hunchback Impossible'인 영화는 inventory 테이블에 총 몇 개의 복제본이 있는지 조회
-- ex) 만약, Inventory 테이블에 A라는 영화의 복제본이 5개일 경우, 5개의 비디오를 대여 가능하다는 의미


-- 10. 고객의 first_name, last_name과 각 고객(customer)이 지금까지 대여 과정에서 지불한 총 금액을 조회


-- 11. 제목이 'K'나 'Q'로 시작하고, 지원 언어가 English인 모든 영화 제목 조회(서브쿼리 활용)


-- 12. `'Alone Trip'`에 등장하는 모든 영화 배우들의 first_name, last_name 조회(서브쿼리 활용)


-- 13. 국적이 캐나다인 고객의 first_name과 last_name, email 조회


-- 14. 영화 카테고리가 가족(`'Family'`)으로 분류된 모든 영화의 제목과 출시연도 조회


-- 15. 가장 많이 대여된 영화ID(film_id)와 영화 제목, 대여 횟수를 조회


-- 16. 영화 가게 id(store_id)와 각 영화 가게(store)가 벌어들인 총 매출 조회


-- 17. 각 영화 가게의 id, 도시, 국가, 총 매출에 대해 조회
-- (활용 테이블: store, address, customer, payment)


-- 18. 총 수익 기준 상위 5개에 해당하는 영화 장르와 총 수익(별칭으로 `revenue`라고 작명) 조회


-- 19. `view`를 활용하여 18번에서 조회한 쿼리 임시 저장하기


-- 20. 저장한 view로 다시 조회


-- 21. 사용하던 view 제거