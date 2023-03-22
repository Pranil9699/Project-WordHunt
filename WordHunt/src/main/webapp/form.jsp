<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>User Registration</title>
<!-- Bootstrap CSS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- Bootstrap JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="login_signup_home.css">
</head>
<body style=" background:  #afefd4;">
	<c:if test="${not empty msg}">
		<div class="modal fade" id="messageModal" tabindex="-1" role="dialog"
			aria-labelledby="messageModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="messageModalLabel">Massage:</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>
							<c:out value="${msg}" />
						</p>
					</div>
				</div>
			</div>
		</div>

		<script>
			$(document).ready(function() {
				$('#messageModal').modal('show');
				setTimeout(function() {
					$('#messageModal').modal('hide');
				}, 5000);
			});
		</script>

		<%
		session.removeAttribute("msg");
		%>
	</c:if>
	<nav class=" navbar navbar-expand-lg navbar-dark bg-primary">
		<div class=" text-center">
			<div class="row align-items-center">
				<div class="col">
					<img src="search.jpg"
						style="border-radius: 50%; vertical-align: middle;" alt="Logo">
				</div>
				<div class="col">
					<h1 class="navbar-brand mb-0">Searching System</h1>
				</div>
			</div>
		</div>
	</nav>

	<div class="login-container">
		<h1>User Updation Form</h1>
		<form action="formservlet" method="post">
			<div class="form-group">

				<label for="name">UserName </label> <input type="text"
					class="form-control" id="name" name="name" value="${user.name }"
					placeholder="Enter name..." required maxlength="30" />

			</div>
			<div class="form-group">
				<label for="email">Email address:</label> <input type="email"
					id="email" name="email" placeholder="Enter email..."  value="${user.email }"
					class="form-control" required maxlength="50" />
			</div>
			<div class="form-group">

				<label for="password">Password</label> <input type="password"
					name="password" class="form-control" id="password"  value="${user.password }"
					placeholder="Enter password..." required maxlength="50" />

			</div>
			<div class="container">
				<div class="text-center" style="display: flex;">
					<button type="submit" style="width: 40%;"
						class="btn btn-primary btn-lg m-3">Save</button>
					<a href="DashBoard.jsp" style="width: 40%;"
						class="btn btn-secondary btn-lg m-3">Back</a>
				</div>
			</div>
		</form>


	</div>



</body>
</html>
