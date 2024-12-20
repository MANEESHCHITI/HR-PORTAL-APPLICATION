<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
.top {
	padding-top: 100px;
}

.font {
	font-size: 40px;
	color:green;
}

.font1 {
	padding-top: 20px;
	font-size: 30px;
	color: green;
}

.button1{
	font-color:white;
}

</style>
</head>
<body style="background-color:black;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-5">
				<label class="font"> STANFORD INSTITUTE</label>
			</div>
			<div class="col-sm-3">

				<h1 class="font1">
					Welcome
					<%=session.getAttribute("username")%></h1>



			</div>
		</div>
	</div>
	<div class="container top">
		<div class="row">
			<div class="col-sm-4">
				<button  class="btn btn-success" ><a style="color:white;"href="./Student.jsp">ADD STUDENT</a></button>
			</div>
			<div class="col-sm-4">
				<button class="btn btn-success"><a style="color:white;" href="./Faculty.jsp">ADD FACULTY</a></button>
			</div>
			<div class="col-sm-4">
				<button class="btn btn-success" style="font-color:black;"><a style="color:white;" href="./Course.jsp">ADD COURSE</a></button>
			</div>

		</div>

		<div class="row" style="padding-top:200px;">
			<div class="col-sm-4">
				<form action="facultyTableServlet" method="post">
					<button type="submit" class="btn btn-success " >FACULTY LIST</button>
				</form>
			</div>
			<div class="col-sm-4">
				<form action="StudentTableController" method="post">
					<button type="submit"  class="btn btn-success">STUDENT LIST</button>
					<!-- instead we use class name in heref but by doGet by default it takes -->
				</form>
			</div>
			<div class="col-sm-4">
				<form action="CourseTable" method="post">
					<button type="submit"  class="btn btn-success">COURSE LIST</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>