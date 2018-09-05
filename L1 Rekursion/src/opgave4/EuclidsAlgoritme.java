package opgave4;

public class EuclidsAlgoritme {
    public static int sfd(int a, int b) {
        if (b <= a & b % a == 0) {
            return b;
        } else {
            if (a < b) {
                return sfd(b, a);
            } else {
                return sfd(b, a % b);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(sfd(1000, 50000));
    }

}
