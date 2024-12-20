package controller;

import java.io.IOException;
import java.util.List;

import dov.FacultyDov;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.FacultyModal;

@WebServlet("/facultyTableServlet")
public class FacultyTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FacultyDov ftd=new FacultyDov();
		List<FacultyModal> list=ftd.selectAll();
		
		HttpSession session=request.getSession();
		session.setAttribute("facultylist",list);
		
		RequestDispatcher rd=request.getRequestDispatcher("FacultyTablePage.jsp");
		rd.include(request, response);
	
	}

}


