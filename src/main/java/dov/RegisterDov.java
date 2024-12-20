package dov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import modal.RegisterModal;

public class RegisterDov {

public String insertData(RegisterModal rm){
		
		String status="FAILURE";
		System.out.println("dav--"+rm.getFirstname());
		try {
			//loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//connection establish
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			 PreparedStatement ps=con.prepareStatement("insert into  register values(?)");
			 ps.setString(1, rm.getFirstname());
			 int n=ps.executeUpdate();
			 if(n>0) {
				 return status="SUCCESS";
			 }
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
			 
	}
}
