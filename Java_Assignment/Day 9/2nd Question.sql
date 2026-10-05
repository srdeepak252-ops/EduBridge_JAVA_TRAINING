-- Day 9   2nd Question  Filter and sort

SELECT name, city, age
FROM students
WHERE age > 20 AND city <> 'Hyderabad'
ORDER BY age DESC;