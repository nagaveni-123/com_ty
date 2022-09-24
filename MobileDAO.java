package jdbc.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection connection = null;
	Mobile mo;
	
	String delete="Delete from person where id=?";
	String selectQuery="select * from mobile where id=?";
	ResultSet rs=null;

	public String mobileInsert(Mobile m) {
		String query = "Insert into mobile values(?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, m.getId());
			ps.setString(2, m.getName());
			ps.setString(3, m.getBrand());
			ps.setString(4, m.getColor());
			ps.setDouble(5, m.getPrice());
			ps.setInt(6, m.getRam());
			ps.setString(7, m.getManufacturer());
			
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
	
	public String updatePerson(Mobile m) {
		String updateQuery="update mobile set name=?,brand=?,color=?,price=?,ram=?,manufacturer=? where id=?";
	//	String query="UPDATE `jdbcprc`.`mobile` SET `name` = ?, `color` = ?, `price` = ?, `ram` = ? WHERE (`id` = ?)";
	String query="UPDATE `jdbcprc`.`mobile` SET `name` = ?, `brand` = ?, `color` = ?, `price` = ?, `ram` = ?, `manufacturer` = ? WHERE (`id` = ?)";

		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(7, m.getId());
			ps.setString(1, m.getName());
			ps.setString(2, m.getBrand());
			ps.setString(3,m.getColor());
			ps.setDouble(4, m.getPrice());
			ps.setInt(5, m.getRam());
			ps.setString(6, m.getManufacturer());
			
			int a = ps.executeUpdate();
			if (a == 1) {
				return "updated";

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				}

		}
		return "Not Updated";

	}
	public Mobile getMobile(int id) {
		
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ps.setInt(1, id);
			
			
		Mobile	p=new Mobile();
			rs=ps.executeQuery();  
			while(rs.next()) {
				
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setBrand(rs.getString(3));
				p.setColor(rs.getString(4));
				p.setPrice(rs.getDouble(5));
				p.setRam(rs.getInt(6));
				p.setManufacturer(rs.getString(7));
				
				return p;
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
		
		return null;
	}
	

}
