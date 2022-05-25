package tms.lesson4;

public class Task1 {
    public static void main(String[] args) {
        new Task1().solution();
    }

    public void solution() {
        int[] array = new int[10];
        int count = 0;

        for (int i = 2; i <= 20; i++) {
            if (i % 2 == 0) {
                array[count] = i;
                count++;
            }
        }

        ArrayUtil.print(array);
        ArrayUtil.println(array);

    }
}
