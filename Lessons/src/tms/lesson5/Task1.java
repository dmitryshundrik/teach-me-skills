package tms.lesson5;

public class Task1 {
    public void solution() {
        System.out.println("Lesson5/Task1:");
        int[][] array = ArrayUtil.createArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[i].length; j++) {
                if (array[i][j] % 2 == 0) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
