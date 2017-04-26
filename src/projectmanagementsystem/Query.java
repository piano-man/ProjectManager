/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import static projectmanagementsystem.Connection.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author chaitanya
 */
public class Query {
    
    public static ResultSet getSelectResult(String query,java.sql.Connection con) throws ClassNotFoundException, SQLException{
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query);
         return rs;
    }
    
    
    public static void displayMessage(String message, String heading){
         JOptionPane.showMessageDialog(null, message, heading, JOptionPane.INFORMATION_MESSAGE);
    }
    
}
