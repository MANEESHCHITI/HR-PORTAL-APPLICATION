package controller;

import java.io.IOException;
import java.sql.SQLException;

import dov.StudentDov;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.StudentModal;

@WebServlet("/studentupdate2controller")
public class StudentUpdate2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		System.out.println("hi studentupdate2controller ");
		int id1=Integer.parseInt(id);
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		String mail=request.getParameter("mail");
		String year=request.getParameter("year");
		int year1=Integer.parseInt(year);
		String course=request.getParameter("course");
		
		StudentModal fm=new StudentModal();
		
		fm.setId(id1);
		fm.setFirstname(firstname);
		fm.setLastname(lastname);
		fm.setGender(gender);
		fm.setMobile(mobile);
		fm.setGmail(mail);
		fm.setYear(year1);	
		fm.setCourse(course);
		
		StudentDov fd=new StudentDov();
		boolean status=false;
		status=fd.facultyUpdate(fm); 
		 System.out.println(status+"in Controller");
		if(status) {
			
			RequestDispatcher rd=request.getRequestDispatcher("StudentTableController");//here it mapped with annotations  we can use webxml also
			rd.include(request, response);
		}

	}

}
