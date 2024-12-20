package controller;

import java.io.IOException;
import java.util.List;

import dov.StudentDov;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.StudentModal;

@WebServlet("/studentupdatecontroller")
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
	System.out.println("id i have got"+id1);
		
		StudentModal fm=new StudentModal();
		fm.setId(id1);
		StudentDov fd=new StudentDov();
		
			List<StudentModal> list;
			list = fd.selectByIdUpdate(fm);
			
			HttpSession session=request.getSession();
			session.setAttribute("studentlistid", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("./StudentUpdate.jsp");
			rd.include(request, response);
			
	}

	

}
