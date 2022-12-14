/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablo;

/**
 *
 * @author baior
 */
public class Ehliyetler {
    private int EKulID;
    private String EhliyetTuru;

    public Ehliyetler(int EKulID, String EhliyetTuru) {
        this.EKulID = EKulID;
        this.EhliyetTuru = EhliyetTuru;
    }

    public int getEKulID() {
        return EKulID;
    }

    public void setEKulID(int EKulID) {
        this.EKulID = EKulID;
    }

    public String getEhliyetTuru() {
        return EhliyetTuru;
    }

    public void setEhliyetTuru(String EhliyetTuru) {
        this.EhliyetTuru = EhliyetTuru;
    }
    
    
}
