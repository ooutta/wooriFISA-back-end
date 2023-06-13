-- language 테이블의 모든 열에 해당하는 전체 데이터 조회
SELECT * from language;

-- language 테이블에서  language_id, name, last_update 열에 해당하는 모든 데이터 조회
SELECT language_id, name, last_update FROM language;

SELECT language_id AS 언어ID, name AS 언어명, last_update AS '마지막 업데이트' FROM language;

-- film_category 테이블에서 category가 Sci-Fi인 film만 조회
SELECT * from film_category WHERE category_id = 14;

SELECT * FROM film_category, category 
WHERE category.name = 'Sci-Fi' && film_category.category_id = category.category_id;