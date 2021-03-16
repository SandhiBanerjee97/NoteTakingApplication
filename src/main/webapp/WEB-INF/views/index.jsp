<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="/NoteTaker/URLToReachResourceFolder/css/style.css" rel="stylesheet">

<title>Welcome</title>
</head>
<body>						
<%@include file="navbar.jsp"%>
	<h1 class="text-center headings">Flying Notes</h1>
	<h5 class="text-center headings">Save, Share and Download Notes Anywhere</h5>
	<div class="card my-5">
		<img  src="/NoteTaker/URLToReachResourceFolder/Image/post-it.png" class="img-fluid banner">
		<h1 class="text-primary text-uppercase text-center mt-3">Start Taking Your Notes Today</h1>
		<div class="container text-center">
			<a href="/NoteTaker/home" class="btn btn-outline-primary text-center">Start Here</a>
		</div>
		<div class="alert alert-warning my-5" role="alert">
  			Note, This Application is still under development. Security ,User Data
  		    Management and Other Modules has not been implemented yet. It is recommended not 
  			to post <span class="warn">"Private"</span> or <span class="warn">"Sensitive"</span> 
  			content as every Note is visible and available for Download to other Users.HOWEVER 
  			This Application can be used to <span class="works">take Small Notes</span> and
  		    <span class="works">Download Notes as PDF</span> or <span class="works">Send Notes
  		    </span> via Email.To Know more Check out About Section.
		</div>
	</div>	


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>