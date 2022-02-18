package tms.lesson4;

public class Task8 {
    public static void main(String[] args) {
        new Task8().solution();
    }

    public void solution() {
        int[] arrayA = new int[10];
        int[] arrayB = new int[10];
        double[] arrayC = new double[10];

        ArrayUtil.fillRandom(9, arrayA);
        ArrayUtil.fillRandom(9, arrayB);

        int count = 0;
        for (int i = 0; i < 10; i++) {
            arrayC[i] = (double) arrayA[i] / arrayB[i];
            if (arrayC[i] % 1 == 0) {
                count++;
            }
        }

        ArrayUtil.print(arrayA);
        ArrayUtil.print(arrayB);
        ArrayUtil.printDouble(arrayC);

        System.out.println("Целые числа: " + count);
    }
}
