package tms.lesson8;

public class OperationsHistory {

    private static double[] values = new double[10];
    private static int count = 0;

    public static void setValue(double value) {
        if (count < values.length) {
            values[count] = value;
            count++;
        } else {
            count = 0;
            setValue(value);
        }
    }

    public static void printValues() {
        for (Double value : values) {
            if (value != 0) {
                System.out.println(value);
            }
        }
    }
}
