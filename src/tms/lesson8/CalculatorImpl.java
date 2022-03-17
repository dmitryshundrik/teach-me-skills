package tms.lesson8;

public class CalculatorImpl implements Calculator {

    public void operation(double firstNumber, double secondNumber, String operation) {
        double result = 0;
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                System.out.println("Результат: " + result);
                break;
            case "-":
                result = firstNumber - secondNumber;
                System.out.println("Результат: " + (firstNumber - secondNumber));
                break;
            case "*":
                result = firstNumber * secondNumber;
                System.out.println("Результат: " + (firstNumber * secondNumber));
                break;
            case "/":
                result = firstNumber / secondNumber;
                System.out.println("Результат: " + (firstNumber / secondNumber));
                break;
        }
        OperationsHistory.setValue(result);
    }
}
