//  Day 1    3rd Question      Swap Two Numbers

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 15;
        int b = 40;
        System.out.println("Before: a = " + a + ", b = " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After: a = " + a + ", b = " + b);
    }
}
