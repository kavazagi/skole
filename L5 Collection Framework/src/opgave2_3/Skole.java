package opgave2_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Skole {
    private String navn;
    private Map<Integer, Studerende> studerende = new HashMap<>();

    public Skole(String navn) {
        this.navn = navn;
    }

    public Set<Studerende> getStuderende() {
        return studerende;
    }

    public String getNavn() {
        return navn;
    }

    public void addStuderende(int studieNr, Studerende studerende) {
        this.studerende.put(studieNr, studerende);
    }

    public void removeStuderende(int studieNr, Studerende studerende) {
        this.studerende.remove(studieNr, studerende);
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
