--  Day 9   7th Question   Report with a 3-table JOIN

SELECT s.name, c.title, e.marks
FROM enrollments e
JOIN students s ON e.student_id = s.student_id
JOIN courses c ON e.course_id = c.course_id
WHERE e.marks IS NOT NULL
ORDER BY e.marks DESC;