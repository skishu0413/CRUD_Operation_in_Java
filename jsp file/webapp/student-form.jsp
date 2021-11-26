<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style = "background-image: linear-gradient(to right top, #897f45, #71915d, #589f83, #49aaab, #5eb0cc, #71b0d7, #89aedd, #a1acde, #a5a6da, #aa9fd5, #b098ce, #b591c7); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #b39ddb">
			<div>
				<a href="" class="navbar-brand">
					Student Details page </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Students List</a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="id"
						value="<c:out value='${student.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${student.firstName}' />"
						class="form-control" name="firstName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${student.lastName}' />" class="form-control"
						name="lastName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out value='${student.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Major Class</label> <input type="text"
						value="<c:out value='${student.majorClass}' />"
						class="form-control" name="majorClass" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Minor Class</label> <input type="text"
						value="<c:out value='${student.minorClass}' />"
						class="form-control" name="minorClass">
				</fieldset>

				<fieldset class="form-group">
					<label>Semester</label> <input type="text"
						value="<c:out value='${student.semester}' />" class="form-control"
						name="semester" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>State </label> <input type="text"
						value="<c:out value='${student.state}' />" class="form-control"
						name="state" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Country</label> <input type="text"
						value="<c:out value='${student.country}' />" class="form-control"
						name="country">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>