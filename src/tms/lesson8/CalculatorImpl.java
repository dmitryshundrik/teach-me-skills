package tms.lesson8;

public class CalculatorImpl implements Calculator {
    public void operation(double firstNumber, double secondNumber, String operation) {
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
}
