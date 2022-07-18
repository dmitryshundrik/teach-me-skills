package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private final Calculator calculator;

    @Autowired
    public Application(Calculator calculator) {
        this.calculator = calculator;
    }

    public void start() {
        System.out.println("Введите number1: ");
        double firstNumber = calculator.verifyNumber();

        System.out.println("Введите number2: ");
        double secondNumber = calculator.verifyNumber();

        System.out.println("Введите операцию: ");
        String operationString = calculator.verifyOperation();

        calculator.executeOperation(firstNumber, secondNumber, operationString);

        System.out.println("Хотите продолжить?");
        if (calculator.close()) {
            start();
        } else {
            System.out.println("До свидания!");
        }

    }
}
