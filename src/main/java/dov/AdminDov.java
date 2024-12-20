package dov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modal.AdminModal;

public class AdminDov {

	String status="failure";
public String insertData(AdminModal am) {
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	
	
	
	
	
	if(am.getLogintype().equals("admin")) {
	PreparedStatement ps=con.prepareStatement("select *from Admin1 where username=? and password=?");
	ps.setString(1,am.getUsername());
	ps.setString(2,am.getPassword());
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		return "admin";
	}
	}
	
	else if(am.getLogintype().equals("student")) {
		PreparedStatement ps=con.prepareStatement("select *from student where username=? and password=?");
		ps.setString(1,am.getUsername());
		ps.setString(2,am.getPassword());
		ResultSet rs=ps.executeQuery();
		System.out.println("2");
		while(rs.next()) {
			return "student";
		}
	}
	
	else {
		PreparedStatement ps=con.prepareStatement("select * from faculty where username=? and password=?");
		ps.setString(1,am.getUsername());
		ps.setString(2,am.getPassword());
		System.out.println(am.getUsername());
		System.out.println(am.getPassword());
		

		
		ResultSet rs=ps.executeQuery();
		System.out.println("3");
		while(rs.next()) {
			return "faculty";
		}
	}

	}
	catch(Exception e){
		System.out.println(e);
	}
	
	return status;
	
	
}

}
