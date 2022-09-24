package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Signup;

public class SignupDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";

	public Signup insertSignup(Signup s) {

		String query = "insert into signup values(?,?,?,?,?,?,?)";
		Connection con = null;
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s.getFirstname());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setLong(5, s.getPhone());
			ps.setString(6, s.getDob());
			ps.setString(7, s.getGender());
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;

	}

	public Signup updateSignup(Signup s) {

		String query = "update signup set lastname=?,email=?,password=?,phone=?,dob=?,gender=? where firstname=?";
		Connection con = null;
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(7, s.getFirstname());
			ps.setString(1, s.getLastname());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getPhone());
			ps.setString(5, s.getDob());
			ps.setString(6, s.getGender());
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;

	}

	public String deleteSignup(String name) {

		String query = "Delete from signup where firstname=?";
		Connection con = null;
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;

	}

	public Signup getSignup(String email, String password) {

		String query = "Select * from signup where email=? and password=? ";
		Connection con = null;
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, this.password);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Signup s = new Signup();
				s.setFirstname(rs.getString(1));
				s.setLastname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setPhone(rs.getLong(5));
				s.setDob(rs.getString(6));
				s.setGender(rs.getString(7));
				return s;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null)
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		}
		return null;

	}

	public List<Signup> getSignup() {

		String query = "Select * from signup ;";
		Connection con = null;
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			List<Signup> li = new ArrayList();

			while (rs.next()) {
				Signup s = new Signup();
				s.setFirstname(rs.getString(1));
				s.setLastname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setPhone(rs.getLong(5));
				s.setDob(rs.getString(6));
				s.setGender(rs.getString(7));
				li.add(s);
			}
			return li;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
