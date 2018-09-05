package opgave2_2;

import java.util.HashSet;
import java.util.Set;

public class Skole {
    private String navn;
    private Set<Studerende> studerende = new HashSet<>();

    public Skole(String navn, Set<Studerende> studerende) {
        this.navn = navn;
        this.studerende = studerende;
    }

    public Set<Studerende> getStuderende() {
        return studerende;
    }

    public String getNavn() {
        return navn;
    }

    public void addStuderende(Studerende studerende) {
        this.studerende.add(studerende);
    }

    public void removeStuderende(Studerende studerende) {
        this.studerende.remove(studerende);
    }

    public double gennemsnit() {
        double sum = 0;
        double gennemsnit = 0;
        for (Studerende s : studerende) {
            for (int karakter : s.getKarakterer()) {
                sum = sum + karakter;
            }
            gennemsnit = sum / (s.getKarakterer().size() * this.studerende.size());
        }
        return gennemsnit;
    }

    public Studerende findStuderende(int studieNr) {
        Studerende studerende = null;
        for (Studerende s : this.studerende) {
            if (s.getStudieNr() == studieNr) {
                studerende = s;
            }
        }
        return studerende;
    }

    @Override
    public String toString() {
        return "Skole navn " + getNavn() + "\n\n" + "Studerende på skolen " + "\n" + getStuderende();
    }

}
