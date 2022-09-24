package jdbc.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class DAO {

	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection connection = null;
	String query = "Insert into person values(?,?,?,?,?)";
	String updateQuery="update person set name=?,adress=?,phone=?,pincode=? where id=?";
	String delete="Delete from person where id=?";
	String selectQuery="select * from person where id=?";
	ResultSet rs=null;

	public String savePerson(int id, String name, String adress, long phone, int pincode) {
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, adress);
			ps.setLong(4, phone);
			ps.setInt(5, pincode);
			int a = ps.executeUpdate();
			if (a == 1) {
				return "Saved";

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

		}
		return "Not saved";

	}
	public String updatePerson(int id, String name, String adress, long phone, int pincode) {
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setInt(5, id);
			ps.setString(1, name);
			ps.setString(2, adress);
			ps.setLong(3, phone);
			ps.setInt(4, pincode);
			int a = ps.executeUpdate();
			if (a == 1) {
				return "updated";

			}

		} catch (ClassNotFoundException e) {

			
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

		}
		return "Not updated";

	}
	public String DeletePerson(int id) {
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(delete);
			ps.setInt(1, id);
			
			int a = ps.executeUpdate();
			if (a == 1) {
				return "deleted";

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

		}
		return "Not deleted";

	}
	public String selectPerson(int id) {
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ps.setInt(1, id);
			
		rs=ps.executeQuery();  
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getLong(4));
				System.out.println(rs.getInt(5));
				
			}
				

			

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

		}
		return "" + rs;

	}
	
	
	

}
