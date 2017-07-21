package Beans;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean
public class LoginControl {

    private String username;
    private String password;

    // giriş kullanıcı bilgileri
    private static String adi;
    private static String soyadi;
    private static String ID;
    
    ExternalContext git = FacesContext.getCurrentInstance().getExternalContext();

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
    public void login(ActionEvent event) throws SQLException, IOException {
        
        System.out.println("**********LoginControl.java*****************");
         System.out.println(" getUserName "+ getUsername());
         System.out.println(" getPassword "+ getPassword());
          System.out.println("***********************************");
         
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;

     
        DB db = new DB();
        ResultSet rs = db.baglan().executeQuery("select *from admin where kul_adi = '" + username + "' and sifre = '" + password + "' limit 0,1");

        if (rs.next()) { // kullanıcıdan en az 1 tane var

            
            DB.yazuserName = rs.getString("adi");
            DB.yazuserSurName = rs.getString("soyadi");
            DB.yazuserId = rs.getString("id");
            

            loggedIn = true;
            DB.seviye =  rs.getString("seviye");
        
            
           message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hoş Geldiniz ", db.getUserName() + " " + db.getUserSurName());
            if (rs.getString("seviye").equals("0")) {
                try {
                  git.getFlash().setKeepMessages(true);
                  git.getFlash().setRedirect(true);
                  
                 
                 FacesContext.getCurrentInstance().addMessage(null, message);  
                 git.redirect(DB.siteUrl+"yonetici.xhtml");
                 
                      
                } catch (Exception e) {
                    
                     System.out.println("yonetici Giris Hatas" + e);           
                }
            }
             
            if (rs.getString("seviye").equals("1")) {
                try {
            git.getFlash().setKeepMessages(true);
                  git.getFlash().setRedirect(true);
               FacesContext.getCurrentInstance().addMessage(null, message);
                git.redirect(DB.siteUrl+"satinalma.xhtml");
                } catch (Exception e) {
                    
                    System.out.println("satinalma Giris Hatas" + e); 
                }
            }

        }
        
        
        else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hatalı !", "Giriş Başarısız");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

 
        
        context.addCallbackParam("loggedIn", loggedIn);
    }
    
    

     // çıkış yap
    public void cikis(ActionEvent actionEvent) {
        System.out.println("Çıkış Yap");
        try {
            DB.seviye = "";
            git.redirect(DB.siteUrl+"index.xhtml");
        } catch (Exception e) {
        }

    }
    

}