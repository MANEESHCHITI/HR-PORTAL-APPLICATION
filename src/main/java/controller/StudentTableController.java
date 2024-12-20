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

@WebServlet("/studenttablecontroller")
public class StudentTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StudentDov std=new StudentDov();
		List<StudentModal> list=std.selectAll();
		
		HttpSession session=request.getSession();
		session.setAttribute("studentlist",list);
		
		RequestDispatcher rd=request.getRequestDispatcher("StudentTablePage.jsp");
		rd.include(request, response);
		
	}

}
