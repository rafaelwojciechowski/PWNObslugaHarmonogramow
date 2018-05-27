package javaFX_obslugaHarmonogramow.model;

public class Trener {

    private String imie, nazwisko, inicjaly;

    public Trener(String imie, String nazwisko, String inicjaly) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.inicjaly = inicjaly;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getInicjaly() {
        return inicjaly;
    }

    public void setInicjaly(String inicjaly) {
        this.inicjaly = inicjaly;
    }
}
