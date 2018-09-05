package opgaverBogen;

public class OpgaveP12_8 {

    public static int findStørsteElement(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        } else {
            return Integer.max(findStørsteElement(array, index + 1), array[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 5, 7, 2, 3, 7, 23, 4, 7, 23, 5, 45, 2, 34 };
        int størsteElement = findStørsteElement(array, 1);
        System.out.println("Det største element i arrayet er " + størsteElement);
    }

}
