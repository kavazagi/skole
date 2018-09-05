package opgave1;

public class Towers_of_Hanoi {
    static int counter = 0;

    public static void move(int disks, int start, int slut) {
        int temp = 6 - start - slut;
        if (disks == 1) {
            System.out.println("Flyt fra " + start + " til " + slut);
        } else {
            move(disks - 1, start, temp);
            System.out.println("Flyr fra " + start + " til " + slut);
            move(disks - 1, temp, slut);
        }
        counter++;
    }

    public static void main(String[] args) {
        move(10, 1, 3);
        System.out.println("Brikkerne er flyttet " + counter + " gange");
    }

}
