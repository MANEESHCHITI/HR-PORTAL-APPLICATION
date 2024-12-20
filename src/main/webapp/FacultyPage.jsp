<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style>
	.font1{
			font-size: 40px;
			color:green;
		}
	</style>
</head>
<body>
		<h1>Faculty page</h1>
		
		<h1 class="font1">Welcome <%= session.getAttribute("firtname") %></h1>
</body>
</html>