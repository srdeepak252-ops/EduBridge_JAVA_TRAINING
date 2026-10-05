import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();
    private static final String[] SUBJECTS =
            {"Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5"};

    public static void main(String[] args) {
        System.out.println("===== REPORT CARD MANAGER =====");
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewAll(); break;
                case 3: searchStudent(); break;
                case 4: updateMarks(); break;
                case 5: deleteStudent(); break;
                case 6: showTopper(); break;
                case 7: showRankList(); break;
                case 8: showGradeSummary(); break;
                case 9: showSubjectToppers(); break;
                case 10: showBoxedReportCard(); break;
                case 11: showClassAverages(); break;
                case 12: showTopThree(); break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from the menu.");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1.Add  2.View All  3.Search  4.Update  5.Delete");
        System.out.println("6.Topper  7.Rank List  8.Grade Summary  9.Subject Toppers");
        System.out.println("10.Boxed Report Card  11.Class Averages  12.Top 3 Students  0.Exit");
    }

    // ---------- Features ----------

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");
        int roll = readPositiveInt("Roll No : ");
        if (manager.rollExists(roll)) {
            System.out.println("A student with roll number " + roll + " already exists.");
            return;
        }
        String name = readNonEmptyString("Name    : ");
        int[] marks = new int[5];
        System.out.println("Marks (5 subjects, 0-100 each):");
        for (int i = 0; i < 5; i++) {
            marks[i] = readIntInRange("  " + SUBJECTS[i] + ": ", 0, 100);
        }
        manager.add(new Student(roll, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewAll() {
        System.out.println("\n--- All Students ---");
        if (manager.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        printTableHeader();
        for (Student s : manager.getAll()) {
            System.out.println(s);
        }
    }

    private static void searchStudent() {
        int roll = readInt("\nEnter roll number to search: ");
        Student s = manager.findByRoll(roll);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        printReportCard(s);
    }

    private static void updateMarks() {
        int roll = readInt("\nEnter roll number to update: ");
        Student s = manager.findByRoll(roll);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Subjects: 1." + SUBJECTS[0] + "  2." + SUBJECTS[1] + "  3." +
                SUBJECTS[2] + "  4." + SUBJECTS[3] + "  5." + SUBJECTS[4]);
        int subChoice = readIntInRange("Choose subject to update (1-5): ", 1, 5);
        int newMark = readIntInRange("Enter new mark (0-100): ", 0, 100);
        manager.update(roll, subChoice - 1, newMark);
        System.out.println("Marks updated successfully!");
    }

    private static void deleteStudent() {
        int roll = readInt("\nEnter roll number to delete: ");
        if (manager.delete(roll)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void showTopper() {
        Student top = manager.getTopper();
        if (top == null) {
            System.out.println("\nNo students added yet.");
            return;
        }
        System.out.printf("%nTopper: %s (Roll %d) with %.2f%%%n",
                top.getName(), top.getRollNo(), top.getPercentage());
    }

    private static void showRankList() {
        if (manager.isEmpty()) {
            System.out.println("\nNo students added yet.");
            return;
        }
        ArrayList<Student> ranked = manager.sortByPercent();
        System.out.println("\n--- Rank List ---");
        System.out.printf("%-6s %-6s %-14s %-7s%n", "Rank", "Roll", "Name", "%");
        int rank = 1;
        for (Student s : ranked) {
            System.out.printf("%-6d %-6d %-14s %-7.2f%n",
                    rank++, s.getRollNo(), s.getName(), s.getPercentage());
        }
    }

    private static void showGradeSummary() {
        System.out.println("\n--- Grade Summary ---");
        for (String g : new String[]{"A", "B", "C", "D", "F"}) {
            System.out.println("Grade " + g + " : " + manager.countGrade(g));
        }
    }

    private static void showSubjectToppers() {
        if (manager.isEmpty()) {
            System.out.println("\nNo students added yet.");
            return;
        }
        System.out.println("\n--- Subject Toppers ---");
        for (int i = 0; i < SUBJECTS.length; i++) {
            Student top = manager.getSubjectTopper(i);
            System.out.println(SUBJECTS[i] + " : " + top.getName() +
                    " (Roll " + top.getRollNo() + ") - " + top.getMarks()[i]);
        }
    }

    // ---------- Bonus features ----------

    private static void showBoxedReportCard() {
        int roll = readInt("\nEnter roll number: ");
        Student s = manager.findByRoll(roll);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        String line = "+----------------------------------+";
        System.out.println("\n" + line);
        System.out.printf("| Roll No    : %-20d |%n", s.getRollNo());
        System.out.printf("| Name       : %-20s |%n", s.getName());
        for (int i = 0; i < SUBJECTS.length; i++) {
            System.out.printf("| %-10s : %-20d |%n", SUBJECTS[i], s.getMarks()[i]);
        }
        System.out.printf("| Total      : %-20d |%n", s.getTotal());
        System.out.printf("| Percentage : %-19.2f%% |%n", s.getPercentage());
        System.out.printf("| Grade      : %-20s |%n", s.getGrade());
        System.out.printf("| Result     : %-20s |%n", s.getResult());
        System.out.println(line);
    }

    private static void showClassAverages() {
        if (manager.isEmpty()) {
            System.out.println("\nNo students added yet.");
            return;
        }
        System.out.println("\n--- Class Average per Subject ---");
        for (int i = 0; i < SUBJECTS.length; i++) {
            System.out.printf("%s : %.2f%n", SUBJECTS[i], manager.getSubjectAverage(i));
        }
    }

    private static void showTopThree() {
        if (manager.isEmpty()) {
            System.out.println("\nNo students added yet.");
            return;
        }
        ArrayList<Student> ranked = manager.sortByPercent();
        System.out.println("\n--- Top 3 Students ---");
        printTableHeader();
        for (int i = 0; i < Math.min(3, ranked.size()); i++) {
            System.out.println(ranked.get(i));
        }
    }

    // ---------- Helpers ----------

    private static void printTableHeader() {
        System.out.printf("%-6s %-14s %-6s %-7s %-6s %-6s%n",
                "Roll", "Name", "Total", "%", "Grade", "Result");
    }

    private static void printReportCard(Student s) {
        System.out.println("\n--- Report Card ---");
        System.out.println("Roll No    : " + s.getRollNo());
        System.out.println("Name       : " + s.getName());
        for (int i = 0; i < SUBJECTS.length; i++) {
            System.out.println(SUBJECTS[i] + "  : " + s.getMarks()[i]);
        }
        System.out.println("Total      : " + s.getTotal());
        System.out.printf("Percentage : %.2f%%%n", s.getPercentage());
        System.out.println("Grade      : " + s.getGrade());
        System.out.println("Result     : " + s.getResult());
    }

    
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            int val = readInt(prompt);
            if (val <= 0) {
                System.out.println("Roll number must be a positive number.");
            } else {
                return val;
            }
        }
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int val = readInt(prompt);
            if (val < min || val > max) {
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } else {
                return val;
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else {
                return line;
            }
        }
    }
}
