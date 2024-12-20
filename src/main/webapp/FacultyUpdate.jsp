<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="modal.FacultyModal ,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>


	<%
	List<FacultyModal> facultyobj = (List<FacultyModal>) session.getAttribute("facultylistid");
	%>
	<%
	System.out.println("enterd faculty update jsp");
	%>
	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8 top">

				<%
				for (FacultyModal fm : facultyobj) {
				%>

				<h4>FACULTY REGISTRATION</h4>
				<form class="form-group" method="post"
					action="facultyupdate2controller" name="faculty"
					onsubmit="return error()">


					<div class="row">

						<div class="col-sm-6">
							<input class="form-control" type="text" id="id" name="id"
								placeholder="*ID" readonly value=<%=fm.getId()%>>
						</div>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="first_name"
								name="firstname" placeholder="*FIRST NAME"
								value=<%=fm.getFirstname()%>>
						</div>

					</div>
					<div class="row">
						<div class="col-sm-6">
							<select class="form-control" id="gender" name="gender"
								value=<%=fm.getGender()%>>
								<option value="" selected>GENDER</option>
								<option value="male">MALE</option>
								<option value="female">FEMALE</option>
								<option value="others">OTHERS</option>
							</select>
							<p></p>

						</div>
						<div class="col-sm-6">
							<input class="form-control" onfocus="firstlast1()"
								onblur="firstlast()" type="text" id="last_name" name="lastname"
								placeholder="*LAST NAME" value=<%=fm.getLastname()%>>
							<p id="fila"></p>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<input class="form-control" type="text" id="mobile"
								maxlength="10" name="mobile" placeholder="*MOBILE" readonly
								value=<%=fm.getMobile()%>>
						</div>
						<div class="col-sm-6">
							<input class="form-control" type="text" id="gmail" name="mail"
								placeholder="*MAIL ID" value=<%=fm.getMail()%>>
							<p></p>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<input class="form-control" type="text" id="year" name="year"
								placeholder="*YEARS OF EXPERIENCE" value=<%=fm.getYear()%>>
						</div>
						<div class="col-sm-6">

							<select class="form-control" id="course" name="course"
								value=<%=fm.getCourse()%>>
								<option value="" selected>COURSES</option>
								<option value="java">JAVA</option>
								<option value="python">PYTHON</option>
								<option value="dot net">DOT NET</option>
								<option value="aws">AWS</option>
								<option value="salesforce">SALESFORCE</option>
							</select>
							<p></p>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-12">
							<button type="submit" class=" form-control btn btn-success">SUBMIT</button>
							<p id="p1"></p>
						</div>
					</div>


				</form>
				<%
				}
				%>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
	<script src="./script.js"></script>
	<script>
		document.getElementById("first_name").addEventListener("keypress",
				func1);
		document.getElementById("last_name")
				.addEventListener("keypress", func1);
		document.getElementById("mobile").addEventListener("keypress", func2);
		document.getElementById("year").addEventListener("keypress", func2);

		function func1(event) {
			var chh = event.which
			if (!((chh >= 65 && chh <= 90) || (chh >= 97 && chh <= 122) || (chh == 32))) {
				event.preventDefault();
			}
		}

		function func2(event) {
			var ch = event.which;
			if (!((ch >= 48 && ch <= 57))) {
				event.preventDefault();
			}

		}

		function verify1() {

			document.getElementById("repswd").innerHTML = "";
		}
		function verify() {
			var pswd = document.getElementById("password").value;
			var repswd = document.getElementById("confirmpassword").value;

			if (pswd == repswd) {
				document.getElementById("repswd").innerHTML = "";
			} else {

				document.getElementById("repswd").innerHTML = "Confirm Password Mis-Matched";
				document.getElementById("repswd").style.color = "red";
			}
		}

		function firstlast() {

			var first_name = document.getElementById("first_name").value;
			var last_name = document.getElementById("last_name").value;
			if (first_name == last_name) {
				document.getElementById("fila").innerHTML = "*FIRST AND LAST NAME SHOULD BE DIFFERENT";
				document.getElementById("fila").style.color = "red";

			}
		}

		function firstlast1() {
			document.getElementById("fila").innerHTML = "";
		}

		function error() {
			var first_name = document.getElementById("first_name").value;
			var last_name = document.getElementById("last_name").value;
			var mobile = document.getElementById("mobile").value;
			var gmail = document.getElementById("gmail").value;
			var year = document.getElementById("year").value;
			var course = document.getElementById("course").value;
			var gender=document.getElementById("gender").value;

			if (first_name == "" || last_name == "" || mobile == ""
					|| gmail == "" || year == "" || course == ""||gender=="") {

				document.getElementById("p1").innerHTML = "*ENTER ALL MANDATORY FIELDS";
				document.getElementById("p1").style.color = "red";

				return false;
			}

			else if (first_name == last_name) {
				document.getElementById("fila").innerHTML = "*FIRST AND LAST NAME SHOULD BE DIFFERENT";
				document.getElementById("fila").style.color = "red";
				return false;
			} else if (!(pswd == repswd)) {
				return false;
			}

			else {
				return true;
			}
		}
	</script>


</body>
</html>