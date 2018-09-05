package opgave2_3;

import java.util.ArrayList;

public class Studerende {
    private int studieNr;
    private String navn;
    private ArrayList<Integer> karakterer = new ArrayList<>();

    public Studerende(int studieNr, String navn, ArrayList<Integer> karakterer) {
        this.studieNr = studieNr;
        this.navn = navn;
        this.karakterer = karakterer;
    }

    public void addKarakterer(int karakter) {
        this.karakterer.add(karakter);
    }

    public ArrayList<Integer> getKarakterer() {
        return new ArrayList<>(karakterer);
    }

    public int getStudieNr() {
        return studieNr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return "Student navn: " + getNavn() + " \t " + "Studenter nr: " + getStudieNr() + " \t " + "Karakter: "
                + getKarakterer() + "\n";
    }

}
