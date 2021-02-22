<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/NoteTaker/URLToReachResourceFolder/css/style.css"
	rel="stylesheet">

<title>Notes App</title>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		
	<h1>All Notes </h1>
	<c:forEach items="${notes}" var="temp">
		<div class="card mt-3">
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
					<a href="email?id=${temp.noteId}" class="btn btn-primary">EMail</a>
					<a href="download?id=${temp.noteId}" class="btn btn-success">Download</a>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>



</body>
</html>