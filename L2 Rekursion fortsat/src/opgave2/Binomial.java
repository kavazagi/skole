package opgave2;

public class Binomial {
    public static int binomail(int m, int n) {
        if (m == 0 || m == n) {
            return 1;
        } else {
            while (0 < m && m < n) {
                return binomail(m, n - 1) + binomail(m - 1, n - 1);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(binomail(2, 10));
    }

}
