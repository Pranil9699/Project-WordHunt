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

.search-result-content {
	display: none;
}
</style>
</head>
<body style=" background:  #afefd4;">
	<nav style="background:#afefd4 ;" class=" navbar navbar-expand-lg navbar-dark bg-primary">
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
	
	<h2 class="text-center"><a
						href="DashBoard.jsp" class=" display-4 btn btn-outline-info btn-primary  m-1 button-css">Back</a></h2>
		<script>
		function toggleContent(button) {
			var content = button.parentNode
					.querySelector('.search-result-content');
			if (content.style.display === 'none') {
				content.style.display = 'block';
				button.textContent = 'Show Less';
			} else {
				content.style.display = 'none';
				button.textContent = 'Show More';
			}
		}
	</script>
	<div class="container mb-5"  >
		<div class="row card">
			<div class="col-md-12" >
				<h2 class="text-center display-4" >Search History</h2>

				<hr style="font-size:2px;">
				<c:forEach items="${content }" var="content">
					<c:if test="${not empty content.category}">
						<div class="search-result">
							<h3 >
								<a href="<c:out value="${content.link }" />"><c:out
										value="${content.title }" /></a>
								<p class="float-right fs-2" style="font-size:15px;">
									<c:out value="${content.date}" />
								</p>
							</h3>

							<p class="fs-1" style="font-size:20px;">
								<c:out value="${content.description }" />
							</p>
							
							<button class="btn btn-primary m-auto" onclick="toggleContent(this)">Show
								More</button>


							<div class="search-result-content">
								<form action="updatecontent" method="POST">
									<input type="hidden" name="id"
										value="<c:out
									value="${content.contentid.id}" />" />
									<input type="hidden" name="contentid"
										value="<c:out
									value="${content.contentid.contentid}" />" />
									<input type="hidden" name="srno"
										value="<c:out
									value="${content.contentid.srno}" />" />
									<p>
										<textarea class="form-control" id="information" rows="8"
											name="information" style="font-size:20px;"><c:out
												value="${content.infomation}" /></textarea>
									</p>
									<div class="text-center">
										<a
											href="updatecontent?id=${content.contentid.id}&contentid=${content.contentid.contentid}&srno=${content.contentid.srno}"
											class="btn btn-danger">Delete</a>
										<button type="submit" class="btn btn-success">Save</button>
									</div>
								</form>
							</div>
						</div>
						<hr>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>