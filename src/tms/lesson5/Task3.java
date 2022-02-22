package tms.lesson5;

public class Task3 {
    public void solution() {
        System.out.println("Lesson5/Task3:");
        int[][] array = ArrayUtil.createArray();
        int valueA = 1;
        int valueB = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    valueA *= array[i][j];
                } else if (i + j == array.length - 1) {
                    valueB *= array[i][j];
                }
            }
        }
        System.out.println(valueA > valueB ? "Больше диагональ А:" + valueA : "Больше диагональ В: " + valueB);
    }
}
