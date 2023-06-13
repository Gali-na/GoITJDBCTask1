SELECT  name_worker, birthday
FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker)
UNION
SELECT  name_worker, birthday
FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker);