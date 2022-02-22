package tms.lesson5;

public class Task2 {
    public void solution() {
        System.out.println("Lesson5/Task2:");
        int[][] array = ArrayUtil.createArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (array[i][j] % 2 != 0) {
                    System.out.print(array[i][j] + "  ");
                }
            }
        }
    }
}
