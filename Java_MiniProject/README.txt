# This Is The Java Mini Project
PROJECT TITLE: Student Report Card Manager
TEAM MEMBERS: 1. Aradhan Pradhan  (1VJ25CS006)
              2. Harsh Raj        (1VJ25CS020)
              3. Kumbhar Nivedita (1VJ25CS024)
              4. Mohammed Mujeeb  (1VJ25CS035)
              5. Deepak S R       (1VJ25CS014)
              6. Dhanush K S Rao  (1VJ25CS017)
HOW TO RUN
----------
1. Open a terminal in the "src" folder.
2. Compile:   javac *.java
3. Run:       java Main
4. Follow the on-screen menu. Enter the number for the action you want,
   then answer the prompts. Choose 0 to exit.

FEATURES COMPLETED (all 10 required)
-------------------------------------
1. Add a student     - roll number, name, marks in 5 subjects
2. View all          - table of roll, name, total, %, grade, result
3. Search            - by roll number, prints a full report card
4. Update marks      - change one subject's mark for a student
5. Delete            - remove a student by roll number
6. Class topper      - student with the highest percentage
7. Rank list         - all students sorted by percentage, highest first
8. Grade summary     - count of students with each grade (A/B/C/D/F)
9. Subject toppers   - highest mark in each of the 5 subjects
10. Exit             - menu keeps repeating until you choose 0

VALIDATIONS IMPLEMENTED
------------------------
- Roll numbers must be unique (duplicates are rejected)
- Roll number must be a positive whole number
- Marks must be between 0 and 100
- Name cannot be empty
- Grade: >=90 A, >=75 B, >=60 C, >=40 D, else F
- Result is FAIL if ANY single subject is below 35, even if the
  overall percentage would otherwise pass
- Searching/updating/deleting an unknown roll number shows
  "Student not found" instead of crashing
- Any non-numeric or out-of-range input is caught and re-prompted;
  the program never throws an exception or exits unexpectedly

BONUS FEATURES ATTEMPTED
-------------------------
- Boxed report card for one student (menu option 10)
- Class average for each subject (menu option 11)
- Top 3 students only, by percentage (menu option 12)

CLASS DESIGN
-------------
Student.java          - private fields (rollNo, name, marks[5]) with
                        getters/setters; getTotal(), getPercentage(),
                        getGrade(), isPass(), toString()
StudentManager.java   - holds an ArrayList<Student>; add(), findByRoll(),
                        update(), delete(), getTopper(), sortByPercent(),
                        countGrade(), getSubjectTopper(), getSubjectAverage()
Main.java             - Scanner-based menu loop (do-while style via a
                        boolean flag + switch), all input validation

Console application only - uses java.util.Scanner and java.util.ArrayList.
No GUI, database or file storage, as required by the guidelines.
