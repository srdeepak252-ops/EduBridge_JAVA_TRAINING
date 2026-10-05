//  Day 2   6th Question   Fibonacci series

public class FibonacciSeries {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;

        for (int i = 1; i <= 10; i++) {
            System.out.print(a + " ");
            int n = a + b;
            a = b;
            b = n;
        }
        System.out.println();
    }
}