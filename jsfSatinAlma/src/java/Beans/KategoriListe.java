/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
 
@ManagedBean(name = "category")
@SessionScoped
public class KategoriListe implements Serializable {
 
    DB db = new DB();
    private static final long serialVersionUID = 1L;
    private String catname, subcatname, id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    public String getCatname() {
        return catname;
    }
 
    public void setCatname(String catname) {
        this.catname = catname;
    }
 
    public String getSubcatname() {
        return subcatname;
    }
 
    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }
 
    public List<SelectItem> getCategoryName() {
        List<SelectItem> cat = new ArrayList<SelectItem>();
        try {
            
            ResultSet rs = null;
            String myQuery = "select adi,kategori_id from kategori";
 
            rs = db.baglan().executeQuery(myQuery);
            while (rs.next()) {
                cat.add(new SelectItem(rs.getString("kategori_id"), rs.getString("adi")));
               
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return cat;
    }
 
    
 
}