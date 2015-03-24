<%-- 
    Document   : mresults
    Created on : Jan 28, 2015, 11:36:57 AM
    Author     : Kevin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8" import="advprogclasses.Matrix"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssf.css">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="reMtx" class="advprogclasses.Matrix" scope="session"></jsp:useBean>
        <h1>Result</h1>
        
        Matrix 1
        <table>
        <c:forEach items="${reMtx.matrix1}" var="row">
           <tr>
            <c:forEach items="${row}" var="column">
                <td>${column}</td>
            </c:forEach>
         </tr>
        </c:forEach>
        </table>
        <br>
        Matrix 2
        <table>
        <c:forEach items="${reMtx.matrix2}" var="row">
           <tr>
            <c:forEach items="${row}" var="column">
                <td>${column}</td>
            </c:forEach>
         </tr>
        </c:forEach>
        </table>
        <br>
        <c:choose>
            <c:when test="${reMtx.operation == 'dot product'}">
                Result dot product
                <c:out value="${reMtx.dp}"/>
            </c:when>
            <c:otherwise>
                Result Matrix
                <table>
                <c:forEach items="${reMtx.resultMatrix}" var="row">
                    <tr>
                    <c:forEach items="${row}" var="column">
                      <td>${column}</td>
                    </c:forEach>
                    </tr>
                 </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
         <a href="index.jsp">New Calculation</a>  
         <a method="get" href="MatrixInfoController">My Account</a> <a href="loginpage.jsp">Log Out</a>
    </body>
</html>
