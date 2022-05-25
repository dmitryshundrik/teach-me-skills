package tms.lesson6;

public class Calculator {

    double a;
    double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void sum() {
        System.out.println(a + b);
    }

    public void subtraction() {
        System.out.println(a - b);
    }

    public void multiple() {
        System.out.println(a * b);
    }

    public void division() {
        System.out.println(a / b);
    }
}
