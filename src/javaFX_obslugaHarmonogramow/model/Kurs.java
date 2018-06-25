package javaFX_obslugaHarmonogramow.model;

public class Kurs {

    private int ID;
    private String nazwa;
    private int ile_dni;

    public Kurs(int ID, String nazwa, int iledni) {
        this.ID = ID;
        this.nazwa = nazwa;
        this.ile_dni = iledni;
    }

    public Kurs(String nazwa, int ile_dni) {
        this.nazwa = nazwa;
        this.ile_dni = ile_dni;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
