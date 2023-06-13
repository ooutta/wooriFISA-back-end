-- CREATE TABLE 테이블명 ( 필드, 타입, 제약조건 기술하는 부분 );

-- 연습용 DB 생성
CREATE DATABASE testdb;

SELECT database();

use testdb;

CREATE TABLE person (
	person_id SMALLINT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    eye_color ENUM('BR', 'BL', 'GR'),
    birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20),
	CONSTRAINT pk_person PRIMARY KEY (person_id) -- 기본키로 사용하곘다는 제약조건 명시
  -- CONSTRAINT 제약조건이름 PRIMARY KEY (필드이름)
);

SHOW tables;

DESC person;

DROP TABLE person;

SHOW tables;

CREATE TABLE person ( -- CREATE TABLE 테이블명
	person_id SMALLINT UNSIGNED, -- 필드 데이터타입,(comma로 구분)
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	eye_color ENUM('BR', 'BL', 'GR'),
	birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20),
	CONSTRAINT pk_person PRIMARY KEY (person_id) -- 기본키로 사용하곘다는 제약조건 명시
  -- CONSTRAINT 제약조건이름 PRIMARY KEY (필드이름)
);

DESC person;

drop table favorite_food;

CREATE TABLE favorite_food (
	person_id SMALLINT UNSIGNED,
	food VARCHAR(20),
	CONSTRAINT pk_favorite_food PRIMARY KEY (person_id, food)
);

DESC favorite_food;

SHOW CREATE TABLE favorite_food;


ALTER TABLE favorite_food ADD CONSTRAINT fk_favorite_food_person_id 
FOREIGN KEY (person_id) REFERENCES person (person_id);

DESC favorite_food;

DESC person;

INSERT INTO person (person_id, first_name, last_name) VALUES (1, 'Kim', 'Suhyun');

SELECT * FROM person;

-- person_id 컬럼은 정수 타입의 기본키이기 때문에, 1씩 증가하도록해서 고유성을 보장하도록 설정 변경
ALTER TABLE person MODIFY person_id SMALLINT AUTO_INCREMENT; -- 에러 발생

-- 외래키 제약조건 비활성화
SET foreign_key_checks = 0;

ALTER TABLE person MODIFY person_id SMALLINT UNSIGNED AUTO_INCREMENT;
SET foreign_key_checks = 1;

-- INSERT INTO person
-- 	(first_name, last_name, eye_color, birth_date, street)
-- VALUES ('STERINE', 'LEE', 'BR', '1999-05-02');

INSERT INTO person
	(first_name, last_name, eye_color, birth_date, street)
VALUES ('STERINE', 'LEE', 'GR', '1999-05-02', 'MILD TASTE STREET');

INSERT INTO favorite_food (person_id, food) VALUES (1, 'pizza');

INSERT INTO favorite_food (person_id, food) VALUES (2, 'salad');
INSERT INTO favorite_food (person_id, food) VALUES (3, 'ace'); -- person 테이블에 person_id가 3인 레코드가 없으므로 에러 발생

INSERT INTO person
	(first_name, last_name, eye_color, birth_date, street)
VALUES ('LANA', 'DEL REY', 'BR', '1999-02-04', 'BLUE JEAN STREET');

INSERT INTO favorite_food (person_id, food) VALUES (2, 'salad');
INSERT INTO favorite_food (person_id, food) VALUES (2, 'ace');

SELECT * FROM favorite_food;

INSERT INTO favorite_food (person_id, food) VALUES (3, 'choco');

SELECT * FROM favorite_food;

SELECT * FROM information_schema.table_constraints where table_name = 'person';