package controller;

import java.io.IOException;

import dov.StudentDov;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.StudentModal;

@WebServlet("/student")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String firstname=request.getParameter("firstname");
	String lastname=request.getParameter("lastname");
	String gender=request.getParameter("gender");
	String mobile=request.getParameter("mobile");
	String gmail=request.getParameter("gmail");   
	String year=request.getParameter("year");
	int year1=Integer.parseInt(year);
	String branch=request.getParameter("branch");
	String course=request.getParameter("course");
	String college=request.getParameter("college");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	StudentModal sm=new StudentModal();
	
	
	sm.setFirstname(firstname);
	sm.setLastname(lastname);
	sm.setGender(gender);
	sm.setMobile(mobile);
	sm.setGmail(gmail);
	sm.setYear(year1);
	sm.setBranch(branch);
	sm.setCourse(course);
	sm.setCollege(college);
	sm.setUsername(username);
	sm.setPassword(password);
	
	StudentDov sd=new StudentDov();
	
	String status=sd.insertData(sm);
	
	if(status.equals("success")) {
		
		RequestDispatcher rd1=request.getRequestDispatcher("/AdminPage.jsp");
		rd1.include(request, response);
	}
	else {
		RequestDispatcher rd2=request.getRequestDispatcher("/Student.jsp");
		rd2.include(request, response);

	}
	
	
	
	
	
	}

}
