CREATE DATABASE trx_test;
USE trx_test;

SELECT database();

CREATE TABLE t1 (
	cd INT,
	v1 INT
);

INSERT INTO t1 VALUES (1, 50);
INSERT INTO t1 VALUES (2, 50);
COMMIT;

SELECT * FROM t1;

-- MySQL에서는 기본적으로 autocommit 모드가 활성화되어 있다.

-- autocommit 모드 확인
SELECT @@AUTOCOMMIT ; -- 1 (TRUE), 0 (FALSE)

SELECT @@AUTOCOMMIT = 0 ; -- autocommit 비활성화
SELECT @@AUTOCOMMIT;

BEGIN; -- 트랜잭션 시작. 이 아래로 작성되는 모든 쿼리는 하나의 트랜잭션 내에 포함됨

-- MySQL cmd에서 select t1 해봐도 아직 트랜잭션이 종료되지 않았으므로 해당 값 insert 안 되어있다.
INSERT INTO t1 VALUES (3, 50); 

SELECT trx_id, trx_state, trx_started, trx_operation_state, trx_tables_in_use, trx_tables_locked, trx_isolation_level FROM INFORMATION_SCHEMA.INNODB_TRX;

COMMIT; -- 트랜잭션 종료
-- commit 이후에 select t1 해보면 (3, 50)이 삽입되어 있다.

SELECT table_schema, table_name, engine FROM information_schema.TABLES WHERE table_name = 't1' AND table_schema = 'trx_test';

SHOW TABLE STATUS WHERE name='t1';