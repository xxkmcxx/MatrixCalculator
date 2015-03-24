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
public class LoginController extends HttpServlet {

    

     /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LogInfo loginfo = new LogInfo();
    User user = (User)request.getSession().getAttribute("user");
    DataProcessing dataProcess = new DataProcessing();
    String id = user.getId();
    user = dataProcess.getSessionInfoById(id);
    ResultHtml rHtml = new ResultHtml();
    loginfo.setNumSessions(rHtml.numOfSessions());
    request.getSession().setAttribute("loginfo", loginfo);
    request.getSession().setAttribute("user",user );
    RequestDispatcher dispatcher = request.getRequestDispatcher("sessionlog.jsp");
    dispatcher.forward(request, response);
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("userId");
        String password = request.getParameter("password");
        LoginAuthentication loginServ = new LoginAuthentication();
        if(loginServ.authenticate(username,password))
        {
               User user = new User();
               user.setUserId(username);
               user.setId(loginServ.getUserId(username));
               request.getSession().setAttribute("user", user);
               RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
               dispatcher.forward(request, response);
        }
        else
        {
            response.sendRedirect("loginerr.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
