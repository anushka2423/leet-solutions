# Write your MySQL query statement below
SELECT email as Email
FROM Person
Group By email
HAVING count(*) > 1
