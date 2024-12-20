package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.RegisterModal;

import java.io.IOException;

import dov.RegisterDov;

@WebServlet("/go")
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register1() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("hlo");  
		String fname = request.getParameter("firstname");
	System.out.println("html--"+fname); 
		
		 RegisterModal r1=new  RegisterModal();
		 r1.setFirstname(fname);
		 
	System.out.println( "modal--"+r1.getFirstname());
		
		RegisterDov rd=new RegisterDov();
		
		String status =rd.insertData(r1);
		System.out.println("dov--"+status);
		
		if(status.equals("SUCCESS")) {
	        RequestDispatcher rd1 = request.getRequestDispatcher("/Bin.html");  
	        rd1.include(request, response); 
	       
		}
		else{
	        RequestDispatcher rd1 = request.getRequestDispatcher("/index.html");  
	        rd1.include(request, response);
		}
	}

}
