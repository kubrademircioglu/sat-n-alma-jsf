/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class UrunListe {

    DB db = new DB();
    private String urunAdi;

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public UrunListe() {
    }

    public List<String> complete(String query) {
        List<String> queries = new ArrayList<String>();
       
        try {

            ResultSet rs = null;
            String myQuery = "select urunAdi from urunler where urunAdi like '%"+query+"%'";

            rs = db.baglan().executeQuery(myQuery);
            while (rs.next()) {
                queries.add(rs.getString("urunAdi"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return queries;
    }

    

   
}
