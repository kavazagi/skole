package opgave2;

import java.util.ArrayList;
import java.util.List;

public class Studerende {
    private int studieNr;
    private String navn;
    List<Integer> karakterer = new ArrayList<>();

    public Studerende(int studieNr, String navn, List<Integer> karakterer) {
        this.studieNr = studieNr;
        this.navn = navn;
        this.karakterer = karakterer;
    }

    public void addKarakterer(int karakter) {
        this.karakterer.add(karakter);
    }

    public List<Integer> getKarakterer() {
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
