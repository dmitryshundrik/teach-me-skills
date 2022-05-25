package tms.lesson5;

public class Task5 {
    public void solution() {
        System.out.println("Lesson5/Task5:");
        int[][] array = ArrayUtil.createArray();
        array = transformArray(array);
        ArrayUtil.printArray(array);

    }

    private int[][] transformArray(int[][] array) {
        int[][] newArray = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                newArray[i][j] = array[j][i];
            }
        }
        System.out.println();
        return newArray;
    }
}
