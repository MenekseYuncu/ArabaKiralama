/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import tablo.Kiralama;

/**
 *
 * @author baior
 */
public class KiralamaIslemleri {
    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement preparableStatement = null;

    public KiralamaIslemleri() {
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
    
    public ArrayList<Kiralama> Listele(){
        
        ArrayList<Kiralama> cikti = new ArrayList<Kiralama>();
        try {
            statement = conn.createStatement();
            String sorgu = "select * from kiralama";
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {                
                int kiralamaID = rs.getInt("kiralamaID");
                int KullID = rs.getInt("kulID");
                int AracID = rs.getInt("aracID");
                Date AlisTarihi = rs.getDate("alisTarih");
                Date VerisTarihi = rs.getDate("teslimTarih");
                int tutar = rs.getInt("tutar");
                int durum = rs.getInt("durum");
                
                cikti.add(new Kiralama(kiralamaID, KullID, AracID, AlisTarihi, VerisTarihi, tutar, durum,"bos","bos"));
            }
            return  cikti;
            
        } catch (SQLException ex) {
            System.out.println("hata : "+ex);
            return null;
        }
        
    }
    
    public ArrayList<Kiralama> Listele(int id){
        
        ArrayList<Kiralama> cikti = new ArrayList<Kiralama>();
        try {
            statement = conn.createStatement();
            String sorgu = "select * from kiralama where kiralamaID="+id;
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {                
                int kiralamaID = rs.getInt("kiralamaID");
                int KullID = rs.getInt("kulID");
                int AracID = rs.getInt("aracID");
                Date AlisTarihi = rs.getDate("alisTarih");
                Date VerisTarihi = rs.getDate("teslimTarih");
                int tutar = rs.getInt("tutar");
                int durum = rs.getInt("durum");
                
                cikti.add(new Kiralama(kiralamaID, KullID, AracID, AlisTarihi, VerisTarihi, tutar, durum,"bos","bos"));
            }
            return  cikti;
            
        } catch (SQLException ex) {
            System.out.println("hata : "+ex);
            return null;
        }
        
    }
    
    public ArrayList<Kiralama> BirlesikListele(){
        
        ArrayList<Kiralama> cikti = new ArrayList<Kiralama>();
        try {
            statement = conn.createStatement();
            String sorgu = "SELECT kiralama.kiralamaID,kiralama.kulID,kiralama.aracID,kiralama.alisTarih,kiralama.teslimTarih,kiralama.tutar,kiralama.durum,kullanici.kulID,kullanici.adi,araclar.aracID,araclar.plaka FROM kiralama INNER JOIN kullanici ON (kiralama.kulID = kullanici.kulID) INNER JOIN araclar ON (kiralama.aracID = araclar.aracID)";
            ResultSet rs = statement.executeQuery(sorgu);
            while (rs.next()) {                
                int kiralamaID = rs.getInt("kiralamaID");
                int KullID = rs.getInt("kulID");
                String KullAdi=rs.getString("adi");
                int AracID = rs.getInt("aracID");
                String plaka=rs.getString("plaka");
                Date AlisTarihi = rs.getDate("alisTarih");
                Date VerisTarihi = rs.getDate("teslimTarih");
                int tutar = rs.getInt("tutar");
                int durum = rs.getInt("durum");
                
                cikti.add(new Kiralama(kiralamaID, KullID, AracID, AlisTarihi, VerisTarihi, tutar, durum,KullAdi,plaka));
            }
            return  cikti;
            
        } catch (SQLException ex) {
            System.out.println("hata : "+ex);
            return null;
        }
        
    }
    
    
    public boolean Ekle(int KullID, int AracID,int tutar,int durum,Date AlisTarih,Date VerisTarih){
        
        String sorgu="insert into kiralama(kulID ,AracID,tutar,durum,alisTarih,teslimTarih) values(?,?,?,?,?,?)";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setInt(1, KullID);
            preparableStatement.setInt(2, AracID);
            preparableStatement.setInt(3, tutar);
            preparableStatement.setInt(4, durum);
            preparableStatement.setDate(5, (java.sql.Date) AlisTarih);
            preparableStatement.setDate(6, (java.sql.Date) VerisTarih);
            preparableStatement.executeUpdate();
            
            System.out.println("calılştı");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean guncelle(int KullID, int AracID,int tutar,int durum,int kiralamaID){
        
        String sorgu="update kiralama set KullID=? "
                + ", AracID=? , tutar=? , durum=? where kiralamaID = ?";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setInt(1, KullID);
            preparableStatement.setInt(2, AracID);
            preparableStatement.setInt(3, tutar);
            preparableStatement.setInt(4, durum);
            preparableStatement.setInt(4, kiralamaID);
            //preparableStatement.setDate(6, (java.sql.Date) toDate);
            //preparableStatement.setDate(7, (java.sql.Date) fromDate);
            preparableStatement.executeUpdate();
            
            System.out.println("calıştı");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }        
    }
    public boolean guncelle(int durum,int kiralamaID){
        
        String sorgu="update kiralama set durum=? where kiralamaID = ?";
        try {
            preparableStatement = conn.prepareStatement(sorgu);
            preparableStatement.setInt(1, durum);
            preparableStatement.setInt(2, kiralamaID);
            preparableStatement.executeUpdate();
            
            System.out.println("calıştı");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }        
    }
    
    public boolean sil(int id){
        String sorgu = "delete from kiralama where kiralamaID=?";
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
