package controller;

import java.io.IOException;
import java.sql.SQLException;

import dov.FacultyDov;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.FacultyModal;


@WebServlet("/facultyupdate2controller")
public class FacultyUpdate2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FacultyUpdate2Controller() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		System.out.println(id);
		int id1=Integer.parseInt(id);
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		Long mobile1=Long.parseLong(mobile);
		String mail=request.getParameter("mail");
		String year=request.getParameter("year");
		int year1=Integer.parseInt(year);
		String course=request.getParameter("course");
		
		FacultyModal fm=new FacultyModal();
		
		fm.setId(id1);
		fm.setFirstname(firstname);
		fm.setLastname(lastname);
		fm.setGender(gender);
		fm.setMobile(mobile1);
		fm.setMail(mail);
		fm.setYear(year1);	
		fm.setCourse(course);
		
		FacultyDov fd=new FacultyDov();
		boolean status=false;
		try {
			status=fd.facultyUpdate(fm);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 
		 System.out.println(status+"in Controller");
		if(status) {
			
			RequestDispatcher rd=request.getRequestDispatcher("FacultyTableController");//here it mapped with annotations  we can use webxml also
			rd.include(request, response);
		}
		
		
	}

}
