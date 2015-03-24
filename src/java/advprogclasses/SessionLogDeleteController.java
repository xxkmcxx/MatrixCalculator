/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogclasses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin
 */
public class SessionLogDeleteController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        DataProcessing dataProcess = new DataProcessing(); //Object for issuing queries to the database
        User user = (User)request.getSession().getAttribute("user");
        String s_id = request.getParameter("sessionId");
            dataProcess.deleteSessionById(s_id);
            LogInfo loginfo = (LogInfo) dataProcess.getSessionLogsById(user.getId());
            request.getSession().setAttribute("loginfo", loginfo);
            request.getSession().setAttribute("user",user );
            RequestDispatcher dispatcher = request.getRequestDispatcher("sessionlog.jsp");
            dispatcher.forward(request, response);
       }
    }
