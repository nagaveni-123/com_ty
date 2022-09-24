package com.ty.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Cart;



public class CartDAO {
	
	public Cart cartInsert(Cart c) {
		
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		try {
			String query = "Insert into cart values(?,?,?,?,?)";
			Class.forName(path);
			 con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getUsername());
			ps.setString(5,c.getAddress());
			ps.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	public Cart updateCart(Cart c) {
		
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		try {
			String query = "update Cart set email=?,password=?,username=?,address=? where id=? ";
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(5, c.getId());
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getUsername());
			ps.setString(4,c.getAddress());
			ps.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return c;
		
	}
	public Cart getCart(int id) {
		
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection connection = null;
		String selectQuery="select * from mobile where id=?";
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=connection.prepareStatement(selectQuery);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			Cart c=new Cart();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setEmail(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setUsername(rs.getString(4));
				c.setAddress(rs.getString(5));
				
			}
			return c;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public List<com.ty.dto.Cart> getCartAll() {
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection connection = null;
		
		String selectQuery="select * from cart";
		try {
			Class.forName(path);
			
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			
			
			Cart	c1=new Cart();
			ResultSet rs=ps.executeQuery();
			List<Cart> list=new ArrayList();
		
			 
			while(rs.next()) {
				c1.setId(rs.getInt(1));
				c1.setEmail(rs.getString(2));
				c1.setPassword(rs.getString(3));
				c1.setUsername(rs.getString(4));
				c1.setAddress(rs.getString(5));
				list.add(c1);
		
		
		}
			return list;

}
		catch (ClassNotFoundException e) {

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
	public String DeleteCart(int id) {
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query="Delete from cart where id=?";
		
		try {
			Class.forName(path);
			 con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			int a=ps.executeUpdate();
			if(a==1) {
				return "Deleted";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "Not deleted";
		
	}
}
