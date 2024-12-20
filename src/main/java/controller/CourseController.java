package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.CourseModal;

import java.io.IOException;

import dov.CourseDov;

@WebServlet("/course")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String course=request.getParameter("course");
		String fee=request.getParameter("fee");
		int fee01=Integer.parseInt(fee);
		String duration=request.getParameter("duration");
		int duration01=Integer.parseInt(duration);
		String location=request.getParameter("location");

		CourseModal cm=new CourseModal();
		cm.setCoursename(course);
		cm.setFee(fee01);
		cm.setDuration(duration01);
		cm.setLocation(location);
		
		CourseDov cd=new CourseDov();
		String status=cd.insertData(cm);
		
		if(status.equals("success")) {
			RequestDispatcher rd1=request.getRequestDispatcher("/AdminPage.jsp");
			rd1.include(request, response);
		}
		else {
			RequestDispatcher rd2=request.getRequestDispatcher("/Course.jsp");
			rd2.include(request, response);
		}

		
	}

}
