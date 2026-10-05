//  Day 1    6th Question    Largest of three numbers

public class LargestOfThree {
    public static void main(String[] args) {
          int a = 45;
        int b = 89;
        int c = 23;

        if (a >= b && a >= c) {
            System.out.println("Largest number is " + a);
        } 
        else if (b >= a && b >= c) {
            System.out.println("Largest number is " + b);
        } 
        else {
            System.out.println("Largest number is " + c);
        }
    }
    
}
