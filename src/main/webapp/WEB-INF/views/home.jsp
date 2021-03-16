<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="/NoteTaker/URLToReachResourceFolder/css/style.css" rel="stylesheet">


<title>Notes App</title>
</head>
<body>
<%@include file="navbar.jsp"%>
	<div class="container">
	<h1 class="text-center headings">All Notes</h1>
	<c:forEach items="${notes}" var="temp">
		<div class="card mt-3 bkd">
		<img class="card-image-top m-4" src="/NoteTaker/URLToReachResourceFolder/Image/post-it.png" alt="card image cap">
			<div class="card-body">
				<h3 class="card-title">
					<c:out value="${temp.noteTitle}"></c:out>
				</h3>
				<div>
				<p class="card-text">
				    <b>Added By: </b><c:out value="${temp.noteAuthor}"></c:out><br>
				    <b>On: </b><c:out value="${temp.noteDate}"></c:out>
				</p>
				<p class="card-text">
					<c:out value="${temp.noteContent}"></c:out>
				</p>
				<div class="container text-center">

					<a href="email?id=${temp.noteId}" class="btn btn-primary btn-sm">EMail</a>
					<a href="download?id=${temp.noteId}" class="btn btn-success btn-sm">Download</a>
					<a href="update?id=${temp.noteId}" class="btn btn-warning btn-sm">Update</a>
					<a href="delete?id=${temp.noteId}" class="btn btn-danger btn-sm">Delete</a>
				</div>
			</div>
		</div>
		</div>
	</c:forEach>
	</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>