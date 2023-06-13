-- 자식 테이블인 favorite_food에서 person의 기본키인 person_id를 외래키로 참조하고 있으므로 삭제 불가능
DELETE FROM person;

ALTER TABLE favorite_food DROP FOREIGN KEY fk_favorite_food_person_id;

ALTER TABLE favorite_food
ADD CONSTRAINT FOREIGN KEY (person_id)
REFERENCES person(person_id)
ON DELETE CASCADE; -- 부모 테이블 데이터 제거 시 자식 테이블의 엮인 데이터도 같이 제거 

DELETE FROM person;

SELECT * FROM person; -- 별도의 WHERE 키워드를 작성하지 않으면 전체 행이 제거된다.

SET sql_safe_updates = 1;

