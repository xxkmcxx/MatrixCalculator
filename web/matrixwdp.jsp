<%-- 
    Document   : matrixwdp
    Created on : Feb 1, 2015, 10:30:28 PM
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="advprogclasses.Matrix" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssf.css">
        <script src="scriptF.js"></script> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Matrix 1</h1>
        
        <jsp:useBean id="mInfo" class="advprogclasses.Matrix" scope="application"></jsp:useBean>
    
       
        <form name="resultForm" method="post" action="ResultController" onsubmit="return validateMatrix2()">
             <table>
        <c:forEach begin ="1" end="${mInfo.rows1}" varStatus="loop1">
            <tr>
            <c:forEach begin="1" end="${mInfo.cols1}" varStatus="loop2">
                <td><input type="text" name="cell${loop1.index}${loop2.index}" size="5" value="0"></td>
            </c:forEach>
            </tr>
        </c:forEach>
         </table>
           
         
    <h1>Matrix 2</h1>
           
       <table>
            <c:forEach begin ="1" end="${mInfo.rows2}" varStatus="loop1">
            <tr>
            <c:forEach begin="1" end="${mInfo.cols2}" varStatus="loop2">
                <td><input type="text" name="cell2${loop1.index}${loop2.index}" size ="5" value="0"></td>
            </c:forEach>
            </tr>
        </c:forEach>
            </table>
            Matrix1 row:<input type="text" name="dprow" size ="5"><br>
            Matrix2 column:<input type="text" name="dpcol" size ="5">
            <br><input type="submit" value="Get Results!">
        </form>
        <button onclick="return dpRandomFill(this)">Random Numbers</button>
        <a method="get" href="MatrixInfoController">My Account</a> <a href="loginpage.jsp">Log Out</a>
   
    </body>
</html>
