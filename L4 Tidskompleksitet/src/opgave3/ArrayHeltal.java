package opgave3;

public class ArrayHeltal {

    public static double[] prefixAverage(int[] inputTal) {
        double[] result = new double[inputTal.length];
        double sum = 0.0;

        for (int i = 0; i < inputTal.length; i++) {
            sum = sum + inputTal[i];

            result[i] = sum / (i + 1);
        }

        return result;

    }
}