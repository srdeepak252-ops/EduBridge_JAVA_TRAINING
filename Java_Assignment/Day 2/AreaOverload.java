// Day 2  10th Question  Overload area method

public class AreaOverload {
    static int area(int side) {
        return side * side;
    }

    static int area(int l, int w) {
        return l * w;
    }

    static double area(double r) {
        return 3.14 * r * r;
    }

    public static void main(String[] args) {
        System.out.println("Square area    = " + area(4));
        System.out.println("Rectangle area = " + area(4, 6));
        System.out.println("Circle area    = " + area(2.0));
    }
}