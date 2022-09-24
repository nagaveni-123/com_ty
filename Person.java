package jdbc.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
	private int id;
	private String name;
	private String adress;
	private long phone;
	private int pincode;
	
	Person(){}
	
	public Person(int id, String name, String adress, long phone, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
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

	public String savePerson(Person p) {
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getAdress());
			ps.setLong(4, p.getPhone());
			ps.setInt(5, p.getPincode());
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
	public String updatePerson(Person p) {
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setInt(5, p.getId());
			ps.setString(1, p.getName());
			ps.setString(2, p.getAdress());
			ps.setLong(3, p.getPhone());
			ps.setInt(4, p.getPincode());
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
		return "Not Updated";

	}
	public Person gettPerson(int id) {
		Person p=null;
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ps.setInt(1, id);
			
			
			p=new Person();
			rs=ps.executeQuery();  
			while(rs.next()) {
				
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAdress(rs.getString(3));
				p.setPhone(rs.getLong(4));
				p.setPincode(rs.getInt(5));
				
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
