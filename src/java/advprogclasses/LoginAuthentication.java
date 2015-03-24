/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogclasses;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class LoginAuthentication {
    
    public boolean authenticate(String userId, String password)
    {
        if((password != null && !"".equals(password.trim()))&&( userId != null && !"".equals(userId.trim())))
        {
            String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
            String user ="system";
            String pass ="masterYoda02";
            String username ="";
            String userpass ="";
            
            try{
                Class.forName("oracle.jdbc.OracleDriver");       
                Connection con = DriverManager.getConnection(dbUrl, user, pass);
                Statement myStm= con.createStatement();
                String query = "Select * from ADVPROG.ACCESS_CONTROL WHERE USERNAME = '"+userId+"'";
                ResultSet rs = myStm.executeQuery(query);
                while(rs.next())
                {
                    
                   
                    username = rs.getString("username");
                    userpass = rs.getString("password");
                                 
                }
                myStm.close();
                con.close();
                rs.close();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegistrationProcess.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationProcess.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return userId.equals(username) && password.equals(userpass);
            
        }
        else
        {
            return false;
        }
    }
    
    public String getUserId(String username)
    {
        String u_id ="";
        try {
            String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
            String user ="system";
            String pass ="masterYoda02";
            
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, user, pass);
            Statement myStm= con.createStatement();
            String query = "Select u_id from ADVPROG.ACCESS_CONTROL WHERE USERNAME = '"+username+"'";
            ResultSet rs = myStm.executeQuery(query);
            while(rs.next())
            {
                u_id = rs.getString("u_id");
            }
            myStm.close();
            con.close();
            rs.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u_id;
    }
     
    
    
    
    
}
