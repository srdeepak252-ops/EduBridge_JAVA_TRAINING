//  Day 3   4th Question   Static vs instance

class Rectangle {
    int length;
    int width;

    int area() {
        return length * width;
    }

    static boolean isSquare(int l, int w) {
        return l == w;
    }
}

public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.length = 10;
        r.width = 5;

        System.out.println("Area = " + r.area());
        System.out.println("Is square? " + Rectangle.isSquare(r.length, r.width));
    }
}