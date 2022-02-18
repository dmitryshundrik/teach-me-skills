package tms.lesson4;

public class Task6 {
    public static void main(String[] args) {
        new Task6().solution();
    }

    public void solution() {
        boolean value = true;
        int[] array = new int[4];

        ArrayUtil.fillRandom(10, array);
        ArrayUtil.print(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (i + 1 < array[i]) {
                value = false;
                break;
            }
        }
        System.out.println(value ? "является" : "не является");
    }
}
