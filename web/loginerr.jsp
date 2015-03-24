<%-- 
    Document   : loginerr
    Created on : Feb 4, 2015, 11:09:59 AM
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  </head>

  <body>
    <div class="container">
      <h2>Administrator Login</h2>
      <form action="LoginController" method="POST" name="login"role="form">
        <div class="form-group">
          <label for="email">Username</label>
          <input type="text" class="form-control" id="email" placeholder="Username" name="userId">
        </div>
        <div class="form-group">
          <label for="pwd">Password:</label>
          <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
        </div>
        <button type="submit" class="btn btn-default" value="Login">Submit</button>
      </form>
      <a href="registrationpage.jsp">Not a member? Register Now! </a>
      <p>Invalid username or password</p>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
</html>



<%--
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssf.css">
        <title>Administrator Login</title>
    </head>
    <body>
        <h1>Administrator Login</h1>
        <form action="LoginController" method="POST" name="login">
            Username:<input type="text" name=username><br>
            Password:<input type="password" name="password">
            <input type="submit" value="Login">
        </form>
        <p class="txt" >Invalid username or password</p>
    </body>
</html>
--%>