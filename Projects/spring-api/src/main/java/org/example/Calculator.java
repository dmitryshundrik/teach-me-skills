package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Calculator {

    private final static String YES = "YES";
    private final static String NO = "NO";

    private final Scanner scanner;

    @Autowired
    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public double verifyNumber() {
        double number = 0;
        while (true) {
            try {
                String string = scanner.nextLine().trim();
                number = Double.parseDouble(string);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, введите еще раз:");
            }
        }
        return number;
    }

    public String verifyOperation() {
        String operation = "";
        while (true) {
            operation = scanner.nextLine().trim();
            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                return operation;
            } else {
                System.out.println("Неверный формат оператора, введите еще раз:");
            }
        }
    }

    public void executeOperation(double firstNumber, double secondNumber, String operation) {
        switch (operation) {
            case "+":
                System.out.println("Результат: " + (firstNumber + secondNumber));
                break;
            case "-":
                System.out.println("Результат: " + (firstNumber - secondNumber));
                break;
            case "*":
                System.out.println("Результат: " + (firstNumber * secondNumber));
                break;
            case "/":
                System.out.println("Результат: " + (firstNumber / secondNumber));
                break;
        }
    }

    public boolean proceed() {
        while (true) {
            System.out.println("Хотите продолжить?");
            String answer = scanner.nextLine().trim();
            if (YES.equalsIgnoreCase(answer)) {
                return true;
            }
            if (NO.equalsIgnoreCase(answer)) {
                return false;
            }
        }
    }
}
