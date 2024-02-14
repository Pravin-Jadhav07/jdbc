package com.jadhav;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {

	public static void main(String[] args) {
		
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		
		
		try {
			// Establish connection
			connection = JdbcUtil.getConnection();
			
			// creating statement
			statement = connection.createStatement();
			
			
			//execute query
			String sql = "SELECT * FROM STUDENTS";
//			String sql = "INSERT INTO STUDENTS (name,email,age,city) VALUES ('bhagwat','b@b.com',21,'nagar') ";
//			String sql = "DELETE FROM STUDENTS WHERE id=6";
//			String sql = "UPDATE STUDENTS SET age=23 WHERE id=1";
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
			
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch( Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			//close resource
			try {
				JdbcUtil.closeConnection(connection, statement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
}
