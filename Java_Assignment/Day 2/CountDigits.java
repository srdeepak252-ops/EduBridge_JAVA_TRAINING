//  Day 2   4th Question   Count the digits

public class CountDigits {
    public static void main(String[] args) {
        int number = 45823;
        int temp = number;
        int count = 0;

        while (temp != 0) {
            temp = temp / 10;
            count++;
        }

        System.out.println(number + " has " + count + " digits");
    }
}