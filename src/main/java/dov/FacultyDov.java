package dov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.FacultyModal;

public class FacultyDov {

	public Connection driver() throws ClassNotFoundException, SQLException {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	
	return con;
	}
	
	
	/*
	 * insertData(); insert all values into table
	 */	
	
	
	public String insertData(FacultyModal fm) {
		String status="failure";
		try {
			Connection con=driver();
			PreparedStatement ps=con.prepareStatement("insert into faculty(First_name,Last_name,Mo_no,email_id,"
					+ "yrsofexp,courses,username,password,gender)values(?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, fm.getFirstname());
			ps.setString(2, fm.getLastname());
			ps.setLong(3, fm.getMobile());
			ps.setString(4, fm.getMail());
			ps.setInt(5, fm.getYear());
			ps.setString(6, fm.getCourse());
			ps.setString(7, fm.getUsername());
			ps.setString(8, fm.getPassword());
			ps.setString(9, fm.getGender());
			int n=ps.executeUpdate();
			
			if(n>0) {
				System.out.println(n+" : rows inserted");
				status="success";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return status;
		
	}
	
	
	
	/*
	 * selectAll() means selectAll rows from table
	 */	
	
	public List<FacultyModal> selectAll() {
		
		List<FacultyModal> facdata=new ArrayList<>();
		
		try {
			Connection con=driver();
			PreparedStatement ps=con.prepareStatement("select * from faculty");
			ResultSet rs=ps.executeQuery();
			
					
			while(rs.next()) {
					
				int tid=rs.getInt(1);
				String tfirstname=rs.getString(2);			
				String tlastname=rs.getString(3);	
				String tgender=rs.getString(10);
				long tmobile=rs.getLong(4); 
				String tmail=rs.getString(5);
				int tyear=rs.getInt(6);
				String tcourse=rs.getString(7);
				
				FacultyModal ftm=new FacultyModal(tid,tfirstname,tlastname,tgender,tmobile,tmail,tyear,tcourse);
				facdata.add(ftm);
	
			}
			
		}
		catch(Exception e) {
		}
		return facdata;

	}


	public List<FacultyModal> selectByIdUpdate(FacultyModal fm) throws ClassNotFoundException, SQLException {
		
		List<FacultyModal> facdata=new ArrayList<>();
		Connection con=driver();
		PreparedStatement ps=con.prepareStatement("select * from faculty where faculty_id=?");
		ps.setInt(1,fm.getId());
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
		int tid=rs.getInt(1);
		String tfirstname=rs.getString(2);			
		String tlastname=rs.getString(3);	
		String tgender=rs.getString(10);
		long tmobile=rs.getLong(4); 
		String tmail=rs.getString(5);
		int tyear=rs.getInt(6);
		String tcourse=rs.getString(7);
		
		FacultyModal ftm=new FacultyModal(tid,tfirstname,tlastname,tgender,tmobile,tmail,tyear,tcourse);
		facdata.add(ftm);
	

	}
		System.out.println("values set to model in dov");
		return facdata;
		
		
	}


	public boolean facultyUpdate(FacultyModal fm) throws ClassNotFoundException, SQLException {
		
		boolean status=false;
		Connection con=driver();
		PreparedStatement ps=con.prepareStatement("update faculty set First_name=?,Last_name=?,gender=?,Mo_no=?,email_id=?,yrsofexp=?,courses=? where faculty_id=?");
		ps.setString(1, fm.getFirstname());
		ps.setString(2, fm.getLastname());
		ps.setString(3, fm.getGender());
		ps.setLong(4, fm.getMobile());
		ps.setString(5, fm.getMail());
		ps.setInt(6, fm.getYear());
		ps.setString(7, fm.getCourse());
		ps.setInt(8, fm.getId());
			int n =ps.executeUpdate();
			if(n>0) {
				System.out.println("updated succesfully");
				status=true;
				
			}
			System.out.println(status+"in dov");
		 return status;
		 
	}


	public boolean deleteRow(int id) throws ClassNotFoundException, SQLException {

		boolean status=false;
		Connection con=driver();
		PreparedStatement ps=con.prepareStatement("delete from faculty where faculty_id=?");
		ps.setInt(1,id);
		int n=ps.executeUpdate();
		if(n>0) {
			System.out.println("succesfully deleted");
			status=true;
		}
		return status;
		
	}
	



	
	
	

	
	
	
}
