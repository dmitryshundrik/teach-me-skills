package tms.lesson4;

public class Task3 {
    public static void main(String[] args) {
        new Task3().solution();
    }

    public void solution() {
        int[] array = new int[15];

        ArrayUtil.fillRandom(99, array);
        ArrayUtil.print(array);

        int count = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                count++;
            }
        }

        System.out.println(count);

    }
}
