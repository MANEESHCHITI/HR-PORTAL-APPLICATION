<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="modal.StudentModal ,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title></title>
<style>
.cent{
	text-align:center;
	color:green;
}
</style>
</head>
<body style="background-color:black;">
				
				<h4 class="cent">STUDENT LIST</h4>
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
					
					<%
					List<StudentModal> studentobj=(List<StudentModal>)session.getAttribute("studentlist");
					%>
						<table class="table table-striped">
							<thead>
								<th>Id</th>
								<th>Firstname</th>
								<th>Lastname</th>
								<th>Gender</th>
								<th>Mobile</th>
								<th>Mail</th>
								<th>Year</th>
								<th>Course</th>
								<th>Edit</th>
			
							</thead>
							<tbody>
 			
								<%if(studentobj!=null){ %>
								
								<%for(StudentModal fo:studentobj){ %>
								<tr>
			 <%System.out.println(fo.getId()+"table jsp"); %>
									<td> <%=fo.getId() %></td>
									<td> <%=fo.getFirstname()%></td>
									<td> <%=fo.getLastname()%> </td>
									<td> <%=fo.getGender()%> </td>
									<td> <%=fo.getMobile() %> </td>
									<td> <%=fo.getGmail()%> </td>	
									<td> <%=fo.getYear()%> </td>
									<td> <%=fo.getBranch()%> </td>
									<td> <%=fo.getCourse()%> </td>
									<td> <%=fo.getCollege()%> </td>
									
									<td> 
									<a href="studentupdatecontroller?id=<%=fo.getId() %>">edit</a>
									<a href="deleterowstudent?id=<%=fo.getId() %>">delete</a> </td>
															
								</tr>
								<%}
								}%>
								
						
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
				
				
				
</body>
</html>



