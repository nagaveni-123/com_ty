package jdbc.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> li=new ArrayList();
		Person p=new Person(11,"Manju","Hyd",78451,5741);
		Person p2=new Person(12,"Manyuri","Hyd",1245,5741);
		Person p3=new Person(13,"Mkaruu","Hyd",3457,5741);
		Person p4=new Person(14,"Manju","Hyd",7456,5741);
		Person p5=new Person(15,"Manju","Hyd",2549,5741);
		li.add(p);
		li.add(p2);
		li.add(p3);
		li.add(p4);
		li.add(p5);
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String username = "root";
		String password = "root";
		Connection connection = null;
		String query = "Insert into person values(?,?,?,?,?)";
		
		try {
			//Person person=new Person();
			Class.forName(path);
			connection=DriverManager.getConnection(url,username,password);
			PreparedStatement ps=connection.prepareStatement(query);
			for(Person per:li) {
				ps.setInt(1,per.getId());
				ps.setString(2, per.getName());
				ps.setString(3, per.getAdress());
				ps.setLong(4,per.getPhone());
				ps.setInt(5,per.getPincode());
				ps.addBatch();
			}
			ps.executeBatch();
			System.out.println(li);
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}	
			
			
}


