package com.jadhav;

// importing packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Establish connection
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "Pravin@123";
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// creating statement
		Statement statement = connection.createStatement();
		
		
		//execute query
		String sql = "SELECT * FROM STUDENTS";
		ResultSet resultSet = statement.executeQuery(sql);
		
		//process result
		while( resultSet.next() ) {
//			int id = resultSet.getInt(1); // storing into var
			
			//  using column index
//			System.out.println(   resultSet.getInt(1) + " " 
//								+ resultSet.getString(2) + " "
//								+ resultSet.getString(3) + " " 
//								+  resultSet.getInt(4) + " "
//								+  resultSet.getString(5)  
//							);
			
			// using column name
			System.out.println(   resultSet.getInt("id") + " " 
								+ resultSet.getString("name") + " "
								+ resultSet.getString("email") + " " 
								+  resultSet.getInt("age") + " "
								+  resultSet.getString("city")  
							);
			
			
		}
		
		//close resource
		statement.close();
		connection.close(); 	
		System.out.println("okk");
		

	}

}
