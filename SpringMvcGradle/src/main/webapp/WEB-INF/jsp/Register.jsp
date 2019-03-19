<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(document).ready(function(){
       $('#register').click(function()
       {   
          var firstname=$('#firstName').val();
          var lastname=$('#lastName').val();
          var email=$('#email').val();
          
          $.ajax({
               type: "POST",
               contentType : 'application/json; charset=utf-8',
               dataType : 'json',
               url:"http://localhost:8080/prerna/saveUser",
               data:{"firstname":firstname,"lastname":lastname,"email":email},
               success: function (data) {
                  if(data=='True'){
                    $(location).attr('href','url');
                  }else{
                      alert('Fail....');
                  }
               }
             });                                
           });
         });
 </script>
</head>
<body>
<form action="/" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	<label for="firstName"><b>firstname</b></label>
    <input type="text" placeholder="Enter first name" name="firstName" required>
	
	<label for="lastName"><b>lastname</b></label>
    <input type="text" placeholder="Enter last name" name="lastName" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>	
	
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <input type="submit" name="register" id="register" value="register" />
    
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>
</body>
</html>

