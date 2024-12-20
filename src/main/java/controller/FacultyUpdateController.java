package controller;

import java.io.IOException;
import java.sql.SQLException;
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


@WebServlet("/facultyupdatecontroller")
public class FacultyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FacultyUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
	System.out.println("id i have got"+id1);
		
		FacultyModal fm=new FacultyModal();
		fm.setId(id1);
		FacultyDov fd=new FacultyDov();
		
			List<FacultyModal> list;
			try {
				list = fd.selectByIdUpdate(fm);
				
				HttpSession session=request.getSession();
				session.setAttribute("facultylistid", list);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("./FacultyUpdate.jsp");
			rd.include(request, response);
			
	
		
		
		
		
	}

}
