package opgave2;

import java.util.ArrayList;

public class Skole {
    private String navn;
    private ArrayList<Studerende> studerende = new ArrayList<>();

    public Skole(String navn, ArrayList<Studerende> studerende) {
        this.navn = navn;
        this.studerende = studerende;
    }

    public ArrayList<Studerende> getStuderende() {
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
            for (int i = 0; i < s.getKarakterer().size(); i++) {
                sum = sum + s.getKarakterer().get(i);
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
