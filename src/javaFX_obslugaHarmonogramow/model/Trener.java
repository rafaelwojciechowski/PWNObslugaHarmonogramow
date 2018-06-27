package javaFX_obslugaHarmonogramow.model;

public class Trener {

    private String imie, nazwisko, inicjaly, haslo;
    private int id, mentor;

    public Trener(int id, String Imie, String Nazwisko, String Inicjaly, String Haslo, int Mentor) {
        this.id = id;
        this.imie = Imie;
        this.nazwisko = Nazwisko;
        this.inicjaly = Inicjaly;
        this.haslo = Haslo;
        this.mentor = Mentor;
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

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMentor() {
        return mentor;
    }

    public void setMentor(int mentor) {
        this.mentor = mentor;
    }
}
