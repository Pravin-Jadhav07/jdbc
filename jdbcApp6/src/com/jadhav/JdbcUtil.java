package com.jadhav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	static {
		// Load and Register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		// Establish connection
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "Pravin@123";
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet ) throws SQLException {
		//close resource
		if( resultSet != null )
			resultSet.close();
		statement.close();
		connection.close();
	}
	
}
