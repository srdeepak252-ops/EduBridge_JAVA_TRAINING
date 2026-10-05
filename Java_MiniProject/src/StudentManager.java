import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> list;

    public StudentManager() {
        list = new ArrayList<>();
    }

    public boolean rollExists(int rollNo) {
        return findByRoll(rollNo) != null;
    }

    public boolean add(Student s) {
        if (rollExists(s.getRollNo())) {
            return false;
        }
        list.add(s);
        return true;
    }

    public Student findByRoll(int rollNo) {
        for (Student s : list) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }
        return null;
    }

    public boolean update(int rollNo, int subjectIndex, int newMark) {
        Student s = findByRoll(rollNo);
        if (s == null) {
            return false;
        }
        s.setMarkForSubject(subjectIndex, newMark);
        return true;
    }

    public boolean delete(int rollNo) {
        Student s = findByRoll(rollNo);
        if (s == null) {
            return false;
        }
        list.remove(s);
        return true;
    }

    public ArrayList<Student> getAll() {
        return list;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Student getTopper() {
        if (list.isEmpty()) {
            return null;
        }
        Student top = list.get(0);
        for (Student s : list) {
            if (s.getPercentage() > top.getPercentage()) {
                top = s;
            }
        }
        return top;
    }

    public ArrayList<Student> sortByPercent() {
        ArrayList<Student> sorted = new ArrayList<>(list);
        int n = sorted.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sorted.get(j).getPercentage() < sorted.get(j + 1).getPercentage()) {
                    Student temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }

    public int countGrade(String grade) {
        int count = 0;
        for (Student s : list) {
            if (s.getGrade().equals(grade)) {
                count++;
            }
        }
        return count;
    }

    public Student getSubjectTopper(int subjectIndex) {
        if (list.isEmpty()) {
            return null;
        }
        Student top = list.get(0);
        for (Student s : list) {
            if (s.getMarks()[subjectIndex] > top.getMarks()[subjectIndex]) {
                top = s;
            }
        }
        return top;
    }

    public double getSubjectAverage(int subjectIndex) {
        if (list.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Student s : list) {
            sum += s.getMarks()[subjectIndex];
        }
        return sum / (double) list.size();
    }
}
