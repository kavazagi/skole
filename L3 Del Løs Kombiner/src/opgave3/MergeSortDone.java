package opgave3;

import java.util.ArrayList;

public class MergeSortDone {

    public void fletteSort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size() - 1);
    }

    private void mergesort(ArrayList<Integer> list, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergesort(list, l, m);
            mergesort(list, m + 1, h);
            merge(list, l, m, h);
        }
    }

    private void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> s1 = new ArrayList<Integer>(list.subList(low, middle + 1));
        ArrayList<Integer> s2 = new ArrayList<Integer>(list.subList(middle + 1, high + 1));

        int i1 = 0;
        int i2 = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1).compareTo((s2.get(i2))) <= 0) {
                // s1's første tal er mindst
                result.add(s1.get(i1));
                i1 = i1 + 1;
            } else { // s2's første tal er mindst
                result.add(s2.get(i2));
                i2 = i2 + 1;
            }
        }
        // tøm den liste der ikke er tom
        while (i1 < s1.size()) {
            result.add(s1.get(i1));
            i1 = i1 + 1;
        }
        while (i2 < s2.size()) {
            result.add(s2.get(i2));
            i2 = i2 + 1;
        }
        for (int i = 0; i < result.size(); i++) {
            list.set(low + i, result.get(i));
        }
    }

}