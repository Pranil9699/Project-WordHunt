<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<style type="text/css">
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
		<h3 class="text-center display-4">History</h3>
		<h4 class="text-center"><a
						href="DashBoard.jsp" class="btn btn-info  m-1 ">Back</a></h4>
		<c:forEach items="${ contents}" var="content">
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
									value="${content.contentid.id}" />" />
							<input type="hidden" name="contentid"
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
		</c:forEach>
	</div>
</body>
</html>