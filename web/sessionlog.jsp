<%-- 
    Document   : sessionlog
    Created on : Feb 3, 2015, 7:10:06 PM
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="advprogclasses.Matrix" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Result Log</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="cssf.css">
   <script src="scriptF.js"></script> 
</head>
<body>
<jsp:useBean id="user" class="advprogclasses.User" scope="session"></jsp:useBean>
<jsp:useBean id="loginfo" class="advprogclasses.LogInfo" scope="session"></jsp:useBean>
<div class="container">
    <h2>Welcome ${user.userId}</h2>
    <a href="index.jsp">Home</a>  <a href="loginpage.jsp">Log Out</a>
    User Info:<br>
    <table class="table">
        <tr>
            <td class="col-sm-2">Name:</td>
            <td>${user.fname} ${user.lname}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td>${user.phoneNumber}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${user.address}</td>
        </tr>
        <tr>
            <td>City:</td>
            <td>${user.city}</td>
        </tr>
     <table>

     <form method ="post" action="SessionLogInfoController">
         <p> Filter Sessions by:</p> <select name ="operations" onchange="this.form.submit()">
             
             <option value = "all">----</option>
             <option value = "all">All</option>
             <option value = "sum">Sum</option>
             <option value = "substraction">Subtraction</option>
             <option value = "multiplication">Multiplication</option>
             <option value = "dot product">Dot Product</option>
         </select>
     </form>
     
   
  <ul class="list-group">
      <c:choose>
        <c:when test="${empty loginfo.filepath}">
          <p>No data found.</p>
        </c:when>
      <c:otherwise>
        <form method="get" action="SessionLogDeleteController">
        <c:forEach var="filepath" items="${loginfo.filepath}" varStatus ="loop" >
            <li class="list-group-item"><a href="${filepath}"> Log Results from session ${loginfo.sessionIds[loop.index]}</a>&nbsp;&nbsp;&nbsp;
            <button  name ="sessionId" value="${loginfo.sessionIds[loop.index]}" type="submit">X</button><br></li> 
         </c:forEach>
        </form>
      </c:otherwise>
      </c:choose>
   <%-- <c:forEach begin="1" end="${loginfo.numSessions}" varStatus ="loop" >
           <li class="list-group-item"> <a href="Sessions/Session${loop.index}.jsp"> Log Results from session ${loop.index}</a><br></li> 
    </c:forEach> --%>
  </ul>
</div>

</body>
</html>

