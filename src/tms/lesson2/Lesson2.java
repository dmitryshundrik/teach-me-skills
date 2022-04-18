package tms.lesson2;

public class Lesson2 {
    public static void main(String[] args) {
        double first = (double) ((5 + 10) / 15) * 11;
        double second = (double) (10 + 10) / (2 * 3) + 2;
        double third = (double) (3 * (3 + 4)) / ((double) (4 * 4) / 5) - 2;
        System.out.println(first + " " + second + " " + third);

        task1(1000);
        task2(2, 3, 5);
        task3(2);
        task4and5(-1, 5, 3);
        task6(5, 45);
        task7(1000);

    }

    private static void task1(int number) {
        int count = 0;
        int value = number;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        if (value > 0) {
            System.out.println("task1: количество цирф: " + count + ", положительное");
        } else {
            System.out.println("task1: количество цирф: " + count + ", отрицательное");
        }
    }

    private static void task2(int a, int b, int c) {
        if (a + b > c && a + c > b  && b + c > a) {
            System.out.println("task2: треугольник существует");
        } else {
            System.out.println("task2: треугольник не существует");
        }
    }

    private static void task3(int number) {
        int result = 0;
        if (number > 0) {
            result = number + 1;
        } else if (number < 0) {
            result = number - 2;
        } else if (number == 0) {
            result = 10;
        }
        System.out.println("task3: " + result);
    }

    private static void task4and5(int a, int b, int c) {
        int positive = 0;
        int negative = 0;
        if (a > 0) {
            positive++;
        } else {
            negative++;
        }
        if (b > 0) {
            positive++;
        } else {
            negative++;
        }
        if (c > 0) {
            positive++;
        } else {
            negative++;
        }
        System.out.println("task4: " + positive + " , " + negative);
    }

    private static void task6(int a, int b) {
        System.out.println("task6: " + (a > b ? a : b));
    }

    private static void task7(int value) {
        System.out.print("task7: ");
        if (value == 1) {
            System.out.println(value + " программист");
        } else if (value % 10 == 0 || value > 9 && value < 21 || value % 10 > 4) {
            System.out.println(value + " программистов");
        } else if (value % 10 > 1 && value % 10 <= 4) {
            System.out.println(value + " программиста");
        }
    }
}