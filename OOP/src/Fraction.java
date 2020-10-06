import java.util.Scanner;

public class Fraction {

    public int numerator, denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void reduce() {
        int divitor = mHCD(numerator, denominator);
        numerator = numerator / divitor;
        denominator = denominator / divitor;
    }

    public void add(Fraction other) {
        other.reduce();
        quydong(other);

        this.numerator += other.numerator;
        this.reduce();
    }

    public void subtract(Fraction other) {
        other.reduce();
        quydong(other);

        this.numerator -= other.numerator;
        this.reduce();
    }

    public void multiply(Fraction other) {
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
        this.reduce();
    }

    public void divide(Fraction other) {
        this.numerator *= other.denominator;
        this.denominator *= other.numerator;
        this.reduce();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            if (this.denominator == other.denominator && this.numerator == (other.numerator)) return true;
        }
        return false;
    }

    public void quydong(Fraction other) {
        int cm = mSCM(this.denominator, other.denominator);
        other.denominator *= cm;
        other.numerator *= cm;
        this.numerator *= cm;
        this.denominator *= cm;
    }

    static int mSCM(int a, int b) {
        int max = a * b;
        int lcm = max;
        int step = Math.max(a, b);
        for (int i = step; i > Math.min(a, b); i += step) {
            if (i % a == 0 && i % b == 0) {
                lcm = i;
                break;
            }
        }
        return lcm;
    }

    static int mHCD(int a, int b) {
        int tmp = Math.max(a, b);
        for (int i = tmp; i > 0; i--) {
            if (a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }


}
