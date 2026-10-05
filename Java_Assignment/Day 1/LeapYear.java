//  Day 1  9th Question  Leap year check

public class LeapYear {
    static void check(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
            System.out.println( y + " is a Leap Year");
        } 
        else {
            System.out.println(y + " is Not a Leap Year");
        }
    }

    public static void main(String[] args) {
        check(2024);
        check(1900);
        check(2000);
    }   
}
