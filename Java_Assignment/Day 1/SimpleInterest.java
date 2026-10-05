// Day 1   4th Question   Simple Interest Calculator

public class SimpleInterest {
    public static void main(String[] args) {
        double P = 10000;
        double R = 7.5;
        double T = 3;

        double SI = (P * R * T) / 100;
        double total = P + SI;

        System.out.println("Simple Interest = " + SI);
        System.out.println("Total Amount    = " + total);
    }
}
