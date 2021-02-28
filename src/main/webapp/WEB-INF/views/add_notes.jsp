<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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

<title>Add Notes</title>
</head>
<body>
<%@include file="navbar.jsp"%>
	<div class="container">
	<h1 class="mt-1 text-center headings">Enter your Note</h1><br>
	<form:form action="saveNote" method="post" modelAttribute="note">
		<form:hidden path="noteId"/>
		<br>
		<label for="name" class="form-label">Enter your name</label>
		<div class="form-group">
			<form:input path="noteAuthor"  maxlength="30" cssClass="form-control" placeholder="Enter your name" id="name" />
			<form:errors path="noteAuthor" cssClass="error"/>
		</div>
		<br>
		<label for="title" class="form-label">Note Title</label>
		<div class="form-group">
			<form:input path="noteTitle" maxlength="100" cssClass="form-control" placeholder="Enter your note title" id="title" />
			<form:errors path="noteTitle" cssClass="error"/>
		</div>
		<br>
		<label for="content" class="form-label">Note Content</label>
		<div class="form-group">
			<form:textarea maxlength="1200" path="noteContent" cssClass="form-control" cssStyle="height:300px" placeholder="Enter your note" id="content" />
			<form:errors path="noteContent" cssClass="error"/>
		</div>
		<div class="container text-center">
			<button class="btn btn-outline-success">Add Note</button>
		</div>
	</form:form>
	</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>