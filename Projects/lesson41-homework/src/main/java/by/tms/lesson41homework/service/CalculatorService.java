package by.tms.lesson41homework.service;

import by.tms.lesson41homework.entity.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String executeOperation(Operation operation) {
        int firstNumber = Integer.parseInt(operation.getFirstNumber());
        int secondNumber = Integer.parseInt(operation.getSecondNumber());
        int result = 0;
        switch (operation.getOperation()) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }
        return String.valueOf(result);
    }
}
