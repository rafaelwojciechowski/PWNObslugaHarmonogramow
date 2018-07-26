package javaFX_obslugaHarmonogramow.model;

import java.time.LocalDate;

public class DniSzkol {
    private int id;
    private LocalDate dzien;
    private String wolne;
    private String szkolenie;
    private String trener;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDzien() {
        return dzien;
    }

    public void setDzien(LocalDate dzien) {
        this.dzien = dzien;
    }

    public String getWolne() {
        return wolne;
    }

    public void setWolne(String wolne) {
        this.wolne = wolne;
    }

    public String getSzkolenie() {
        return szkolenie;
    }

    public void setSzkolenie(String szkolenie) {
        this.szkolenie = szkolenie;
    }

    public String getTrener() {
        return trener;
    }

    public void setTrener(String trener) {
        this.trener = trener;
    }

    public DniSzkol(LocalDate dzien, String wolne, String trener) {
        this.dzien = dzien;
        this.wolne = wolne;
        this.trener = trener;
    }

    public DniSzkol(int id, LocalDate dzien, String wolne, String szkolenie, String trener) {
        this.id = id;
        this.dzien = dzien;
        this.wolne = wolne;
        this.szkolenie = szkolenie;
        this.trener = trener;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DniSzkol && ((DniSzkol) obj).dzien.equals(dzien);
    }

    @Override
    public String toString() {
        return "DniSzkol{" +
                "id=" + id +
                ", dzien=" + dzien +
                ", wolne=" + wolne +
                ", trener=" + trener +
                '}';
    }
}
