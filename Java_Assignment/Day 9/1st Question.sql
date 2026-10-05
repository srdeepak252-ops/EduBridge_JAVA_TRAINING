--  Day 9  Question 1  Create a table with constraints

CREATE TABLE fees (
     fee_id INT PRIMARY KEY AUTO_INCREMENT,
     student_id INT NOT NULL,
     amount INT NOT NULL CHECK (amount > 0),
     paid_on DATE,
     FOREIGN KEY (student_id) REFERENCES
     students(student_id)
);
INSERT INTO fees (student_id, amount, paid_on)
    VALUES
   (1, 15000, '2026-06-05'),
   (2, 12000, '2026-06-07'),
   (1, 8000, '2026-07-01');
SELECT * FROM fees;
