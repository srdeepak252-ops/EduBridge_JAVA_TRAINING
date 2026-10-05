//  Day 2   5th Question   Palindrome Number

public class PalindromeNumber {
    static void check(int number) {
        int temp = number;
        int reversed = 0;

        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp = temp / 10;
        }

        if (number == reversed) {
            System.out.println(number + " is a Palindrome");
        } else {
            System.out.println(number + " is Not a Palindrome");
        }
    }

    public static void main(String[] args) {
        check(121);
        check(123);
    }
}