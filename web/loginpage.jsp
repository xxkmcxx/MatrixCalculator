<%-- 
    Document   : loginpage
    Created on : Feb 3, 2015, 2:16:28 AM
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
      <h2>LOGIN</h2>
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
    </div>
     
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
  
</html>
