package com.jadhav;

import java.sql.*;

public class MainClass {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
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
		String sql = "INSERT INTO students(name,email,age,city) VALUES('bhagwat','b@b.com',23,'pune')";
		int rowsAffected = statement.executeUpdate(sql);
		
		//process result
		if( rowsAffected != 0 )
			System.out.println("Data inserted successfully.");
		else
			System.out.println("Something went wrong.");
		
		//close resource
		statement.close();
		connection.close(); 	

	}

}
