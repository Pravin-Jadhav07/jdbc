package com.jadhav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	static {
		// load and register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// establish the connection
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "Pravin@123";
		return DriverManager.getConnection(url, user, password);	
	}
	
	// close resources
	public static void closeConnection( Statement statement,Connection connection ) throws SQLException {
		statement.close();
		connection.close();
	}

}
