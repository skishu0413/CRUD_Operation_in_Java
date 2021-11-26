<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-image: linear-gradient(to right top, #897f45, #71915d, #589f83, #49aaab, #5eb0cc, #71b0d7, #89aedd, #a1acde, #a5a6da, #aa9fd5, #b098ce, #b591c7); background-repeat: no-repeat; background-attachment: fixed; background-size: cover; ">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #b39ddb">
			<div>
				<a href="#" class="navbar-brand"> Student Details Page </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Students List</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Student</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Student</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Major Class</th>
						<th>Minor Class(If Any)</th>
						<th>Semester</th>
						<th>State</th>
						<th>Country</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="student" items="${listStudent}">

						<tr>
							<td><c:out value="${student.id}" /></td>
							<td><c:out value="${student.firstName}" /></td>
							<td><c:out value="${student.lastName}" /></td>
							<td><c:out value="${student.email}" /></td>
							<td><c:out value="${student.majorClass}" /></td>
							<td><c:out value="${student.minorClass}" /></td>
							<td><c:out value="${student.semester}" /></td>
							<td><c:out value="${student.state}" /></td>
							<td><c:out value="${student.country}" /></td>
							<td><a href="edit?id=<c:out value='${student.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>