package tms.lesson8;

import java.util.Scanner;

public class Menu {

    private final static String EXIT = "ВЫХОД";
    private final static String HISTORY = "ИСТОРИЯ";
    private Scanner scanner = new Scanner(System.in);
    private Calculator calculator = new CalculatorImpl();

    public void start() {
        while (true) {
            System.out.println("Введите данные для операции, ИСТОРИЯ для просмотра списка результатов или ВЫХОД," +
                    " чтобы завершить программу:");
            String firstNumber = scanner.nextLine();
            if (isEqualWithExit(firstNumber)) {
                break;
            } else if (isEqualWithHistory(firstNumber)) {
                OperationsHistory.printValues();
                continue;
            }
            String secondNumber = scanner.nextLine();
            if (isEqualWithExit(secondNumber)) {
                break;
            } else if (isEqualWithHistory(secondNumber)) {
                OperationsHistory.printValues();
                continue;
            }
            String operation = scanner.nextLine();
            if (isEqualWithExit(operation)) {
                break;
            } else if (isEqualWithHistory(operation)) {
                OperationsHistory.printValues();
                continue;
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

    private boolean isEqualWithExit(String string) {
        return (EXIT.equalsIgnoreCase(string));
    }

    private boolean isEqualWithHistory(String string) {
        return (HISTORY.equalsIgnoreCase(string));
    }
}