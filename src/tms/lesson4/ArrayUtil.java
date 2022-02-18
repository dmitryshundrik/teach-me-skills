package tms.lesson4;

public class ArrayUtil {

    public static void print(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void printDouble(double[] array) {
        for (double value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void println(int[] array) {
        for (int value : array) {
            System.out.println(value);
        }
    }

    public static void fillRandom(int maxRandom, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * maxRandom);
        }
    }

}
