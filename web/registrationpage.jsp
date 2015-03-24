<%-- 
    Document   : registrationpage
    Created on : Feb 9, 2015, 9:21:33 AM
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
     <script src="scriptF.js"></script> 
  </head>

  <body>
    <div class="container">
      <h2>Registration</h2>
      <form action="RegistrationProcessController" method="POST" name="login"role="form" onsubmit="return validateRegistration()">
        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" class="form-control" id="email" placeholder="Username" name="userId">
        </div>
         
        <div class="form-group">
          <label for="pwd">Password:</label>
          <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
        </div>
          
        <div class="form-group">
          <label for="fname">First Name:</label>
          <input type="text" class="form-control" id="pwd" placeholder="First Name" name="fname">
        </div>
        
        <div class="form-group">
          <label for="lname">Last Name:</label>
          <input type="text" class="form-control" id="pwd" placeholder="Last Name" name="lname">
        </div>
        
        <div class="form-group">
          <label for="email">email:</label>
          <input type="email" class="form-control" id="pwd" placeholder="Email" name="email">
        </div>
         
         <div class="form-group">
          <label for="phone">Phone:</label>
          <input type="text" class="form-control" id="pwd" placeholder="phone number" name="phone">
        </div>
         
        <div class="form-group">
          <label for="address">Address:</label>
          <input type="text" class="form-control" id="pwd" placeholder="Address" name="address">
        </div>
          
         <div class="form-group">
          <label for="pwd">City:</label>
          <input type="text" class="form-control" id="pwd" placeholder="city" name="city">
        </div>
        <button type="submit" class="btn btn-default" value="Login">Register</button>
      </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
</html>

<%---<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration</h1>
        
        <form method="POST" action="RegistrationProcessController">
            username:<input type="text" name="username"><br>
            fist Name:<input type="text" name="fname"><br>
            last Name:<input type="text" name="lname"><br>
            password:<input type ="password" name="password"><br>
            email:<input type="email" name="email"><br>
            phone:<input type="text" name="phone"><br>
            address:<input type="text" name="address"><br>
            city:<input type="text" name="city"><br>
            <input type="submit" value="Register"><br>
            </form>
            
    </body>
</html>----%>
