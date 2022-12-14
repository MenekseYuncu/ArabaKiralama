/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablo;

/**
 *
 * @author baior
 */
public class Araclar {
    private int AracID;
    private String plaka;
    private String marka;
    private String model;
    private int uretimYili;
    private String yakitTuru;
    private int kapiSayisi;
    private Float motorHacmi;
    private String kasaTipi;
    private String sanzimanTipi;
    private int koltukSayisi;
    private String ehliyetSinifi;
    private int aktifMi;
    private int tutar;

    public Araclar(int AracID, String plaka, String marka, String model, int uretimYili, String yakitTuru, int kapiSayisi, Float motorHacmi, String kasaTipi, String sanzimanTipi, int koltukSayisi, String ehliyetSinifi, int aktifMi, int tutar) {
        this.AracID = AracID;
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.uretimYili = uretimYili;
        this.yakitTuru = yakitTuru;
        this.kapiSayisi = kapiSayisi;
        this.motorHacmi = motorHacmi;
        this.kasaTipi = kasaTipi;
        this.sanzimanTipi = sanzimanTipi;
        this.koltukSayisi = koltukSayisi;
        this.ehliyetSinifi = ehliyetSinifi;
        this.aktifMi = aktifMi;
        this.tutar = tutar;
    }

    public int getAracID() {
        return AracID;
    }

    public void setAracID(int AracID) {
        this.AracID = AracID;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getUretimYili() {
        return uretimYili;
    }

    public void setUretimYili(int uretimYili) {
        this.uretimYili = uretimYili;
    }

    public String getYakitTuru() {
        return yakitTuru;
    }

    public void setYakitTuru(String yakitTuru) {
        this.yakitTuru = yakitTuru;
    }

    public int getKapiSayisi() {
        return kapiSayisi;
    }

    public void setKapiSayisi(int kapiSayisi) {
        this.kapiSayisi = kapiSayisi;
    }

    public Float getMotorHacmi() {
        return motorHacmi;
    }

    public void setMotorHacmi(Float motorHacmi) {
        this.motorHacmi = motorHacmi;
    }

    public String getKasaTipi() {
        return kasaTipi;
    }

    public void setKasaTipi(String kasaTipi) {
        this.kasaTipi = kasaTipi;
    }

    public String getSanzimanTipi() {
        return sanzimanTipi;
    }

    public void setSanzimanTipi(String sanzimanTipi) {
        this.sanzimanTipi = sanzimanTipi;
    }

    public int getKoltukSayisi() {
        return koltukSayisi;
    }

    public void setKoltukSayisi(int koltukSayisi) {
        this.koltukSayisi = koltukSayisi;
    }

    public String getEhliyetSinifi() {
        return ehliyetSinifi;
    }

    public void setEhliyetSinifi(String ehliyetSinifi) {
        this.ehliyetSinifi = ehliyetSinifi;
    }

    public int getAktifMi() {
        return aktifMi;
    }

    public void setAktifMi(int aktifMi) {
        this.aktifMi = aktifMi;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }
    
    
}
