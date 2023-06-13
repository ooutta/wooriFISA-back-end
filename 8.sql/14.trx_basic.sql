CREATE DATABASE engine_trx_test;

USE engine_trx_test;

-- MyISAM 스토리지엔진 기반 테이블 생성
CREATE TABLE myisam_table (
	id INT NOT NULL, PRIMARY KEY(id)
)ENGINE=MyISAM; -- default로 InnoDB가 설정됨

-- 더미데이터 삽입
INSERT INTO myisam_table (id) VALUES (3);
INSERT INTO myisam_table (id) VALUES (1), (2), (3); -- 여기서 에러가 나도 1, 2는 insert 된다.
SELECT * FROM myisam_table;

-- InnoDB 엔진 기반 테이블 생성
CREATE TABLE innodb_table ( id INT NOT NULL, PRIMARY KEY(id))
ENGINE=INNODB;

-- 더미데이터 삽입
INSERT INTO innodb_table (id) VALUES (3);

INSERT INTO innodb_table (id) VALUES (1), (2), (3); -- 여기서 에러가 나면 1, 2가 insert 되지 않는다.
-- Error Code: 1062. Duplicate entry '3' for key 'innodb_table.PRIMARY'	0.000 sec
SELECT * FROM innodb_table;
