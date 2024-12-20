package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.AdminModal;

import java.io.IOException;

import dov.AdminDov;
@WebServlet("/admin")

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String logintype=request.getParameter("logintype");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
	

		System.out.println("hi");
		AdminModal am=new AdminModal();
		am.setLogintype(logintype);
		am.setUsername(username);
		am.setPassword(password);
		
		AdminDov ad=new AdminDov();
		String status=ad.insertData(am);
		
		if(status.equals("admin")) {
			
		
			
			HttpSession session=request.getSession();
			
			session.setAttribute("username", username);
			 
			RequestDispatcher rd1=request.getRequestDispatcher("/AdminPage.jsp");
			rd1.include(request, response);
		}
		else if(status.equals("student")) {
			RequestDispatcher rd2=request.getRequestDispatcher("/StudentPage.jsp");
			rd2.include(request, response);
		}
		
		else if(status.equals("faculty")){
			
			RequestDispatcher rd3=request.getRequestDispatcher("/FacultyPage.jsp");
			rd3.include(request, response);
		}
		else {
			RequestDispatcher rd4=request.getRequestDispatcher("/Admin.jsp");
			rd4.include(request, response);
		}
		
	}

}
