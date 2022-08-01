package tms.service;

import org.springframework.stereotype.Service;
import tms.entity.Calculator;

@Service
public class CalculatorService {
    public int execute(Calculator calculator) {
        int firstNumber = Integer.parseInt(calculator.getFirstNumber());
        int secondNumber = Integer.parseInt(calculator.getSecondNumber());
        int result = 0;
        switch (calculator.getOperation()) {
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
        return result;
    }
}
