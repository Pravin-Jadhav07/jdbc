package com.jadhav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	// load and register Driver.
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		// Establish the connection
		public static Connection getConnection() throws SQLException {
			String sql = "jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String password = "Pravin@123";
			return DriverManager.getConnection(sql, user, password);
		}
		
		// close resources
		public static void closeConnection( Statement statement, Connection connection, ResultSet rs ) throws SQLException {
			if ( rs != null )
				rs.close();
			statement.close();
			connection.close();
		}
	
}
