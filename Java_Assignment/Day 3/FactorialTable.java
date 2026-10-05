//  Day 3   6th Question   Factorial Table

public class FactorialTable {
    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }
}