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

@WebServlet("/deleterowstudent")
public class DeleteRowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		StudentDov fd=new StudentDov();
		boolean status = false;
		status=fd.deleteRow(id1);
		System.out.println(status+"in controlllller");
		if(status) {
			System.out.println("everything good");
			
			RequestDispatcher rd=request.getRequestDispatcher("studenttablecontroller"); 

			System.out.println(status+"in condition");
			rd.include(request, response); 
			System.out.println(status+"in below");
	}

}
}
