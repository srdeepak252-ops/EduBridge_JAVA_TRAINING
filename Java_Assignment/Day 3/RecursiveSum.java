//  Day 3   5th Question   Recursive sum of 1 to n

public class RecursiveSum {
    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }

        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Sum of 1 to " + n + " = " + sum(n));
    }
}