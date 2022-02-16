package tms;

import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();

        task11(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        task12(new int[]{2, 2, 4, 4});
        task13(3, new int[]{2, 2, 4, 4});
        task14(new int[]{9, 8, 7, 3, 2, 1, 6, 5, 4});
        task15(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        task16(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        task17(5, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        task18(new int[]{9, 8, 7, 3, 2, 1, 6, 5, 4});
        task19(new int[]{9, 8, 7, 3, 2, 1, 6, 5, 4});
        task20(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    private static void task1() {
        int[] array = new int[10];
        int count = 0;
        for (int i = 2; i <= 20; i++) {
            if (i % 2 == 0) {
                array[count] = i;
                count++;
            }
        }
        for (int item : array) {
            System.out.print(item + " ");
        }

        System.out.println();

        for (int item : array) {
            System.out.println(item);
        }

    }

    private static void task2() {
        int a = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0) {
                a++;
            }
        }
        int[] array = new int[a];
        int b = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0) {
                array[b] = i;
                b++;
            }
        }
        for (int item : array) {
            System.out.print(item + " ");
        }

        System.out.println();

        for (int i = a - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }

    }

    private static void task3() {
        int count = 0;
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 99);
        }
        System.out.println();
        for (int item : array) {
            if (item % 2 == 0) {
                count++;
            }
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println(count);
    }

    private static void task4() {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20);
        }
        for (int item : array) {
            System.out.print(item + " ");
        }
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }
        System.out.println();
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

    private static void task5() {
        int[] arrayA = new int[5];
        int[] arrayB = new int[5];
        for (int i = 0; i < 5; i++) {
            arrayA[i] = (int) (Math.random() * 15);
            arrayB[i] = (int) (Math.random() * 15);
        }
        System.out.println();
        int sumA = 0;
        int sumB = 0;
        for (int item : arrayA) {
            sumA += item;
            System.out.print(item + " ");
        }
        System.out.println();
        for (int item : arrayB) {
            sumB += item;
            System.out.print(item + " ");
        }
        System.out.println();
        if (sumA / arrayA.length > sumB / arrayB.length) {
            System.out.println("СА массив A больше");
        } else if (sumB / arrayB.length > sumA / arrayA.length) {
            System.out.println("СА массива B больше");
        } else {
            System.out.println("СА равны");
        }
    }

    private static void task6() {
        boolean value = true;
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        for (int item : array) {
            System.out.print(item + " ");
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (i + 1 < array[i]) {
                value = false;
                break;
            }
        }
        System.out.println(value ? "является" : "не является");
    }

    private static void task7() {
        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 15);
        }
        int max = array[0];
        int value = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
                value = i;
            }
        }
        System.out.println("Адрес: " + value);
    }

    private static void task8() {
        int count = 0;
        int[] arrayA = new int[10];
        int[] arrayB = new int[10];
        double[] arrayC = new double[10];
        for (int i = 0; i < 10; i++) {
            arrayA[i] = (int) (Math.random() * 9);
            arrayB[i] = (int) (Math.random() * 9);
            arrayC[i] = (double) arrayA[i] / arrayB[i];
            if (arrayC[i] % 1 == 0) {
                count++;
            }
        }
        for (int item : arrayA) {
            System.out.print(item + " ");
        }
        System.out.println();
        for (int item : arrayB) {
            System.out.print(item + " ");
        }
        System.out.println();
        for (double item : arrayC) {
            System.out.print(item + " ");
        }
        System.out.println("Целые числа: " + count);
    }

    private static void task9() {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (true) {
            value = scanner.nextInt();
            if (value > 0 && value % 2 == 0) {
                break;
            } else {
                System.out.println("Введите корректное число!");
            }
        }
        int[] array = new int[value];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 15);
        }
        for (int item : array) {
            System.out.print(item + " ");
        }
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length / 2) {
                sumA += array[i];
            } else {
                sumB += array[i];
            }
        }
        System.out.println(sumA == sumB ? "Половины равны" : sumA > sumB ? "Первая половина больше" :
                "Вторая половина больше");
    }

    private static void task10() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (true) {
            n = scanner.nextInt();
            if (n > 3) {
                break;
            } else {
                System.out.println("Введите корректное число!");
            }
        }
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * n);
        }
        for (int item : array) {
            System.out.print(item + " ");
        }
        int count = 0;
        for (int item : array) {
            if (item % 2 == 0) {
                count++;
            }
        }
        int[] arrayEvenNumbers = new int[count];
        count = 0;
        for (int item : array) {
            if (item % 2 == 0) {
                arrayEvenNumbers[count] = item;
                count++;
            }
        }
        System.out.println();
        for (int item : arrayEvenNumbers) {
            System.out.print(item + " ");
        }
    }

    private static void task11(int[] array) {
        int value = 1;
        for (int item : array) {
            if (item % 3 == 0) {
                value *= item;
            }
        }
        System.out.println();
        System.out.println(value);
    }

    private static void task12(int[] array) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                count++;
                sum += array[i];
            }
        }
        System.out.println(sum / count);

    }

    private static void task13(int c, int[] array) {
        int count = 0;
        int sum = 0;
        for (int items : array) {
            if (items > c) {
                count++;
                sum += items;
            }
        }
        System.out.println(sum / count);
    }

    private static void task14(int[] array) {
        int min = array[0];
        for (int item : array) {
            if (item < min && item % 2 != 0) {
                min = item;
            }
        }
        System.out.println(min);
    }

    private static void task15(int[] array) {
        int[] anotherArray = new int[array.length];
        int count = 0;
        for (int i = 0; i < anotherArray.length; i++) {
            if (i % 2 != 0) {
                anotherArray[count] = array[i];
                count++;
            }
        }
        for (int item : anotherArray) {
            System.out.print(item + " ");
        }
    }

    private static void task16(int[] array) {
        boolean value = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    value = false;
                    break;
                }
            }
            if (!value) {
                break;
            }
        }
        System.out.println();
        System.out.println(value ? "Нет совпадений" : "Есть совпадения");
    }

    private static void task17(int value, int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void task18(int[] array) {
        int max1 = array[0];
        int max2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max1) {
                max1 = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != max1 && array[i] > max2) {
                max2 = array[i];
            }
        }
        System.out.println(max1 + " " + max2);
    }

    private static void task19(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min && i % 2 == 0) {
                min = array[i];
            }
        }
        System.out.println(min);
    }

    private static void task20(int[] array) {
        int max = array[0];
        int indexMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
        }
        int zero = array[0];
        array[0] = max;
        array[indexMax] = zero;

        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
