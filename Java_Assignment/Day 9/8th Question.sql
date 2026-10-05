--  Day 9   8th Question   Courses per student (LEFT JOIN) 

SELECT s.name, COUNT(e.enroll_id) AS courses
FROM students s
LEFT JOIN enrollments e ON s.student_id = e.student_id
GROUP BY s.student_id, s.name
ORDER BY courses DESC, s.name;