--  Write your MySQL query statement below

SELECT * FROM cinema
WHERE id % 2 = 1 AND NOT(description = 'boring')
ORDER BY rating DESC