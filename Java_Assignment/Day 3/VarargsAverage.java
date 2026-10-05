// Day 3   3rd Question  Average with varargs

public class VarargsAverage {
    static double average(double...nums) {
        double sum = 0;

        for (double n : nums) {
            sum += n;
        }

        return sum / nums.length;
    }

    public static void main(String[] args) {
        System.out.println("Average 1 = " + average(4, 8, 6));
        System.out.println("Average 2 = " + average(10, 20));
    }
}