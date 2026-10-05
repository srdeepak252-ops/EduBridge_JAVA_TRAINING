//  Day 1   7th  Question  Grade Calculator

public class GradeCalculator {
     static void printGrade(int marks) {
        String grade;

        if (marks >= 90) {
            grade = "A";
        } 
        else if (marks >= 75) {
            grade = "B";
        } 
        else if (marks >= 50) {
            grade = "C";
        } 
        else {
            grade = "F";
        }

        System.out.println(marks + " -> Grade " + grade);
    }
    public static void main(String[] args) {
        printGrade(92);
        printGrade(78);
        printGrade(55);
        printGrade(30);
    }
}
