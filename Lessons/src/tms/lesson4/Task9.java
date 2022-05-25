package tms.lesson4;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        new Task9().solution();
    }

    public void solution() {
        int value = dataInput();
        int[] array = new int[value];

        ArrayUtil.fillRandom(15, array);
        ArrayUtil.print(array);

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

    private int dataInput() {
        int value = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            value = scanner.nextInt();
            if (value > 0 && value % 2 == 0) {
                break;
            } else {
                System.out.println("Введите корректное число!");
            }
        }
        return value;
    }
}
