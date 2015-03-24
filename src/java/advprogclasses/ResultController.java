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
public class ResultController extends HttpServlet {

  

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
            Matrix beanMatrix = (Matrix)request.getSession().getAttribute("mInfo");//gets info from java bean
            MatrixCalculator matrix = new MatrixCalculator();
            ResultHtml rHtml = new ResultHtml();
            int row = beanMatrix.getRows1();
            int col = beanMatrix.getCols1();
            matrix.setMatrixA(row, col);
            User user = (User)request.getSession().getAttribute("user");   
            DataProcessing dataProcess = new DataProcessing();
            for(int i =1;i <= row;i++)
            {
                for(int j = 1;j<=col;j++)
                {  
                    double value = Double.parseDouble(request.getParameter("cell" +Integer.toString(i)+Integer.toString(j)));
                    matrix.addValuesMatrixA(i-1, j-1,value);
                }
            }
            
            row = beanMatrix.getRows2();
            col = beanMatrix.getCols2();
            matrix.setMatrixB(row,col);
           
            
            for(int i =1;i <= row;i++)
            {
                for(int j = 1;j<=col;j++)
                {  
                    double value = Double.parseDouble(request.getParameter("cell2" +Integer.toString(i)+Integer.toString(j)));
                    matrix.addValuesMatrixB(i-1, j-1,value);
                }
            }
            beanMatrix.setMatrix1(matrix.getMatrixA());
            beanMatrix.setMatrix2(matrix.getMatrixB());
            String content = "Matrix 1\n\n" +rHtml.mtrToHtml(beanMatrix.getMatrix1());
            content += "Matrix 2\n\n" + rHtml.mtrToHtml(beanMatrix.getMatrix2());
            
            String operation = beanMatrix.getOperation();
            if(operation.equals("sum"))
            { 
                //beanMatrix.setResultMatrix(matrix.sumMatrix());
                JniSum jnisum = new JniSum();//JNI CLASS TO CALCULATE THE SUM OF MATRICES
                beanMatrix.setResultMatrix(jnisum.calculateSum(beanMatrix.getMatrix1(), beanMatrix.getMatrix2()));
                content += rHtml.opToHtml(beanMatrix.getResultMatrix(),beanMatrix.getOperation());
            }
            else if(operation.equals("substraction"))
            {
                beanMatrix.setResultMatrix(matrix.subsMatrix());
                content += rHtml.opToHtml(beanMatrix.getResultMatrix(),beanMatrix.getOperation());;
            }
            else if(operation.equals("multiplication"))
            {
                beanMatrix.setResultMatrix(matrix.prodMatrix());
                content += rHtml.opToHtml(beanMatrix.getResultMatrix(),beanMatrix.getOperation());
            }
            else
            {
                int dprow = Integer.parseInt(request.getParameter("dprow"));
                int dpcol =Integer.parseInt(request.getParameter("dpcol"));
                             
                if(dpcol-1 < beanMatrix.getCols2() && dprow-1 < beanMatrix.getRows1())
                {
                    beanMatrix.setDp(matrix.dpresult(dprow-1,dpcol-1));
                    content+= rHtml.dpToHtml(beanMatrix.getDp(), beanMatrix.getOperation(),row, col);
                }
                else
                {
                    request.getSession().setAttribute("reMtx", beanMatrix);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("matrixwdperr.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
            rHtml.setContent(content);
            rHtml.toHtml();// creates a new jsp file that contains result information
            dataProcess.addSessionInfo(user, beanMatrix);//inserts u_id and s_id into sessions table, it also populates operation and filepth tables
            request.getSession().setAttribute("reMtx", beanMatrix);
            RequestDispatcher dispatcher = request.getRequestDispatcher("mresults.jsp");
            dispatcher.forward(request, response);
   
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

