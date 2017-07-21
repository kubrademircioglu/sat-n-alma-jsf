package Beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
public class SatinAlmaMenuView {

    // çıkış yap
    ExternalContext git = FacesContext.getCurrentInstance().getExternalContext();
    DB db = new DB(); 
    //Satın alma Form Listeleme
    public List<SatinAlmaListe> listele() throws Exception {

    if(DB.seviye.equals("1")){
       
    }else {
        try {
                DB.seviye = "";
                git.redirect(DB.siteUrl+"index.xhtml");
            } catch (Exception e) {
            } 
    }    
    
       
    List<SatinAlmaListe> liste = new ArrayList<>();
                
          try {
            ResultSet rs = db.baglan().executeQuery("SELECT * from satinalmaform AS satin LEFT JOIN  kategori as kat on  kat.kategori_id = satin.kategori_id WHERE   satin.durum in ('0','2') order by satin.durum asc");
       
            
            while (rs.next()) {
                SatinAlmaListe obj = new SatinAlmaListe();
                
                System.out.println("BASARILI !!!!!");
                obj.setSatinAlmaId(rs.getString("satin.id"));
                obj.setKategori_id(rs.getInt("kat.kategori_id"));
                obj.setKategori_adi(rs.getString("kat.adi"));
                obj.setTedarikci_adi(rs.getString("satin.tedarikci_adi"));
                obj.setUrun_adi(rs.getString("urun_adi"));
                obj.setBirimFiyat(rs.getFloat("birimFiyat"));
                obj.setAdet(rs.getInt("adet"));
                obj.setKdv(rs.getInt("kdv"));
                obj.setToplamTutar(rs.getFloat("toplamTutar"));
                obj.setGenelToplam(rs.getFloat("genelToplam"));
                obj.setAdminID(rs.getInt("adminID"));
                obj.setDurum(rs.getInt("durum"));
                obj.setTarih(rs.getString("tarih"));

                liste.add(obj);

            }

        } catch (Exception e) {

            System.err.println("SatınAlma Bilgi Hatası : " + e);

        }
finally{
        
        db.closeConnection();
              System.out.println("DB KAPATILDI!");
        
          }
        return liste;
    }
    
    public void info() {
      SatinAlmaListe st = new SatinAlmaListe();
       FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Talep İptal", "Satın Alma Talebiniz İptal Edildi!"));
    }
    
  
    
    
    public void talepGeriAl(String id) throws SQLException {
        int geriDurum = db.baglan().executeUpdate("update satinalmaform set durum = '6' where id = '"+id+"'");
        
           }

}
