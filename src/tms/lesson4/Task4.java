package tms.lesson4;

public class Task4 {
    public static void main(String[] args) {
        new Task4().solution();
    }

    public void solution() {
        int[] array = new int[20];

        ArrayUtil.fillRandom(20, array);
        ArrayUtil.print(array);

        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }

        ArrayUtil.print(array);
    }
}
