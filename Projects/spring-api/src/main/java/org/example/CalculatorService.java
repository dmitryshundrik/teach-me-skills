package org.example;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements org.example.Service {
    public String execute(double firstNumber, double secondNumber, String operation) {
        String result = "";
        switch (operation) {
            case "+":
                result = String.valueOf(firstNumber + secondNumber);
                break;
            case "-":
                result = String.valueOf(firstNumber - secondNumber);
                break;
            case "*":
                result = String.valueOf(firstNumber * secondNumber);
                break;
            case "/":
                result = String.valueOf(firstNumber / secondNumber);
                break;
        }
        return result;
    }
}
