<%-- 
    Document   : index
    Created on : Jan 26, 2015, 8:28:39 PM
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matrix Calculator</title>
         <script src="scriptF.js"></script> 
    </head>
    <body>
        <jsp:useBean id="user" class="advprogclasses.User" scope="session"></jsp:useBean>
        <h1>Welcome ${user.userId}</h1>  
        <form name="mForm" method="post" action="MatrixInfoController" onsubmit="return validateForm()">
            Matrix 1 <br>
            number of rows<br><input type="text" name="rows1" min="1" max="10"><br>
            number of columns<br><input type="text" name="cols1" min="1" max="10"><br>
            <br><br> <br>
            Matrix 2 <br>
            number of rows<br><input type="text" name="row2" min="1" max="10"><br>
            number of columns<br><input type="text" name="col2" min="1" max="10"><br>
            Operation<br>
            Sum<input type="radio" name="operation" id="1" value="sum" checked>  Substraction<input type="radio" name="operation" id="2" value="substraction">
            Dot Product<input type="radio" name="operation" value="dot product" id="3">  Multiplication <input type="radio" name="operation" value="multiplication" id="4"><br>
            <input type="submit" value="submit">
        </form>
        <a method="get" href="MatrixInfoController">My Account</a> <a href="loginpage.jsp">Log Out</a>
    </body>
</html>
   