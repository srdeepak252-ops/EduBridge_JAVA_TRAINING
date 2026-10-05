//  Day 3   8th Question   Count Digits Recursively

public class CountDigitsRecursive {
    static int countDigits(int n) {
        if (n < 10) {
            return 1;
        }
       
        return 1 + countDigits(n / 10);
    }

    public static void main(String[] args) {
        int n = 908172;
        System.out.println(n + " has " + countDigits(n) + " digits");
    }
}
