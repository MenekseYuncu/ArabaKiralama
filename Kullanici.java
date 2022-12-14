
package tablo;

import java.util.Date;

/**
 *
 * @author baior
 */
public class Kullanici {
    private int KullId;
    
    private String adi;
    private String soyad;
    private String TcNo;
    private Date dogum;
    private String mail;
    private Date kayitTarihi;
    private int Durum;

    public Kullanici(int KullId, String adi, String soyad, String TcNo, Date dogum, String mail, Date kayitTarihi, int Durum) {
        this.KullId = KullId;
        this.adi = adi;
        this.soyad = soyad;
        this.TcNo = TcNo;
        this.dogum = dogum;
        this.mail = mail;
        this.kayitTarihi = kayitTarihi;
        this.Durum = Durum;
    }

    public int getKullId() {
        return KullId;
    }

    public void setKullId(int KullId) {
        this.KullId = KullId;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTcNo() {
        return TcNo;
    }

    public void setTcNo(String TcNo) {
        this.TcNo = TcNo;
    }

    public Date getDogum() {
        return dogum;
    }

    public void setDogum(Date dogum) {
        this.dogum = dogum;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public int getDurum() {
        return Durum;
    }

    public void setDurum(int Durum) {
        this.Durum = Durum;
    }
    
    
}
