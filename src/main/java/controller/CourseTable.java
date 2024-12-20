
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import dov.CourseDov;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.CourseModal;

//@WebServlet("coursetable")

public class CourseTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CourseDov cv = new CourseDov();
		try {
			List<CourseModal> ll = cv.selectAll();

			HttpSession hs = request.getSession();
			hs.setAttribute("courselist", ll);

			RequestDispatcher rd = request.getRequestDispatcher("CourseTable.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
