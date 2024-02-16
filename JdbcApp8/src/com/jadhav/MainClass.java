package com.jadhav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = JdbcUtil.getConnection();
			
			// create statement
			// 1. Update record
//			String sql = "UPDATE STUDENTS SET age=? WHERE id=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, 32);
//			pstmt.setInt(2, 8);
			
			
			// 2. Delete record
			String sql = "DELETE FROM STUDENTS WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 8);
			
			// execute statement
			int rowAffected = pstmt.executeUpdate();
			
			// process result
			if( rowAffected != 0 )
				System.out.println("Success...");
			else
				System.out.println("Failed...");
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.closeConnection(pstmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
		
		System.out.println("your job is done...");
	}

}
