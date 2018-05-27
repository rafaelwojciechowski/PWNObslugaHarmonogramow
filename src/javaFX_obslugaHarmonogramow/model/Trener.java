package javaFX_obslugaHarmonogramow.model;

public class Trener {

    private int tID, tMentor;
    private String tImie, tNazwisko, tInicjaly, tHaslo;

    public Trener(int tID, String tImie, String tNazwisko, String tInicjaly, String tHaslo, int tMentor) {
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

    public int istMentor() {
        return tMentor;
    }

    public void settMentor(int tMentor) {
        this.tMentor = tMentor;
    }

}
