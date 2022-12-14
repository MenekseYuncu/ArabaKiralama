
package Islemler;

import arackiralama.Baglanti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import tablo.Kullanici;

/**
 *
 * @author baior
 */
public class KullaniciIslemleri {
    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparableStatement = null;

    public KullaniciIslemleri() {
        String url = "jdbc:mysql://"+Baglanti.Host+":"+Baglanti.port+"/"+Baglanti.DataBase;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadı");
        }
        
        try {
            conn = DriverManager.getConnection(url,Baglanti.KullaniciAdi,Baglanti.Sifre);
            System.out.println("baglandi");
            
        } catch (SQLException ex) {
            System.out.println("baglanti basarısız");
        }
    }
    
    public ArrayList<Kullanici> Listele(){
        
        ArrayList<Kullanici> cikti = new ArrayList<Kullanici>();
        try {
            statement = conn.createStatement();
            String sorgu = "select * from kullanici";
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {                
                int id = rs.getInt("kulID");
                String adi = rs.getString("adi");
                String soyadi = rs.getString("soyadi");
                String tcno = rs.getString("tcNo");
                Date dogumtarihi = rs.getDate("dogumTarihi");
                String mail = rs.getString("mail");
                Date kayitTarihi = rs.getDate("kayitTarihi");
                int aktifMi = rs.getInt("aktifMi");
                
                cikti.add(new Kullanici(id, adi, soyadi, tcno, dogumtarihi, mail, kayitTarihi, aktifMi));
            }
            return  cikti;
            
        } catch (SQLException ex) {
            System.out.println("hata : "+ex);
            return null;
        }
        
       
    }
    
    public boolean Ekle(String adi, String soyadi, String tcNo,String mail, int aktifmi, Date dogumtarihi, Date kayittarihi){
        String sorgu = "Insert Into kullanici(adi,soyadi,tcNo,mail,aktifMi,dogumTarihi,kayitTarihi) values (?,?,?,?,?,?,?)";
        
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            
            preparableStatement.setString(1, adi);
            preparableStatement.setString(2, soyadi);
            preparableStatement.setString(3, tcNo);
            preparableStatement.setString(4, mail);
            preparableStatement.setInt(5, aktifmi);
            preparableStatement.setDate(6, (java.sql.Date) dogumtarihi);
            preparableStatement.setDate(7, (java.sql.Date) kayittarihi);
            preparableStatement.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     public boolean guncelle(String adi,String soyadi,String tcno,String mail,int aktifMi,int kullID,Date dogumtarihi,Date kayittarihi){
        
        String sorgu="update kullanici set adi=? "
                + ", soyadi=? , tcno=? , mail=?,dogumTarihi=? ,kayitTarihi=?, aktifMi=? where kulID = ?";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setString(1, adi);
            preparableStatement.setString(2, soyadi);
            preparableStatement.setString(3, tcno);            
            preparableStatement.setString(4, mail);
            preparableStatement.setDate(5, (java.sql.Date) dogumtarihi);
            preparableStatement.setDate(6, (java.sql.Date) kayittarihi);
            preparableStatement.setInt(7, aktifMi);
            preparableStatement.setInt(8, kullID);
            preparableStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
    }
    
    public boolean sil(int id){
        String sorgu = "delete from kullanici where kulID=?";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setInt(1, id);
            preparableStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
