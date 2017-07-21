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
public class TedarikciListe {

    DB db = new DB();
    private String unvan;

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public TedarikciListe() {
    }

    public List<String> complete(String query) {
        List<String> queries = new ArrayList<String>();
       
        try {

            ResultSet rs = null;
            String myQuery = "select unvan from tedarikciler where unvan like '%"+query+"%'";

            rs = db.baglan().executeQuery(myQuery);
            while (rs.next()) {
                queries.add(rs.getString("unvan"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return queries;
    }

    

   
}
