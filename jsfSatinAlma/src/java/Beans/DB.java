/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class DB {

    // db Değişkenleri
    String url = "jdbc:mysql://localhost:3306/";
    String forname = "com.mysql.jdbc.Driver";
    String dbName = "satinalma?characterEncoding=utf8";
    String dbUName = "root";
    String dbUPass = "112233";

    public static String siteUrl = "http://localhost:8080/jsfSatinAlma/faces/";
    public static String seviye = "";
    private String userName = "";
    private String userSurName = "";
    private String userId = "";

    public static String yazuserName = "";
    public static String yazuserSurName = "";
    public static String yazuserId = "";

    public String getUserName() {
        return this.yazuserName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurName() {
        return this.yazuserSurName;
    }

    public void setUserSurName(String userSurName) {
        this.userSurName = userSurName;
    }

    public String getUserId() {
        return this.yazuserId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Bağlantı değişkenleri
    Connection conn = null;
    Statement st = null;

    public Statement baglan() throws SQLException {

        System.out.println("********* DB INFORMATION ************");
        System.out.println(" url " + url);
        System.out.println(" dbName " + dbName);
        System.out.println(" dbUName " + dbUName);
        System.out.println(" dbUPass " + dbUPass);
        System.out.println("*************************");

        try {
            // kütüphane hazır konuma getiriliyor
            Class.forName(forname);
            conn = DriverManager.getConnection(url + dbName, dbUName, dbUPass);
            st = conn.createStatement();
        } catch (Exception e) {
            System.err.println("Mysql Bağlantı Hatası : " + e);
        }
        return st;
    }

    public void closeConnection() throws Exception {
        conn.close();
    }

}
