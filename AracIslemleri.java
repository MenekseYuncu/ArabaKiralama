
package Islemler;

import arackiralama.Baglanti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tablo.Araclar;

/**
 *
 * @author baior
 */
public class AracIslemleri {
    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparableStatement = null;

    public AracIslemleri() {
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
    
    public ArrayList<Araclar> Listele(){
        ArrayList<Araclar> cikti = new ArrayList<Araclar>();
        
        try {
            statement = conn.createStatement();
            String sorgu = "Select * From araclar";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int aracID = rs.getInt("aracID");
                String plaka = rs.getString("plaka");
                String marka = rs.getString("marka"); 
                String model = rs.getString("model");
                int uretimYili = rs.getInt("uretimYili");
                String yakitTuru = rs.getString("yakitTuru");
                int kapiSayisi = rs.getInt("kapiSayisi");
                Float motorHacmi = rs.getFloat("motorHacmi");
                String kasaTipi = rs.getString("kasaTipi");
                String sanzimanTipi = rs.getString("sanzimanTipi");
                int koltukSayisi = rs.getInt("koltukSayisi");
                String ehliyetSinifi = rs.getString("ehliyetSinifi");
                int aktifMi = rs.getInt("aktifMi");
                int Tutar = rs.getInt("Tutar");
                
                cikti.add(new Araclar(aracID,plaka,marka,model,uretimYili,yakitTuru,kapiSayisi,motorHacmi,kasaTipi,sanzimanTipi,koltukSayisi,ehliyetSinifi,aktifMi,Tutar));
            }
            
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(AracIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
   public boolean Ekle(String plaka,String marka,String model,int uretimYili,String yakitTuru,int kapiSayisi,Float motorHacmi,String kasaTipi,String sanzimanTipi,int koltukSayisi,String ehliyetSinifi,int aktifMi,int Tutar){
        
        String sorgu="insert into araclar(plaka, marka, model, uretimYili, yakitTuru, kapiSayisi, motorHacmi,"
                + " kasaTipi, sanzimanTipi, koltukSayisi, ehliyetSinifi, aktifMi,Tutar) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setString(1, plaka);
            preparableStatement.setString(2, marka);
            preparableStatement.setString(3, model);
            preparableStatement.setInt(4, uretimYili);
            preparableStatement.setString(5, yakitTuru);
            preparableStatement.setInt(6, kapiSayisi);
            preparableStatement.setFloat(7, motorHacmi);
            preparableStatement.setString(8, kasaTipi);
            preparableStatement.setString(9, sanzimanTipi);
            preparableStatement.setInt(10, koltukSayisi);
            preparableStatement.setString(11, ehliyetSinifi);
            preparableStatement.setInt(12, aktifMi);
            preparableStatement.setInt(13, Tutar);
            preparableStatement.executeUpdate();
            
            System.out.println("calılştı");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
   
   public boolean guncelle(String plaka,String marka,String model,int uretimYili,String yakitTuru,int kapiSayisi,Float motorHacmi,String kasaTipi,String sanzimanTipi,int koltukSayisi,String ehliyetSinifi,int aktifMi,int Id,int Tutar){
        
        String sorgu="update araclar set plaka=? , marka=? , model=? "
                + ", uretimYili=? , yakitTuru=? , kapiSayisi=? , motorHacmi=? , kasaTipi=? , sanzimanTipi=?"
                + " , koltukSayisi=? , ehliyetSinifi=? , aktifMi=?, Tutar = ? where aracID = ?";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setString(1, plaka);
            preparableStatement.setString(2, marka);
            preparableStatement.setString(3, model);
            preparableStatement.setInt(4, uretimYili);
            preparableStatement.setString(5, yakitTuru);
            preparableStatement.setInt(6, kapiSayisi);
            preparableStatement.setFloat(7, motorHacmi);
            preparableStatement.setString(8, kasaTipi);
            preparableStatement.setString(9, sanzimanTipi);
            preparableStatement.setInt(10, koltukSayisi);
            preparableStatement.setString(11, ehliyetSinifi);
            preparableStatement.setInt(12, aktifMi);
            preparableStatement.setInt(13, Tutar);
            preparableStatement.setInt(14, Id);
            preparableStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
    }
    
    public boolean sil(int id){
        String sorgu = "delete from araclar where aracID=?";
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
