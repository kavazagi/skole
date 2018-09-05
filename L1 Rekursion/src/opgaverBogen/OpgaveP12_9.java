package opgaverBogen;

public class OpgaveP12_9 {
    public static int total(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        } else {
            return array[index] + total(array, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        int total = total(array, 0);
        System.out.println("Total værdi af arrayer er " + total);
    }

}
