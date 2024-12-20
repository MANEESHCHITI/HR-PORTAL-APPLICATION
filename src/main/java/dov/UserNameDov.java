package dov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modal.UserNameModal;

public class UserNameDov {
	
	String status="FAILURE";
	public String insertData(UserNameModal und) {
		
		System.out.println("modal--"+und.getUsername());
		System.out.println("modal--"+und.getPassword());
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");

		PreparedStatement ps=con.prepareStatement("select *from register where username=? and password=?");
		
		ps.setString(1,und.getUsername());
		ps.setString(2,und.getPassword());

		ResultSet eq = ps.executeQuery();
		
		while(eq.next()) {
			System.out.println(" entered while");
			
			return "SUCCESS";
			
		}

		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	
}
}
