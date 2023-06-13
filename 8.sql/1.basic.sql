SHOW databases; -- 현재 모든 데이터베이스(Schema)

USE sakila; -- Sakila Database 사용하기로 선택

SHOW tables; -- sakila DB 내부에 생성된 모든 테이블 조회

DESC actor; -- actor 테이블의 정보 조회

SELECT * FROM customer; -- customer 테이블 데이터 조회
 
SELECT VERSION() AS 버전, user() AS '사용자 계정', database() -- 현재 접속 중인 MySQL의 버전, user, database 확인 