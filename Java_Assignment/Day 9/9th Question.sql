--  Day 9   9th Question   Above-average scorers (subquery)

SELECT DISTINCT s.name
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
WHERE e.marks > (SELECT AVG(marks) FROM enrollments)
ORDER BY s.name;