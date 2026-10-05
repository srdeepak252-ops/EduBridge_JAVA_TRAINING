// Day 3  1st Question  Largest of three using a method

public class LargestMethod {
    static int max(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        int result = max(12, 45, 30);
        System.out.println("Largest = " + result);
    }
}