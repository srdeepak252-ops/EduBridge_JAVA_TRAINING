//   Day 4  9th qustion  Fraction class

class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int g = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    Fraction add(Fraction f) {
        int n = this.numerator * f.denominator + f.numerator * this.denominator;
        int d = this.denominator * f.denominator;
        return new Fraction(n, d);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

public class FractionDemo {
    public static void main(String[] args) {
        Fraction a = new Fraction(6, 8);
        Fraction b = new Fraction(1, 6);
        Fraction sum = a.add(b);

        System.out.println("a   = " + a);
        System.out.println("b   = " + b);
        System.out.println("a + b = " + sum);
    }
}