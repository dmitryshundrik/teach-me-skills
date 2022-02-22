package tms.lesson5;

import java.util.Random;
import java.util.Scanner;

public class ArrayUtil {

    static int[][] createArray() {
        int[][] array = new int[dataInput()][dataInput()];
        fillArray(array);
        printArray(array);
        return array;
    }

    static String[][] createBoard() {
        String[][] array = new String[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = "■";
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
        return array;
    }

    private static int dataInput() {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (true) {
            value = scanner.nextInt();
            if (value <= 0) {
                System.out.println("Введите корректный размер массива!");
            } else {
                break;
            }
        }
        return value;
    }

    public static void fillArray(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
