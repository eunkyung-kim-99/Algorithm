-- 코드를 입력하세요
SELECT name, datetime from ANIMAL_INS where animal_id not in (select animal_id from ANIMAL_OUTS)
order by DATETIME limit 3;