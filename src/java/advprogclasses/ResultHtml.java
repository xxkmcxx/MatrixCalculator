/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogclasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
/**
 *
 * @author Kevin
 */
public class ResultHtml {
    private String content;
    private int sessions;
    
   public void setContent(String content)
   {
       this.content = content;
   }
   
   public String getContent()
   {
       return this.content;
   }
   
   public int getSessions()
   {
      return this.sessions;
   }
   
   public void toHtml() throws UnsupportedEncodingException, FileNotFoundException, IOException
   {
       addSession();
       String numSessions = numOfSessions();
       File file = new File("C:\\Users\\Kevin\\Documents\\NetBeansProjects\\AdvProy\\web\\Sessions\\Session"+numSessions+".jsp");
       if (!file.exists()) 
       {
          file.createNewFile();
       }
       FileWriter fw = new FileWriter(file.getAbsoluteFile());
       BufferedWriter bw = new BufferedWriter(fw);
       bw.write("<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>\n<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>\n<html>\n" +
"      <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"../cssf.css\">\n" +
"        <title>JSP Page</title>\n" +
"        </head>\n" +
"        <body>\n" +
"        <jsp:useBean id=\"reMtx\" class=\"advprogclasses.Matrix\" scope=\"session\"></jsp:useBean>\n" +
"        <h1>Result</h1>\n");
      bw.write(content);
      bw.write(" </body>\n" +
                         "</html>");
      bw.close();
   }
   public String numOfSessions() throws IOException
   {
       
       File file = new File("C:\\Users\\Kevin\\Documents\\NetBeansProjects\\AdvProy\\web\\Sessions\\Sessions.txt");
       
       if(!file.exists())
       {
           file.createNewFile();
       }
       FileReader fR = new FileReader(file);
       BufferedReader bufferedReader = new BufferedReader(fR);
       StringBuilder numSession = new StringBuilder();
	String line;
	while ((line = bufferedReader.readLine()) != null) {
	    numSession.append(line);
	}
	fR.close();
        return numSession.toString();
   }
   
   private void addSession() throws IOException
   {
       
       File file = new File("C:\\Users\\Kevin\\Documents\\NetBeansProjects\\AdvProy\\web\\Sessions\\Sessions.txt");
       
       if(!file.exists())
       {
          file.createNewFile();
          FileWriter fw = new FileWriter(file.getAbsoluteFile());
          BufferedWriter bw = new BufferedWriter(fw);
          bw.write("1");
          bw.close();
       }
       else if(new BufferedReader(new FileReader(file)).readLine()==null)
       {
           FileWriter fw = new FileWriter(file.getAbsoluteFile());
           BufferedWriter bw = new BufferedWriter(fw);
           bw.write("1");
           bw.close();
       }
       else
       {
          int numSession = 0;
          Scanner sc = new Scanner(file);
          while(sc.hasNextLine())
          {
               numSession = sc.nextInt(); 
          }
          numSession++;
          FileWriter fw = new FileWriter(file.getAbsoluteFile());
          BufferedWriter bw = new BufferedWriter(fw);
          bw.write(Integer.toString(numSession));
          bw.close();
          
       }
       
   }
   
   public String getFilepath() throws IOException
   {
     return "Sessions/Session"+numOfSessions()+".jsp";
   }
   public String opToHtml(double matrix[][],String operation)
   {
       int row = matrix.length;
       int col = matrix[0].length;
       String text;
        text = "The result from the " + operation + " is the following:\n<table>\n";
       for(int i = 0; i < row;i++)
       {
           text += "<tr>\n";
           for(int j = 0; j < col; j++)
           {
               text += "<td>"+Double.toString(matrix[i][j])+"</td>";
           }
           text += "</tr>";
       }
       text += "</table>";
       
       return text;
   }
   public String mtrToHtml(double matrix[][])
   {
       int row = matrix.length;
       int col = matrix[0].length;
       String text;
        text = "<table>\n";
       for(int i = 0; i < row;i++)
       {
           text += "<tr>\n";
           for(int j = 0; j < col; j++)
           {
               text += "<td>"+Double.toString(matrix[i][j])+"</td>";
           }
           text += "</tr>";
       }
       text += "</table><br><br>";
       
       return text;
   }
   
   public String dpToHtml(double dpResult,String operation,int row,int col)
   {
       
       String text = "The result from the " + operation + " whith row:"+ Integer.toString(row)+" and"
               + " col: "+Integer.toString(col)+" is the following:<br>" + Double.toString(dpResult);
      return text;
   }
}

