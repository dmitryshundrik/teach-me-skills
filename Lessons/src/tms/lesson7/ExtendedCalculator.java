package tms.lesson7;

import java.util.Scanner;

public class ExtendedCalculator extends Calculator {

    public static void main(String[] args) {
        ExtendedCalculator extendedCalculator = new ExtendedCalculator();
        extendedCalculator.multiply();
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void sum() {
        System.out.println(scanner.nextDouble() + scanner.nextDouble());
    }

    @Override
    public void subtraction() {
        System.out.println(scanner.nextDouble() - scanner.nextDouble());
    }

    @Override
    public void multiply() {
        System.out.println(scanner.nextDouble() * scanner.nextDouble());
    }

    @Override
    public void division() {
        System.out.println(scanner.nextDouble() - scanner.nextDouble());
    }
}
