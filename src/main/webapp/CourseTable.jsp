<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="modal.CourseModal ,java.util.List"%>
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
				
				<h4 class="cent">COURSE LIST</h4>
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
					
					<%
					List<CourseModal> courseobj=(List<CourseModal>)session.getAttribute("courselist");
					%>
						<table class="table table-striped">
							<thead>
								<th>Id</th>
								<th>CourseName</th>
								<th>Fee</th>
								<th>Duration</th>
								<th>Location</th>
								<th>Edit</th>
			
							</thead>
							<tbody>
 			
								<%if(courseobj!=null){ %>
								
								<%for(CourseModal fo:courseobj){ %>
								<tr>
				 <%System.out.println(fo.getCourseid()+"table jsp"); %>
									<td> <%=fo.getCourseid() %></td>
									<td> <%=fo.getCoursename()%></td>
									<td> <%=fo.getFee()%> </td>
									<td> <%=fo.getDuration()%> </td>
									<td> <%=fo.getLocation() %> </td>
									
									<td> 
									<%-- <a href="?id=<%=fo.getCourseid() %>">edit</a> --%>
									<%-- <a href="deleterow?id=<%=fo.getId() %>">delete</a> </td> --%>
															
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



