package opgave3;

import java.util.ArrayList;
import java.util.Arrays;

public class TestFlettesortering {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(Arrays.asList(new Integer[] { 98, 99, 123, 12, 56, 66637, 1, 12, 0, 4, 56, 107 }));
        System.out.println(list);

        MergeSortDone sort = new MergeSortDone();
        sort.fletteSort(list);
        System.out.println();
        System.out.println(list);
    }

}
