/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogclasses;

/**
 *
 * @author Kevin
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class RegistrationProcess {
    
   
    public boolean addToDB(String fname,String lname, String username,String password,String email, String phone, String address,String city)
    {
        String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
        String user ="system";
        String pass ="masterYoda02";
        
        try{
          Class.forName("oracle.jdbc.OracleDriver");       
          Connection con = DriverManager.getConnection(dbUrl, user, pass);
          Statement myStm= con.createStatement();
            
          String query1 = "Insert Into ADVPROG.USERS VALUES (ADVPROG.seq_users.nextval,'"+fname+"','"+lname+"')";
          String query2 = "Insert Into ADVPROG.USER_INFO VALUES (ADVPROG.seq_users.currval,'"+email+"','"+phone+"','"+address+"','"+city+"')";
          String query3 = "Insert Into ADVPROG.ACCESS_CONTROL VALUES (ADVPROG.seq_users.currval,'"+username+"','"+password+"')";
          myStm.executeUpdate(query1);
          myStm.executeUpdate(query2);
          myStm.executeUpdate(query3);
          myStm.close();
          con.close();
        
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    
}

}