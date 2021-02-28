<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="/NoteTaker/URLToReachResourceFolder/css/style.css" rel="stylesheet">
<style type="text/css">
.error
{
	color: red;
	margin-left: 30px;
	text-align: left;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container my-5 text-center">
		<form:form action="process-email" method="GET" modelAttribute="emailDto">
		<label>Enter your Email </label>
		<form:input path="userEmail"/>
		<input type="submit" value="send"><br><br>
		<p class="text-danger">
		Please Ensure that Email is valid as Email<br>
		Verification has not been Implemented yet
		</p>
		<form:errors path="userEmail" cssClass="error" />
		
	</form:form><br>
	
	</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>