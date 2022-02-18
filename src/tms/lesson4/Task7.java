package tms.lesson4;

public class Task7 {
    public static void main(String[] args) {
        new Task7().solution();
    }

    public void solution() {
        int[] array = new int[12];

        ArrayUtil.fillRandom(15, array);

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
}
