<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard Of User</title>
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
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0/css/bootstrap.min.css">
 -->
<style type="text/css">
.test {
	width: 100px;
	text-overflow: ellipsis;
	white-space: nowrap;
	overflow: hidden;
}

.test:hover {
	overflow: visible;
	white-space: normal;
	height: auto;
	word-wrap: break-word;
	white-space: pre-wrap;
}

.container {
	margin-top: 50px;
}

.form-group label {
	font-weight: bold;
}

.btn {
	margin-top: 10px;
}
/* Add custom style for logout button */
.logout-btn {
	background-color: #dc3545 !important;
	border-color: #dc3545 !important;
}

@media ( max-width : 767px) {
	/* Center the logout button in small screens */
	.logout-btn {
		margin-top: 10px;
		margin-left: 10px;
		margin-right: 10px;
		display: block;
	}
}

.error-container {
	margin-top: 5rem;
	text-align: center;
	background-color: #fff;
	padding: 3rem;
	box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
	border-radius: 0.5rem;
}

.error-image {
	max-width: 100%;
	border-radius: 50%;
}
/* Add logo to header */
.navbar-brand {
	padding: 0;
}

.navbar-brand h1, img {
	height: 50px;
	padding: 5px;
}

.navbar-brand img {
	height: 50px;
	padding: 5px;
}
</style>

</head>
<body>
	<%
	HttpSession sessions = request.getSession();
	if (sessions.getAttribute("user") != null) {
	%>

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

	<div class="container">
		<div class="bg-light card mt-5 p-4 mb-5">
			<h4 class="text-center">
				<c:out value="${user.name }" />
				DashBoard
			</h4>
			<form action="getdata" class=" card-body" method="post">
				<div class="form-group">
					<label for="categoryName">Select Category:</label> <select
						class="form-control" name="categoryName" id="categoryName"
						required>
						<option value="">Select a Category</option>
						<option value="song">Song Name</option>
						<option value="person">Person Name</option>
						<option value="therapy">Medical Therapy Name</option>
						<option value="subject">Subject Name</option>
						<option value="topic">Topic Name</option>
						<option value="person">Movie Name</option>
						<option value="other">Other</option>
					</select>
				</div>
				<div class="form-group" id="otherCategoryGroup"></div>

				<script type="text/javascript">
					window.onload = function() {
						document
								.getElementById('categoryName')
								.addEventListener(
										'change',
										function() {
											var categoryName = this.value;
											var otherCategoryGroup = document
													.getElementById('otherCategoryGroup');
											if (categoryName === 'other') {
												otherCategoryGroup.innerHTML = '<label for="otherCategory">Enter Category:</label><input type="text" class="form-control" id="otherCategory" name="otherCategory" placeholder="Enter Category...">';
											} else {
												otherCategoryGroup.innerHTML = '';
											}
										});
						var categorySelect = document
								.getElementById("categoryName");
						var otherInput = document.createElement("input");
						otherInput.setAttribute("type", "text");
						otherInput.setAttribute("class", "form-control");
						otherInput.setAttribute("id", "otherCategory");
						otherInput.setAttribute("name", "otherCategory");
						otherInput.setAttribute("placeholder",
								"Enter a Category...");
						otherInput.setAttribute("maxlength", "30");

						categorySelect.addEventListener("change", function() {
							var selectedValue = categorySelect.value;
							var formGroup = categorySelect.parentNode;
							var existingOtherInput = document
									.getElementById("otherCategory");

							if (selectedValue === "other") {
								if (!existingOtherInput) {
									formGroup.appendChild(otherInput);
								}
							} else {
								if (existingOtherInput) {
									formGroup.removeChild(existingOtherInput);
								}
							}
						});
					};
				</script>

				<div class="form-group">

					<label for="search">Search String </label> <input type="text"
						class="form-control" id="search" name="search"
						placeholder="Enter Search Keyword ..." required maxlength="30" />

				</div>

				<div class="text-center ">
					<a href="show_history" class="btn btn-secondary  m-1 ">History</a>
					<a href="formservlet" class="btn btn-info  m-1 ">Profile</a> <a
						href="errorservlet" class="btn btn-danger  m-1">Logout</a> <input
						type="submit" class="btn btn-primary m-1" value="Search">
				</div>

			</form>
		</div>
		<c:if test="${not empty content.category}">
			<div class="card mb-4">
				<div class="card-header">
					<div class="row">
						<div class="col-sm-12">
							<p class="float-right">
								<c:out value="${content.date}" />
							</p>
						</div>

					</div>
				</div>
				<div class="card-body">
					<h4 class="card-title">
						Category :
						<c:out value="${content.category }" />
					</h4>
					<h4 class="card-title">
						Search KeyWord :
						<c:out value="${content.name }" />
					</h4>
					<form action="updatecontent" method="POST">
						<input type="hidden" name="id"
							value="<c:out
									value="${content.contentid.id}" />" /> <input
							type="hidden" name="contentid"
							value="<c:out
									value="${content.contentid.contentid}" />" />
						<div class="form-group">
							<label for="information" class="card-title">Information:</label>
							<textarea class="form-control" id="information" rows="8"
								name="information"><c:out
									value="${content.infomation}" /></textarea>
						</div>
						<div class="text-center">
							<a
								href="updatecontent?id=${content.contentid.id}&contentid=${content.contentid.contentid}"
								class="btn btn-danger">Delete</a>
							<button type="submit" class="btn btn-success">Save</button>
						</div>
					</form>
				</div>
			</div>
		</c:if>

	</div>

	<%
	} else {
	%>
	<div class="container error-container">
		<img class="error-image rounded rounded-3" src="error1.jpeg"
			alt="Error Image">
		<h1 class="display-4">Oops! Something went wrong.</h1>
		<p class="lead">We're sorry, but there was an error processing
			your request.</p>
		<form action="errorservlet" method="post">
			<button class="btn btn-info ">Go Back To Home Page</button>
		</form>

	</div>

	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi4h1f"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNVQ8qc"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<%
	}
	%>
</body>
</html>