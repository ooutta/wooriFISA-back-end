SELECT * FROM person;

-- Error. safe update mode를 사용중이다.
SET sql_safe_updates = 0;

UPDATE person
SET street = 'GREEN TEA STREET',
	state = 'MA',
	country = 'USA',
	postal_code = '15232';

select * from person;

-- WHERE 조건절을 추가해서 선택된 레코드만 UPDATE
UPDATE person
SET street = 'SPIDER STREET',
	state = 'NA',
	country = 'USA',
	postal_code = '14231'
WHERE person_id = 2;

select * from person;