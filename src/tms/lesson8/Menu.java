package tms.lesson8;

import java.util.Scanner;

public class Menu {

    public final static String EXIT = "ВЫХОД";

    public void start() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            Calculator calculator = new CalculatorImpl();
            System.out.println("Введите данные для операции или ВЫХОД, чтобы завершить программу:");
            String firstNumber = scanner.nextLine();
            if (firstNumber.equalsIgnoreCase(EXIT)) {
                break;
            }
            String secondNumber = scanner.nextLine();
            if (secondNumber.equalsIgnoreCase(EXIT)) {
                break;
            }
            String operation = scanner.nextLine();
            if (operation.equalsIgnoreCase(EXIT)) {
                break;
            }

            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                try {
                    calculator.operation(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), operation);
                } catch (Exception e) {
                    System.out.println("Введите корректные числа!");
                }
            } else {
                System.out.println("Введите корркетный оператор!");
            }
        }
    }
}