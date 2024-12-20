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

@WebServlet("/deleterow")
public class DeleteRow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteRow() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		FacultyDov fd=new FacultyDov();
		boolean status = false;
		try {
			status=fd.deleteRow(id1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(status+"in controlllller");
		if(status) {
			System.out.println("everything good");
			RequestDispatcher rd=request.getRequestDispatcher("Course.jsp"); //here only FacultyTablePage was not redirecting
//			response.sendRedirect("Course.jsp");
			System.out.println(status+"in condition");
			rd.include(request, response); 
			System.out.println(status+"in below");
			
		}
	}

}
