package javaFX_obslugaHarmonogramow.model;

public class KategoriaTematyczna {

    private int ktID;
    private String ktNazwa;

    public KategoriaTematyczna(int ktID, String ktNazwa) {
        this.ktID = ktID;
        this.ktNazwa = ktNazwa;
    }

    public int getKtID() {
        return ktID;
    }

    public void setKtID(int ktID) {
        this.ktID = ktID;
    }

    public String getKtNazwa() {
        return ktNazwa;
    }

    public void setKtNazwa(String ktNazwa) {
        this.ktNazwa = ktNazwa;
    }

}
