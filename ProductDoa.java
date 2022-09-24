package jdbc.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDoa {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	Connection connection = null;
	
	
	public Product saveProduct(Product p) {
		String query = "Insert into product values(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,p.getId());
			ps.setString(2,p.getProductname());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getManufacturer());
			ps.setDouble(5, p.getDiscount());
			ps.setInt(6, p.getWaranty());
			ps.setString(7, p.getDate());
			ps.setDouble(8, p.getGst());
			ps.execute();
			

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
		return p;

	
		
		
	}
	public Product updateProduct(Product p) {
		String query="UPDATE product SET productname = ?, price = ?, manufacturer = ?, discount = ?, warranty = ?, date = ? ,gst=? WHERE id=?";
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(8,p.getId());
			ps.setString(1,p.getProductname());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getManufacturer());
			ps.setDouble(4, p.getDiscount());
			ps.setInt(5, p.getWaranty());
			ps.setString(6, p.getDate());
			ps.setDouble(7, p.getGst());
			ps.execute();
			

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
		return p;

	
		
		
	}
	public String deleteProduct(int id) {
		
		String delete="Delete from product where id=?";
		
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
	public Product getProduct(int id) {
		String selectQuery="select *  from product where id=?";
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ps.setInt(1, id);
			
			Product	p1=new Product();
			ResultSet rs=ps.executeQuery();
		
			 
			while(rs.next()) {
				
				p1.setId(rs.getInt(1));
				p1.setProductname(rs.getString(2));
				p1.setPrice(rs.getDouble(3));
				p1.setManufacturer(rs.getString(4));
				p1.setDiscount(rs.getDouble(5));
				p1.setWaranty(rs.getInt(6));
				p1.setDate(rs.getString(7));
				p1.setGst(rs.getDouble(8));
				
				
			}
			return p1;
					

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
	
	public List<Product> getProductAll() {
		String selectQuery="select *  from product";
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			
			
			Product	p1=new Product();
			ResultSet rs=ps.executeQuery();
			List<Product> list=new ArrayList();
		
			 
			while(rs.next()) {
				
				p1.setId(rs.getInt(1));
				p1.setProductname(rs.getString(2));
				p1.setPrice(rs.getDouble(3));
				p1.setManufacturer(rs.getString(4));
				p1.setDiscount(rs.getDouble(5));
				p1.setWaranty(rs.getInt(6));
				p1.setDate(rs.getString(7));
				p1.setGst(rs.getDouble(8));
				list.add(p1);
				
				
			}
			return list;
					

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
	
	

