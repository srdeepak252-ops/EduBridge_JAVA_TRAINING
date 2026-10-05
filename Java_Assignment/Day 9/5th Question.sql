--  Day 9   5th Queston   Insert and update

INSERT INTO courses
    VALUES (106, 'Cloud Basics', 9000, 5);
UPDATE courses
SET fee = fee + 500
WHERE weeks <= 6;

SELECT * FROM courses ORDER BY fee;