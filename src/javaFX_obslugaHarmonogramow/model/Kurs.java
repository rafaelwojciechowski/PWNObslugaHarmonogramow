package javaFX_obslugaHarmonogramow.model;

public class Kurs {

    private int id;
    private String nazwa;
    private int ile_dni;

    public Kurs(int id, String nazwa, int iledni) {
        this.id = id;
        this.nazwa = nazwa;
        this.ile_dni = iledni;
    }

    public Kurs(String nazwa, int ile_dni) {
        this.nazwa = nazwa;
        this.ile_dni = ile_dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getIle_dni() {
        return ile_dni;
    }

    public void setIle_dni(int IleDni) {
        this.ile_dni = IleDni;
    }

}
