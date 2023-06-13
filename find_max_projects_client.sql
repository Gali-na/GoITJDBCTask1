SELECT client.name,  COUNT(project.client_id)  as count_of_project
FROM project join client
ON client.id=project.client_id
GROUP BY project.client_id
HAVING count_of_project=
(SELECT COUNT(project.client_id)
FROM project join client
ON client.id=project.client_id
GROUP BY project.client_id
LIMIT 1);
