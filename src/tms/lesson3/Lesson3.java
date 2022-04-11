package tms;

public class Lesson3 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4(5, 9);
        task5();
        task6();
        task7();
        task8();
        task9();
        task10(100);
        task11(79);
        task12(8123);
    }

    private static void task1() {
        double sum = 0;
        double value = 10;
        for (int i = 0; i < 7; i++) {
            sum = sum + value;
            value += (value * 0.1);
        }
        System.out.println(sum);
    }

    private static void task2() {
        int value = 1;
        for (int i = 0; i <= 24; i = i + 3) {
            System.out.print(i + " hours: " + value + "; ");
            value *= 2;
        }
        System.out.println();
    }

    private static void task3() {
        int sum = 0;
        for (int i = 0; i <= 256; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static void task4(int a, int b) {
        int value = 0;
        for (int i = 0; i < b; i++) {
            value += a;
        }
        System.out.println(value);
    }

    private static void task5() {
        System.out.print("Дюймы / Сантиметры: ");
        for (int i = 1; i <= 20; i++) {
            System.out.print(i + "/" + i * 2.54 + " ");
        }
        System.out.println();
    }

    private static void task6() {
        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void task7() {
        int sum = 0;
        for (int i = 0; i < 99; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static void task8() {
        String string = "";
        for (int i = 0; i < 3; i++) {
            string = string + "*";
            System.out.println(string);
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println(string);
            string = string.replaceFirst("\\*", " ");
        }
    }

    private static void task9() {
        int n1 = 0;
        int n2 = 1;
        int n3;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 0; i < 10; i++) {
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }

    private static void task10(int number) {
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void task11(int number) {
        boolean value = true;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0 && i != 1 && i != number) {
                value = false;
            }
        }
        if (value && number > 1) {
            System.out.println(number + " простое число");
        }
    }

    private static void task12(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        System.out.println(sum);
    }

}

