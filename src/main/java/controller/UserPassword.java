package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.UserNameModal;

import java.io.IOException;

import dov.UserNameDov;

@WebServlet("/user")
public class UserPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("welcome");
	String s1=request.getParameter("username");
	String s2=request.getParameter("password");
	
	UserNameModal un=new UserNameModal();
		un.setUsername(s1);
		un.setPassword(s2);
		
		UserNameDov und=new UserNameDov();
		
		String status=und.insertData(un);
		
		if(status.equals("SUCCESS")) {
			
			System.out.println("code is working");
			RequestDispatcher rd1=request.getRequestDispatcher("/Bin.html");
			rd1.include(request, response);
		}
		else {
			RequestDispatcher rd2=request.getRequestDispatcher("/UserPassword.html");
			rd2.include(request, response);

		}
		
	
	
	}

}
