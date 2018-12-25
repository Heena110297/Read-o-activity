/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttospeech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 500040332
 */
public class Dbcon {
    private static final String DBURL ="jdbc:mysql://localhost:3306/entries";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD ="password";
    private static final String DBDRIVER ="com.mysql.jdbc.Driver";
    private static Connection con;
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DBDRIVER);
            try {
               con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            } 
            catch (SQLException ex) {
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
         
            System.out.println("Driver not found."); 
        }
        return con;
    }
    }
    /* For using in other classes
private Connection con = null;
private Statement stmt = null;
private ResultSet rs = null;

con = ConnectionManager.getConnection();
stmt = con.createStatement();
rs = stmt.executeQuery(sql); */

