package javaFX_obslugaHarmonogramow.model;

public class Kurs {

    private String kNazwa;
    private int kIleDni;

    public Kurs(String kNazwa, int kIleDni) {
        this.kNazwa = kNazwa;
        this.kIleDni = kIleDni;
    }

    public String getkNazwa() {
        return kNazwa;
    }

    public void setkNazwa(String kNazwa) {
        this.kNazwa = kNazwa;
    }

    public int getkIleDni() {
        return kIleDni;
    }

    public void setkIleDni(int kIleDni) {
        this.kIleDni = kIleDni;
    }
}
