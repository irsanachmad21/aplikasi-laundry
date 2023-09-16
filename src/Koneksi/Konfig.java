/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Irsan Achmad
 */
public class Konfig {
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/laundry", "root", "");
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Konfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Konfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
