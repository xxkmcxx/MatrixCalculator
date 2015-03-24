/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advprogclasses;
import java.io.IOException;
import  java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kevin
 */
public class DataProcessing {
    
    public void addSessionInfo(User user, Matrix mInfo) //THIS METHOD ADDS A LOG SESSION TO THE DATABAES REFERENCING THE CURRENT USER
    {
        ResultHtml rHtml = new ResultHtml();
      
        try {
            String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
            String dbuser ="system";
            String pass ="masterYoda02";
            
            
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, dbuser, pass);
            Statement myStm= con.createStatement();
            String query = "Insert into ADVPROG.SESSIONS VALUES ('"+user.getId()+"',ADVPROG.seq_sessions.nextVal)";
            String query2 = "Insert into ADVPROG.OPERATIONS VALUES (ADVPROG.seq_sessions.currVal,'"+mInfo.getOperation()+"')";
            String query3 = "Insert into ADVPROG.FILEPATH VALUES (ADVPROG.seq_sessions.currVal,'"+rHtml.getFilepath()+"')";
            myStm.executeUpdate(query);
            myStm.executeUpdate(query2);
            myStm.executeUpdate(query3);
            myStm.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User getSessionInfoById(String id) //THIS METHOD GETS INFORMATION ABOUT LOGGED USER
    {
        User user = new User();
        try {
            
            String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
            String dbuser ="system";
            String pass ="masterYoda02";
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, dbuser, pass);
            Statement myStm= con.createStatement();
            String query = "Select U.u_id,U.fname,U.lname,UI.email,UI.phonennumber,UI.address, UI.City,AC.USERNAME from ADVPROG.USERS U,ADVPROG.USER_INFO UI, ADVPROG.ACCESS_CONTROL AC " +
                    "where U.u_id = UI.u_id and U.u_id = AC.u_id and u.u_id= '"+id+"'";
            ResultSet rs = myStm.executeQuery(query);
            while(rs.next())
            {
                user.setId(rs.getString("u_id"));
                user.setUserId(rs.getString("username"));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setPhoneNumber(rs.getString("phonennumber"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setCity(rs.getString("city"));
                
            }
            myStm.close();
            con.close();
            rs.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public LogInfo getSessionLogsById(String id) // THIS METHODS RETRIVE ALL THE SESSIONS FROM LOGGED USER
    {
        LogInfo loginfo= new LogInfo();
        int fileCount= 1;
        String[] filepaths = new String[fileCount];
        String[] sessionIds = new String[fileCount];
        try {
            
            String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
            String dbuser ="system";
            String pass ="masterYoda02";
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, dbuser, pass);
            Statement myStm= con.createStatement();
            String query2 = "Select s.s_id,o.s_operation,f.f_path from  ADVPROG.Sessions s, ADVPROG.operations o, ADVPROG.filepath f " +
                            "where s.s_id = o.s_id and s.s_id = f.s_id and s.u_id= '"+id+"' ORDER BY f.f_path";
            String query1 = "Select COUNT(f.f_path) as fcount from  ADVPROG.Sessions s, ADVPROG.operations o, ADVPROG.filepath f " +
                            "where s.s_id = o.s_id and s.s_id = f.s_id and s.u_id= '"+id+"'";
            ResultSet rs = myStm.executeQuery(query1);
            while(rs.next())
            {
                fileCount = rs.getInt(1);
                
            }
            filepaths = new String[fileCount];
            sessionIds = new String[fileCount];
            rs = myStm.executeQuery(query2);
            for(int i = 0; rs.next();i++)
            {
                filepaths[i] = rs.getString("f_path");
                sessionIds[i] = rs.getString("s_id");
            }
            myStm.close();
            con.close();
            rs.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        loginfo.setFilepath(filepaths);
        loginfo.setSessionIds(sessionIds);
        return loginfo;
    }
    
    public LogInfo getSessionLogsByOperation(String id,String operation) // THIS METHODS RETRIVE ALL THE SESSIONS FROM SPECIFIC OPERATION REQUESTED BY USER
    {
        LogInfo loginfo = new LogInfo();
        int fileCount= 1;
        String[] filepaths = new String[fileCount];
        String[] sessionIds = new String[fileCount];
        try {
            
            String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
            String dbuser ="system";
            String pass ="masterYoda02";
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, dbuser, pass);
            Statement myStm= con.createStatement();
            String query2 = "Select s.s_id,o.s_operation,f.f_path from  ADVPROG.Sessions s, ADVPROG.operations o, ADVPROG.filepath f " +
                            "where s.s_id = o.s_id and s.s_id = f.s_id and s.u_id= '"+id+"'and o.s_operation = '"+operation+"' ORDER BY f.f_path";
            String query1 = "Select COUNT(f.f_path) as fcount from  ADVPROG.Sessions s, ADVPROG.operations o, ADVPROG.filepath f " +
                            "where s.s_id = o.s_id and s.s_id = f.s_id and s.u_id= '"+id+"' and o.s_operation = '"+operation+"'";
            ResultSet rs = myStm.executeQuery(query1);
            while(rs.next())
            {
                fileCount = rs.getInt(1);
                
            }
            filepaths = new String[fileCount];
            sessionIds = new String[fileCount];
            rs = myStm.executeQuery(query2);
            for(int i = 0; rs.next();i++)
            {
                filepaths[i] = rs.getString("f_path");
                sessionIds[i] = rs.getString("s_id");
            }
            myStm.close();
            con.close();
            rs.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        loginfo.setFilepath(filepaths);
        loginfo.setSessionIds(sessionIds);
        return loginfo;
    }
    
    public  void deleteSessionById(String s_id)
    {
        try {
            String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
            String dbuser ="system";
            String pass ="masterYoda02";
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, dbuser, pass);
            Statement myStm= con.createStatement();
            String query = "DELETE FROM ADVPROG.SESSIONS WHERE s_id = '"+s_id+"'";
            myStm.executeUpdate(query);
            myStm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void deleteUserById(String s_id)
    {
        try {
            String dbUrl ="jdbc:oracle:thin:@localhost:1521:XE";
            String dbuser ="system";
            String pass ="masterYoda02";
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, dbuser, pass);
            Statement myStm= con.createStatement();
            String query = "DELETE FROM ADVPROG.USERS WHERE s_id = '"+s_id+"'";
            myStm.executeUpdate(query);
            myStm.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    
    
    
