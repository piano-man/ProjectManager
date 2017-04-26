/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chaitanya
 */
public class Connection {
    
    public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/HotelReservationSystem","root","bubu");
        return con;
    }
      
}
