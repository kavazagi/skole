package opgave3;

public class Power {
    public static long power(int n, int p) {
        if (p <= 0) {
            return 1;
        } else {
            return power(n, p - 1) * n;
        }
    }

    public static void main(String[] args) {
        System.out.println(power(10, 10));
    }

}
