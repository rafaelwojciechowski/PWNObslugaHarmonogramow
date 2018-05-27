package javaFX_obslugaHarmonogramow.model;

import java.util.Date;
import java.util.List;

public class Szkolenie {

    private int sID;
    private String sAkronim;
    private Date sDataOd, sDataDo;
    private String sTryb;
    private int sIDkursy;

    public Szkolenie(int sID, String sAkronim, Date sDataOd, Date sDataDo, String sTryb, int sIDkursy) {
        this.sID = sID;
        this.sAkronim = sAkronim;
        this.sDataOd = sDataOd;
        this.sDataDo = sDataDo;
        this.sTryb = sTryb;
        this.sIDkursy = sIDkursy;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getsAkronim() {
        return sAkronim;
    }

    public void setsAkronim(String sAkronim) {
        this.sAkronim = sAkronim;
    }

    public Date getsDataOd() {
        return sDataOd;
    }

    public void setsDataOd(Date sDataOd) {
        this.sDataOd = sDataOd;
    }

    public Date getsDataDo() {
        return sDataDo;
    }

    public void setsDataDo(Date sDataDo) {
        this.sDataDo = sDataDo;
    }

    public String getsTryb() {
        return sTryb;
    }

    public void setsTryb(String sTryb) {
        this.sTryb = sTryb;
    }

    public int getsIDkursy() {
        return sIDkursy;
    }

    public void setsIDkursy(int sIDkursy) {
        this.sIDkursy = sIDkursy;
    }

}
