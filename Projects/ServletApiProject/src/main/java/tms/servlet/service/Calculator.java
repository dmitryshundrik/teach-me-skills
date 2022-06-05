package tms.servlet.service;

public class Calculator {

    public double calculate(double num1, double num2, String operationName) {
        double result = 0;
        switch (operationName) {
            case "sum":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
