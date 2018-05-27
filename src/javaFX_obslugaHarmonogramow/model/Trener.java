package javaFX_obslugaHarmonogramow.model;

public class Trener {

    private int tID;
    private String tImie, tNazwisko, tInicjaly, tHaslo;
    private boolean tMentor;

    public Trener(int tID, String tImie, String tNazwisko, String tInicjaly, String tHaslo, boolean tMentor) {
        this.tID = tID;
        this.tImie = tImie;
        this.tNazwisko = tNazwisko;
        this.tInicjaly = tInicjaly;
        this.tHaslo = tHaslo;
        this.tMentor = tMentor;
    }

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String gettImie() {
        return tImie;
    }

    public void settImie(String tImie) {
        this.tImie = tImie;
    }

    public String gettNazwisko() {
        return tNazwisko;
    }

    public void settNazwisko(String tNazwisko) {
        this.tNazwisko = tNazwisko;
    }

    public String gettInicjaly() {
        return tInicjaly;
    }

    public void settInicjaly(String tInicjaly) {
        this.tInicjaly = tInicjaly;
    }

    public String gettHaslo() {
        return tHaslo;
    }

    public void settHaslo(String tHaslo) {
        this.tHaslo = tHaslo;
    }

    public boolean istMentor() {
        return tMentor;
    }

    public void settMentor(boolean tMentor) {
        this.tMentor = tMentor;
    }

}
