package opgave2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Laver en ArrayList med karaktere for hvert enkelt studerende, og tilføjer
        // karaktere til dem
        ArrayList<Integer> karakter1 = new ArrayList<>();
        karakter1.add(07);
        karakter1.add(12);
        karakter1.add(04);

        ArrayList<Integer> karakter2 = new ArrayList<>();
        karakter2.add(12);
        karakter2.add(10);
        karakter2.add(02);

        ArrayList<Integer> karakter3 = new ArrayList<>();
        karakter3.add(02);
        karakter3.add(04);
        karakter3.add(10);

        Studerende student1 = new Studerende(1, "Morten", karakter1);
        Studerende student2 = new Studerende(2, "Hans", karakter2);
        Studerende student3 = new Studerende(3, "Peter", karakter3);

        // De studerende på skolen
        ArrayList<Studerende> student = new ArrayList<>();
        student.add(student1);
        student.add(student2);
        student.add(student3);

        Skole s1 = new Skole("Erhvervs Akademi", student);

        System.out.println(s1);
        System.out.println("");
        System.out.println(s1.findStuderende(1));
        System.out.println("");
        System.out.println("Gennemsnits karakteren for alle eleverne på skolen: " + s1.gennemsnit());

    }

}
