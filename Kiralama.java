/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablo;

import java.util.Date;

/**
 *
 * @author baior
 */
public class Kiralama {
    private int KiralamaID;
    private int KullId;
    private int AracId;
    private Date AlisTarih;
    private Date VerisTarih;
    private int Turar;
    private int Durum;
    private String KullAdi;
    private String plaka;

    public Kiralama(int KiralamaID, int KullId, int AracId, Date AlisTarih, Date VerisTarih, int Turar, int Durum, String KullAdi, String plaka) {
        this.KiralamaID = KiralamaID;
        this.KullId = KullId;
        this.AracId = AracId;
        this.AlisTarih = AlisTarih;
        this.VerisTarih = VerisTarih;
        this.Turar = Turar;
        this.Durum = Durum;
        this.KullAdi = KullAdi;
        this.plaka = plaka;
    }

    public int getKiralamaID() {
        return KiralamaID;
    }

    public void setKiralamaID(int KiralamaID) {
        this.KiralamaID = KiralamaID;
    }

    public int getKullId() {
        return KullId;
    }

    public void setKullId(int KullId) {
        this.KullId = KullId;
    }

    public int getAracId() {
        return AracId;
    }

    public void setAracId(int AracId) {
        this.AracId = AracId;
    }

    public Date getAlisTarih() {
        return AlisTarih;
    }

    public void setAlisTarih(Date AlisTarih) {
        this.AlisTarih = AlisTarih;
    }

    public Date getVerisTarih() {
        return VerisTarih;
    }

    public void setVerisTarih(Date VerisTarih) {
        this.VerisTarih = VerisTarih;
    }

    public int getTurar() {
        return Turar;
    }

    public void setTurar(int Turar) {
        this.Turar = Turar;
    }

    public int getDurum() {
        return Durum;
    }

    public void setDurum(int Durum) {
        this.Durum = Durum;
    }

    public String getKullAdi() {
        return KullAdi;
    }

    public void setKullAdi(String KullAdi) {
        this.KullAdi = KullAdi;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }
    
    
}
