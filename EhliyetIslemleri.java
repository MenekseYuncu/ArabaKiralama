
package Islemler;

import arackiralama.Baglanti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tablo.Ehliyetler;

/**
 *
 * @author baior
 */
public class EhliyetIslemleri {
    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparableStatement = null;

    public EhliyetIslemleri() {
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
    
    public ArrayList<Ehliyetler> Listele(){
        
        ArrayList<Ehliyetler> cikti = new ArrayList<Ehliyetler>();
        try {
            statement = conn.createStatement();
            String sorgu = "select * from ehliyetler";
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {                
                int id = rs.getInt("kulID");
                String adi = rs.getString("ehliyetTuru");
                
                cikti.add(new Ehliyetler(id, adi));
            }
            return  cikti;
            
        } catch (SQLException ex) {
            System.out.println("hata : "+ex);
            return null;
        }
        
       
    }
    
    
    public boolean Ekle(String ehliyetTuru,int kullID){
        
        String sorgu="insert into ehliyetler(ehliyetTuru) values(?)";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setString(1, ehliyetTuru);
            preparableStatement.executeUpdate();
            
            System.out.println("calılştı");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean guncelle(String ehliyetTuru,int kullID){
        
        String sorgu="update kullanici set ehliyetTuru=? where kulID = ?";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setString(1, ehliyetTuru);
            preparableStatement.setInt(2, kullID);
            preparableStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
    }
    
    public boolean sil(int id){
        String sorgu = "delete from ehliyetler where kulID=?";
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
