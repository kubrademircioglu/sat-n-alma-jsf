
package Beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;



@ManagedBean()
public class YoneticiListe {


    // çıkış yap
    ExternalContext git = FacesContext.getCurrentInstance().getExternalContext();
    DB db = new DB();

    //Satın alma Form Listeleme

    public List<SatinAlmaListe> listele() throws Exception {

        if (DB.seviye.equals("0")) {

        } else {
            try {
                DB.seviye = "";
                git.redirect(DB.siteUrl + "index.xhtml");
            } catch (Exception e) {
            }
        }

        List<SatinAlmaListe> liste = new ArrayList<>();

        try {
            ResultSet rs = db.baglan().executeQuery("SELECT * from satinalmaform AS satin LEFT JOIN  kategori as kat on  kat.kategori_id = satin.kategori_id WHERE satin.durum='0'  order by satin.durum asc");

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
                obj.setInsertUserName(rs.getString("insert_User"));
                obj.setInsert_UserSurName(rs.getString("insert_UserSurname"));

                liste.add(obj);

            }

        } catch (Exception e) {

            System.err.println("Yönetici Bilgi Hatası : " + e);

        } finally {

            db.closeConnection();
            System.out.println("DB KAPATILDI!");

        }
        return liste;
    }

    public List<SatinAlmaListe> onaylanan_Liste() throws Exception {

        if (DB.seviye.equals("0")) {

        } else {
            try {
                DB.seviye = "";
                git.redirect(DB.siteUrl + "index.xhtml");
            } catch (Exception e) {
            }
        }

        List<SatinAlmaListe> Onay_liste = new ArrayList<>();

        try {
            ResultSet rs = db.baglan().executeQuery("SELECT * from satinalmaform AS satin LEFT JOIN  kategori as kat on  kat.kategori_id = satin.kategori_id WHERE satin.durum='2'  order by satin.durum asc");

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
                obj.setInsertUserName(rs.getString("insert_User"));
                obj.setInsert_UserSurName(rs.getString("insert_UserSurname"));

                Onay_liste.add(obj);

            }

        } catch (Exception e) {

            System.err.println("Yönetici Bilgi Hatası : " + e);

        } finally {

            db.closeConnection();
            System.out.println("DB KAPATILDI!");

        }
        return Onay_liste;
    }

    public List<SatinAlmaListe> iptal_Liste() throws Exception {

        if (DB.seviye.equals("0")) {

        } else {
            try {
                DB.seviye = "";
                git.redirect(DB.siteUrl + "index.xhtml");
            } catch (Exception e) {
            }
        }

        List<SatinAlmaListe> iptal_liste = new ArrayList<>();

        try {
            ResultSet rs = db.baglan().executeQuery("SELECT * from satinalmaform AS satin LEFT JOIN  kategori as kat on  kat.kategori_id = satin.kategori_id WHERE satin.durum='5'  order by satin.durum asc");

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
                obj.setInsertUserName(rs.getString("insert_User"));
                obj.setInsert_UserSurName(rs.getString("insert_UserSurname"));

                iptal_liste.add(obj);

            }

        } catch (Exception e) {

            System.err.println("Yönetici Bilgi Hatası : " + e);

        } finally {

            db.closeConnection();
            System.out.println("DB KAPATILDI!");

        }
        return iptal_liste;
    }

    //0 ise okunmadı, 1 ise okudu, 2 ise okundu onaylandı, 3 ise okundu red alındı,5 ise iptal edildi.
    public void talepIptalEt(String id,String sebeb) throws SQLException {
        int geriDurum = db.baglan().executeUpdate("update satinalmaform set durum = '5', aciklama = '"+sebeb+"' where id = '" + id + "'");

    }

    public void talepOnayla(String id,String sebeb) throws SQLException {
        //System.out.println("GELEN ID:"+id);
         int geriDurum = db.baglan().executeUpdate("update satinalmaform set durum = '2', aciklama = '"+sebeb+"' where id = '" + id + "'"); 
         
    }
    
    

    public void infoOnay() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Talep Onay", "Satın Alma Talebi Onaylandı!"));
    }

    public void infoIptal() {
        System.out.println("Onay Çalıştı");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Talep İptal", "Satın Alma Talebi İptal Edildi!"));
    }


    private String talepAciklama = "";

    public String getTalepAciklama() {
        return talepAciklama;
    }

    public void setTalepAciklama(String talepAciklama) {
        this.talepAciklama = talepAciklama;
    }



  }
