
package Beans;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "satinAlma")
public class SatinAlmaListe {
    
    private int kategori_id;
    private String satinAlmaId;
    private String kategori_adi = "";
    private String tedarikci_adi="";
    private String urun_adi="";
    private Float birimFiyat;
    private int adet;
    private int kdv;
    private Float toplamTutar;
    private Float genelToplam;
    private int adminID;
    private int durum;
    private String tarih;
    private String insertUserName;
    private String insert_UserSurName;
    private  String talepAciklama;

    public String getTalepAciklama() {
        return talepAciklama;
    }

    public  void  setTalepAciklama(String talepAciklama) {
        
        System.out.println("setTalepAciklama: "+talepAciklama);
        this.talepAciklama = talepAciklama;
    }
    

    public String getInsert_UserSurName() {
        return insert_UserSurName;
    }

    public void setInsert_UserSurName(String insert_UserSurName) {
        this.insert_UserSurName = insert_UserSurName;
    }
    
    public String getInsertUserName() {
        return insertUserName;
    }

    public void setInsertUserName(String insertUserName) {
        this.insertUserName = insertUserName;
    }

    public String getSatinAlmaId() {
        return satinAlmaId;
    }

    public void setSatinAlmaId(String satinAlmaId) {
        this.satinAlmaId = satinAlmaId;
    }

    
    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }
    
    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getTedarikci_adi() {
        return tedarikci_adi;
    }

    public void setTedarikci_adi(String tedarikci_adi) {
        this.tedarikci_adi = tedarikci_adi;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public Float getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(Float birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getKdv() {
        return kdv;
    }

    public void setKdv(int kdv) {
        this.kdv = kdv;
    }

    public Float getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(Float toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public Float getGenelToplam() {
        return genelToplam;
    }

    public void setGenelToplam(Float genelToplam) {
        this.genelToplam = genelToplam;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getDurum() {
        return durum;
    }

    public void setDurum(int durum) {
        this.durum = durum;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
    
    
    
    
}
