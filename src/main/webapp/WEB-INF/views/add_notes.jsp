<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/NoteTaker/URLToReachResourceFolder/css/style.css"
	rel="stylesheet">

<title>Add Notes</title>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
	<h1 class="mt-1">Please fill Your Note Detail</h1><br>
	<form:form action="saveNote" method="post" modelAttribute="note">
		<label for="name" class="form-label">Enter your name</label>
		<div class="form-group">
			<form:input path="noteAuthor" cssClass="form-control" placeholder="Enter your name" id="name" />
		</div>
		<br>
		<label for="title" class="form-label">Note Title</label>
		<div class="form-group">
			<form:input path="noteTitle" cssClass="form-control" placeholder="Enter your note title" id="title" />
		</div>
		<br>
		<label for="content" class="form-label">Note Content</label>
		<div class="form-group">
			<form:textarea path="noteContent" cssClass="form-control" cssStyle="height:300px" placeholder="Enter your note" id="content" />
		</div>
		<div class="container text-center">
			<button class="btn btn-outline-success">Add Note</button>
		</div>
	</form:form>
	</div>

</body>
</html>