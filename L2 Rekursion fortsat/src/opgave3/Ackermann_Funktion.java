package opgave3;

public class Ackermann_Funktion {
    public static int Ackermann(int x, int y) {
        if (x == 0) {
            return y + 1;
        } else if (y == 0) {
            return Ackermann(x - 1, 1);
        } else {
            return Ackermann(x - 1, Ackermann(x, y - 1));
        }

    }

    public static void main(String[] args) {
        System.out.println(Ackermann(1, 3));
    }

}
