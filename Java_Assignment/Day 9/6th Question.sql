--  Day 9   6th Question  Course statistics with HAVING

SELECT course_id,
       COUNT(marks)          AS marked,
       ROUND(AVG(marks), 1)  AS avg_marks,
       MAX(marks)            AS highest,
       MIN(marks)            AS lowest
FROM enrollments
GROUP BY course_id
HAVING COUNT(marks) >= 2
ORDER BY course_id;