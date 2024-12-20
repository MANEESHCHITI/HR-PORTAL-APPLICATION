package dov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.CourseModal;

public class CourseDov {

	public Connection driver() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		return con;
	}

	String status = "failure";

	public String insertData(CourseModal cm) {

		try {
			Connection con = driver();
			PreparedStatement ps = con.prepareStatement(
					"insert into course (Course_name,Course_fee,Course_duration,location)values(?,?,?,?)");
			ps.setString(1, cm.getCoursename());
			ps.setInt(2, cm.getFee());
			ps.setInt(3, cm.getDuration());
			ps.setString(4, cm.getLocation());
			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println("1 row inserted");
				status = "success";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}

	public List<CourseModal> selectAll() throws ClassNotFoundException, SQLException {
		
		List<CourseModal> ll=new ArrayList<>();
		Connection con=driver();
		
		PreparedStatement ps=con.prepareStatement("select * from course");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			int cid=rs.getInt(1);
			String cname=rs.getString(2);
			int cfee=rs.getInt(3);
			int cduration=rs.getInt(4);
			String clocation=rs.getString(5);
			
			CourseModal cm=new CourseModal(cid,cname,cfee,cduration,clocation);
			ll.add(cm);
			
			
			
		}
		return ll;
	}
	
	
}
