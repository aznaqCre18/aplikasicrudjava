
package com.tutorial;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JOptionPane;

public class Config {
    private static Connection koneksi;

    public Connection connect(){
       //untuk koneksi ke driver

       //untuk koneksi ke database
       try{
           //String url="jdbc:sqlite:db/litedb.om4gus";
           String url="jdbc:sqlite:bingkai1.db";
           koneksi = DriverManager.getConnection(url);
           System.out.println("Berhasil koneksi");
       }catch(SQLException se){
           
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       }
       return koneksi;
    }
}

