package com.jadhav;

// importing packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		ResultSet resultSet = null;
		
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
//		String sql = "DELETE FROM STUDENTS WHERE id=6";
//		String sql = "UPDATE STUDENTS SET age=24 WHERE id=1";
		boolean status = statement.execute(sql);
		
		//process result
		if( status ) {
			// true => only select statement i.e. (ResultSet)
			resultSet = statement.getResultSet();
			while( resultSet.next() ) {
				System.out.println(
						 	resultSet.getInt(1) + " " 
							+ resultSet.getString(2) + " "
							+ resultSet.getString(3) + " " 
							+  resultSet.getInt(4) + " "
							+  resultSet.getString(5) 
						);
			}
			
			System.out.println("Data Fetched successfully.");
		}
		else {
			// false => for INSERT, UPDATE and DELETE
			
			int rowsAffected = statement.getUpdateCount();
			
			if( rowsAffected != 0 )
				System.out.println("Operation successfully.");
			else
				System.out.println("Something went wrong.");
		}
		
		
		//close resource
		if ( resultSet != null )
			resultSet.close();
		statement.close();
		connection.close(); 	
		System.out.println("okk");
	}
}
