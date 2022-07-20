package org.example;

import org.springframework.stereotype.Component;

@Component
public class Application {
    private final CalculatorService calculator;
    private final Reader reader;
    private final Writer writer;

    private final static String NUMBER_1 = "Первое число:";
    private final static String NUMBER_2 = "Второе число:";
    private final static String OPERATION = "Операция:";
    private final static String WRONG_FORMAT = "Неверный формат, введите еще раз:";
    private final static String RESULT = "Результат: ";
    private final static String PROCEED = "Хотите продолжить?";

    public Application(CalculatorService calculator, Reader reader, Writer writer) {
        this.calculator = calculator;
        this.reader = reader;
        this.writer = writer;
    }

    public void start() {
        writer.write(NUMBER_1);
        double firstNumber = enterNumber();

        writer.write(NUMBER_2);
        double secondNumber = enterNumber();

        writer.write(OPERATION);
        String operation = enterOperation();

        writer.write(RESULT + calculator.execute(firstNumber, secondNumber, operation));

        if (proceed()) {
            start();
        }
    }

    public double enterNumber() {
        double number = 0;
        while (true) {
            try {
                number = Double.parseDouble(reader.read());
                break;
            } catch (NumberFormatException e) {
                writer.write(WRONG_FORMAT);
            }
        }
        return number;
    }

    public String enterOperation() {
        String operation = "";
        while (true) {
            operation = reader.read();
            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                return operation;
            } else {
                writer.write(WRONG_FORMAT);
            }
        }
    }

    public boolean proceed() {
        while (true) {
            writer.write(PROCEED);
            String answer = reader.read();
            if ("YES".equalsIgnoreCase(answer)) {
                return true;
            }
            if ("NO".equalsIgnoreCase(answer)) {
                return false;
            }
        }
    }
}
