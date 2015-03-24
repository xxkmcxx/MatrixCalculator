/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogclasses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Kevin
 */
@WebServlet("/MatrixInforController")
public class MatrixInfoController extends HttpServlet {

      

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LogInfo loginfo = new LogInfo();
    User user = (User)request.getSession().getAttribute("user");
    DataProcessing dataProcess = new DataProcessing();
    String id = user.getId();
    user = dataProcess.getSessionInfoById(id);
    ResultHtml rHtml = new ResultHtml();
    loginfo = (LogInfo)dataProcess.getSessionLogsById(id);
    request.getSession().setAttribute("loginfo", loginfo);
    request.getSession().setAttribute("user",user );
    RequestDispatcher dispatcher = request.getRequestDispatcher("sessionlog.jsp");
    dispatcher.forward(request, response);
}
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            Matrix mInfo = new Matrix();
            mInfo.setRows1(Integer.parseInt(request.getParameter("rows1")));
            mInfo.setCols1(Integer.parseInt(request.getParameter("cols1")));
            mInfo.setRows2(Integer.parseInt(request.getParameter("row2")));
            mInfo.setCols2(Integer.parseInt(request.getParameter("col2")));
            mInfo.setOperation(request.getParameter("operation"));
            if(mInfo.getOperation().equals("dot product")){
               request.getSession().setAttribute("mInfo", mInfo);
               RequestDispatcher dispatcher = request.getRequestDispatcher("matrixwdp.jsp");
               dispatcher.forward(request, response); 
            }
            else
            {
               request.getSession().setAttribute("mInfo", mInfo);
               RequestDispatcher dispatcher = request.getRequestDispatcher("matrixpage.jsp");
               dispatcher.forward(request, response); 
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
