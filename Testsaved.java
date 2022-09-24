package jdbc.maven;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Testsaved {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection connection = null;
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			CallableStatement call=connection.prepareCall("call save_stud(?,?,?,?,?)");
			call.setInt(1, 1);
			call.setString(2, "Mahesh");
			call.setLong(3, 9784561);
			call.setString(4,"Mangalore");
			call.setInt(5,57482);
			call.execute();
			System.out.println("Data saved!!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
