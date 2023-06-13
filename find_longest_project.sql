SELECT  CONCAT('PRODJECT' ,project.id), TIMESTAMPDIFF(MONTH, start_date, finish_date) as MONTH_COUNT
FROM project
WHERE TIMESTAMPDIFF(MONTH, start_date, finish_date) =
(SELECT TIMESTAMPDIFF(MONTH, start_date, finish_date) as project_length
FROM project
ORDER BY project_length DESC
LIMIT 1);