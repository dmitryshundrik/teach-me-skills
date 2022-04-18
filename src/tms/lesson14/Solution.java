package tms.lesson14;

public class Solution {
    public static void main(String[] args) {

        Task1 task1 = (string) -> System.out.println(string);
        task1.print("Hello");

        Task2 task2 = (i) -> System.out.println(i % 2 == 0 ? "Четное" : "Нечетное");
        task2.math(4);

        Task3 sum = (a, b) -> System.out.println(a + b);
        sum.calculate(2, 3);

        Task3 subtraction = (a, b) -> System.out.println(a - b);
        subtraction.calculate(10, 2);

        Task3 multiply = (a, b) -> System.out.println(a * b);
        multiply.calculate(10, 2);

        Task3 division = (a, b) -> System.out.println(a / b);
        division.calculate(10, 2);
    }
}
