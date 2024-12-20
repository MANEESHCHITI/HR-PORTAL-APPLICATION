package dov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.FacultyModal;
import modal.StudentModal;

public class StudentDov {

	public Connection driver() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		return con;
	}

	String status = "failure";

	public String insertData(StudentModal sm) {
		try {
			Connection con = driver();
			PreparedStatement ps = con
					.prepareStatement("insert into student (username, password, First_name, Last_name, Mob_no,"
							+ " email_id, EngBranch, Yearofpass, course, college, gender )values(?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, sm.getUsername());
			ps.setString(2, sm.getPassword());
			ps.setString(3, sm.getFirstname());
			ps.setString(4, sm.getLastname());
			ps.setString(5, sm.getMobile());
			ps.setString(6, sm.getGmail());
			ps.setString(7, sm.getBranch());
			ps.setInt(8, sm.getYear());
			ps.setString(9, sm.getCourse());
			ps.setString(10, sm.getCollege());
			ps.setString(11, sm.getGender());

			int n = ps.executeUpdate();

			if (n > 0) {
				System.out.println(n + ": row inserted");
				status = "success";
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}

	public List<StudentModal> selectAll() {

		List<StudentModal> stddata = new ArrayList<>();
		try {
			Connection con = driver();
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int sid = rs.getInt(1);
				String tusername = rs.getString(2);
				String tpassword = rs.getString(3);
				String tfirstname = rs.getString(4);
				String tlastname = rs.getString(5);
				String tmobilenumber = rs.getString(6);
				String temailid = rs.getString(7);
				String tengbranch = rs.getString(8);
				int tyearofpass = rs.getInt(9);
				String tcourse = rs.getString(10);
				String tcollege = rs.getString(11);
				String tgender = rs.getString(12);

				StudentModal sm = new StudentModal(sid, tusername, tpassword, tfirstname, tlastname, tmobilenumber,
						temailid, tengbranch, tyearofpass, tcourse, tcollege, tgender);
				stddata.add(sm);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return stddata;
	}

	public List<StudentModal> selectByIdUpdate(StudentModal fm) {

		List<StudentModal> stddata = new ArrayList<>();
		Connection con;
		try {
			con = driver();
			PreparedStatement ps = con.prepareStatement("select * from student where std_id=?");
			ps.setInt(1, fm.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int sid = rs.getInt(1);
				String tusername = rs.getString(2);
				String tpassword = rs.getString(3);
				String tfirstname = rs.getString(4);
				String tlastname = rs.getString(5);
				String tmobilenumber = rs.getString(6);
				String temailid = rs.getString(7);
				String tengbranch = rs.getString(8);
				int tyearofpass = rs.getInt(9);
				String tcourse = rs.getString(10);
				String tcollege = rs.getString(11);
				String tgender = rs.getString(12);

				StudentModal sm = new StudentModal(sid, tusername, tpassword, tfirstname, tlastname, tmobilenumber,
						temailid, tengbranch, tyearofpass, tcourse, tcollege, tgender);
				stddata.add(sm);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		System.out.println("values set to model in dov");
		return stddata;

	}

	public boolean deleteRow(int id1) {
		
		boolean status=false;
		Connection con;
		try {
			con = driver();
			System.out.println("before delete");
			PreparedStatement ps=con.prepareStatement("delete from student where std_id=?");
			System.out.println("after delete");
			ps.setInt(1,id1);
			int n=ps.executeUpdate();
			if(n>0) {
				System.out.println("succesfully deleted");
				status=true;
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public boolean facultyUpdate(StudentModal fm) {

		boolean status=false;
		Connection con;
		
		try {
			con = driver();
			PreparedStatement ps=con.prepareStatement("update Student set First_name=?,Last_name=?,gender=?,Mob_no=?,email_id=?,Yearofpass=?,course=? where std_id=?");
			ps.setString(1, fm.getFirstname());
			ps.setString(2, fm.getLastname());
			ps.setString(3, fm.getGender());
			ps.setString(4, fm.getMobile());
			ps.setString(5, fm.getGmail());
			ps.setInt(6, fm.getYear());
			ps.setString(7, fm.getCourse());
			ps.setInt(8, fm.getId());
				int n =ps.executeUpdate();
				if(n>0) {
					System.out.println("updated succesfully");
					status=true;
					
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			System.out.println(status+"in dov");
		 return status;
	}

}
