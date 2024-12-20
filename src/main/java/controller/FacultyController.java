package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.FacultyModal;

import java.io.IOException;

import dov.FacultyDov;

@WebServlet("/faculty")
public class FacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		Long mobile1=Long.parseLong(mobile);
		String mail=request.getParameter("mail");
		String year=request.getParameter("year");
		int year1=Integer.parseInt(year);
		String course=request.getParameter("course");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		FacultyModal fm=new FacultyModal();
		
		fm.setFirstname(firstname);
		fm.setLastname(lastname);
		fm.setGender(gender);
		fm.setMobile(mobile1);
		fm.setMail(mail);
		fm.setYear(year1);
		fm.setCourse(course);
		fm.setUsername(username);
		fm.setPassword(password);
		
		FacultyDov fd=new FacultyDov();
		String status=fd.insertData(fm);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("collist",status);                  //key,value
		
		if(status.equals("success")) {
			
			RequestDispatcher rd1=request.getRequestDispatcher("/AdminPage.jsp");
			rd1.include(request, response);
		}
		else {
			RequestDispatcher rd2=request.getRequestDispatcher("/Faculty.jsp");
			rd2.include(request, response);
		}
		
		
	}

}
