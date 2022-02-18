package tms.lesson4;

public class Task2 {
    public static void main(String[] args) {
        new Task2().solution();
    }

    public void solution() {
        int length = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0) {
                length++;
            }
        }

        int[] array = new int[length];
        int count = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0) {
                array[count] = i;
                count++;
            }
        }

        ArrayUtil.print(array);

        for (int i = length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
