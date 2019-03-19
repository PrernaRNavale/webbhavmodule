<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {

			// SUBMIT FORM
			$("#registerForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

		function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					username : $("#username").val(),
					password : $("#password").val(),
					confirmPassword : $("#confirmPassword").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "saveCandidateData",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").jsp(
									"" + result.data.username
											+ "Register Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						} else {
							$("#postResultDiv").jsp("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

		}
			// GET REQUEST
			$("#getAllCandidates").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "getAllCandidates",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv').empty();
							var custList = "";
							$.each(result.data,
									function(i, candidate) {
										var user = "Candidate Name  "
												+ candidate.username
												+ ", Password  = " + candidate.password
												+ "<br>";
										$('#getResultDiv .list-group').append(
												candidate)
									});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		});
		
</script>
</head>

<body>
	<div id="postResultDiv" align="center"></div>
	<div class="container">
		<h2>Rgistration form</h2>
		<form id="registerForm">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text" class="form-control" id="username" placeholder="Enter Username" name="username">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="text" class="form-control" id="password" placeholder="Enter Password" name="password">
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password :</label> <input type="text" class="form-control" id="confirmPassword" placeholder="Enter Confirm Password" name="confirmPassword">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br />
		
		<div class="col-sm-7" style="margin: 20px 0px 20px 0px">
			<button id="getAllCandidates" type="button" class="btn btn-primary">Get All Candidates</button>
			<div id="getResultDiv" style="padding: 20px 10px 20px 50px">
				<ul class="list-group">
				</ul>
			</div>
		</div>
	</div>
</body>
</html>