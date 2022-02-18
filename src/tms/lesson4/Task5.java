package tms.lesson4;

public class Task5 {
    public static void main(String[] args) {
        new Task5().solution();
    }

    public void solution() {
        int[] arrayA = new int[5];
        int[] arrayB = new int[5];

        ArrayUtil.fillRandom(15, arrayA);
        ArrayUtil.fillRandom(15, arrayB);
        ArrayUtil.print(arrayA);
        ArrayUtil.print(arrayB);

        int sumA = sum(arrayA);
        int sumB = sum(arrayB);

        if (sumA / arrayA.length > sumB / arrayB.length) {
            System.out.println("СА массива A больше");
        } else if (sumB / arrayB.length > sumA / arrayA.length) {
            System.out.println("СА массива B больше");
        } else {
            System.out.println("СА равны");
        }
    }

    private int sum(int[] array) {
        int sum = 0;
        for (int item : array) {
            sum += item;
        }
        return sum;
    }
}
