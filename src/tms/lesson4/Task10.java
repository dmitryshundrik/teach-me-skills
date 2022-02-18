package tms.lesson4;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        new Task10().solution();
    }

    public void solution() {
        int n = dataInput();
        int[] array = new int[n];

        ArrayUtil.fillRandom(n, array);
        ArrayUtil.print(array);

        int length = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                length++;
            }
        }
        int[] arrayEvenNumbers = new int[length];
        int count = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                arrayEvenNumbers[count] = value;
                count++;
            }
        }
        ArrayUtil.print(arrayEvenNumbers);
    }

    private int dataInput() {
        int value = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            value = scanner.nextInt();
            if (value > 3) {
                break;
            } else {
                System.out.println("Введите корректное число!");
            }
        }
        return value;
    }
}
