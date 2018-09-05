package opgave3;

public class App {

    public static void main(String[] args) {
        int[] array = { 5, 10, 5, 6, 4, 9, 8 };
        double[] resultat = ArrayHeltal.prefixAverage(array);

        for (int i = 0; i < resultat.length; i++) {
            System.out.println(resultat[i]);
        }

    }

}
