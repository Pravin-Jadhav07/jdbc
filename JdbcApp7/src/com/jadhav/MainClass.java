package com.jadhav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = JdbcUtil.getConnection();
			
			// create statement
			String sql = "INSERT INTO STUDENTS (name, email, age, city) VALUES (?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, "rushi");
			preparedStatement.setString(2, "r@j.com");
			preparedStatement.setInt(3, 24);
			preparedStatement.setString(4, "Latur");
					
			//execute query
			int rowAffected  = preparedStatement.executeUpdate();
			
			//process result
			if( rowAffected !=0 )
				System.out.println("Data inserted successfully.");
			else
				System.out.println("something went wrong.");
			
			JdbcUtil.closeConnection(preparedStatement, connection);
			
		} catch (SQLException e) {
			System.out.println("sqlex.. start");
			e.printStackTrace();
			System.out.println("sqlex.. end");
		} 
		catch(Exception e) {	
			System.out.println("pex.. start");
			e.printStackTrace();
			System.out.println("pex..  end");
		}
	
		
		System.out.println("donee..");

	}
}
