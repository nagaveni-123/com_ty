package com.ty.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ty.dto.Student;

public class StudentDOA {
	public Student insertStudent(Student s) {
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query="insert into student values(?,?,?,?,?)";
		try {
			Class.forName(path);
			 con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, s.getId());
			ps.setString(2,s.getName());
			ps.setLong(3,s.getPhone());
			ps.setString(4,s.getAddress());
			ps.setInt(5, s.getPincode());
			int a=ps.executeUpdate();
			if(a==1) {
				return s;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	public Student updateStudent(Student s) {
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection con = null;
		String query="Update student set name=?,phone=?,adress=?,pincode=? where id=?";
		try {
			Class.forName(path);
			con=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(5, s.getId());
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getAddress());
			ps.setInt(4, s.getPincode());
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

}
