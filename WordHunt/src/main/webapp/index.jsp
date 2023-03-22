<!DOCTYPE html>
<html>
<head>
<title>Searching System</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Custom CSS -->
<style>
body {
	background-color: #f7f7f7;
	color: #333;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.container {
	margin-top: 50px;
	text-align: center;
}

h1 {
	color: #007bff;
	font-size: 4rem;
	font-weight: bold;
	margin-bottom: 50px;
}

.card {
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 30px;
	margin-bottom: 30px;
}

.card:hover {
	transform: scale(1.05);
	transition: transform 0.5s ease;
}

.card-title {
	color: #333;
	font-size: 2rem;
	font-weight: bold;
	margin-bottom: 30px;
}

.card-text {
	color: #555;
	font-size: 1.2rem;
	line-height: 1.5;
	margin-bottom: 30px;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
	color: #fff;
	font-size: 1.2rem;
	font-weight: bold;
	padding: 10px 20px;
	transition: background-color 0.5s ease;
}

.btn-primary:hover {
	background-color: #0062cc;
	border-color: #0062cc;
	transition: background-color 0.5s ease;
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
<body style=" background:  #afefd4;">
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
		<h1>Searching System</h1>
		<div class="row">
			<div class="col-md-6 mb-4 ">
				<div class="card bg-light">
					<div class="card-title">User Login</div>
					<div class="card-text">Login to access your account and
						manage History, Search new, and more.</div>
					<a href="Login.jsp" class="btn btn-primary">Login</a>
				</div>
			</div>
			<div class="col-md-6 mb-4 ">
				<div class="card bg-light">
					<div class="card-title">User Sign Up</div>
					<div class="card-text">Register to create an account and Search
						Content On Own Search Bar.</div>
					<a href="Register.jsp" class="btn btn-primary">Register</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

