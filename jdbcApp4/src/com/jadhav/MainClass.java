package com.jadhav;

import java.sql.Connection;
import java.sql.DriverManager;
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
		String sql = "DELETE FROM STUDENTS WHERE id=3";
		int rowsAffected = statement.executeUpdate(sql);
		
		//process result
		if( rowsAffected != 0 )
			System.out.println("Data DELETED successfully.");
		else
			System.out.println("Something went wrong.");
		
		
		
		//close resource
		statement.close();
		connection.close(); 	
		System.out.println("okk");
	}

}
