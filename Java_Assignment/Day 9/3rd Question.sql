--  Day 9  3rd Question   Pattern matching with LIKE and IN

SELECT name, city
FROM students
WHERE name LIKE 'A%'
   OR city IN ('Chennai', 'Delhi')
ORDER BY name;