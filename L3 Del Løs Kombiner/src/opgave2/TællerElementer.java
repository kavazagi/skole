package opgave2;

import java.util.ArrayList;

public class TællerElementer {

    public static int værdiNul(ArrayList<Integer> list) {
        return findNul(list, list.get(0), list.size() - 1);
    }

    private static int findNul(ArrayList<Integer> list, int l, int h) {
        if (l == h) {
            if (list.get(l) == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int m = (l + h) / 2;
            int nul1 = findNul(list, l, m);
            int nul2 = findNul(list, m + 1, h);
            return nul1 + nul2;
        }
    }

}
