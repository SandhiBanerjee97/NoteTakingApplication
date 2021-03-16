<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="/NoteTaker/URLToReachResourceFolder/css/style.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container d-flex justify-content-center my-5">
		<div class="alert alert-primary" role="alert">
			<h5 class="card-title text-center">About The Application</h5>
			This is Note Taking Application ,which allows Users<br>
			to save,Download PDF and Send notes via Email .<br>
			<b>Technologies and libraries Used</b><br>
			 1.Spring MVC <br>
			 2.Hibernate + MySql<br>
			 3.Hibernate Validator<br>
			 4.JavaMail API<br>
			 5.iTextPDF Library<br>
			 6.Html,css and BootStrap<br>
		</div>
	</div>
	<div class="container d-flex justify-content-center my-5">
		<div class="card alert alert-success">
			<div class="card-body">
				<h5 class="card-title">Functionalities Provided</h5>
				<p class="card-text">
					1.Take and Save Notes(upto 1200 characters)<br> 2.Send Note Via Email <br>
					3.Download PDF Copy Of Notes<br> 4.Update Note
				</p>
			</div>
		</div>
	</div>
	<div class="container d-flex justify-content-center my-5">
		<div class="card alert alert-danger">
			<div class="card-body">
				<h5 class="card-title">yet to be Implement</h5>
				<p class="card-text">
					1.User Data Management <br> 2.Security Module <br>
				    3.Email Verification <br> 4.Exception Handling
				</p>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>