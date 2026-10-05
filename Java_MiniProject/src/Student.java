import java.util.Locale;

public class Student {
    private int rollNo;
    private String name;
    private int[] marks; // exactly 5 subjects

    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    
    public void setMarkForSubject(int subjectIndex, int mark) {
        marks[subjectIndex] = mark;
    }

    public int getTotal() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total;
    }

    public double getPercentage() {
        return getTotal() / (double) marks.length;
    }

    
    public String getGrade() {
        double pct = getPercentage();
        if (pct >= 90) return "A";
        if (pct >= 75) return "B";
        if (pct >= 60) return "C";
        if (pct >= 40) return "D";
        return "F";
    }

    public boolean isPass() {
        for (int m : marks) {
            if (m < 35) return false;
        }
        return true;
    }

    public String getResult() {
        return isPass() ? "PASS" : "FAIL";
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%-6d %-14s %-6d %-7.2f %-6s %-6s",
                rollNo, name, getTotal(), getPercentage(), getGrade(), getResult());
    }
}
