package tms.lesson5;

public class Task4 {
    public void solution() {
        System.out.println("Lesson5/Task4:");
        int[][] array = ArrayUtil.createArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - i - 1; j++) {
                if (array[i][j] % 2 == 0) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
