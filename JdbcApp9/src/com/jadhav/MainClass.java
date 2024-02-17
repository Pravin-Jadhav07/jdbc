package com.jadhav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtil.getConnection();
			
			// create statement
			String sql = "SELECT id,name,email,age,city FROM STUDENTS WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1);
						
			// execute query
			rs = pstmt.executeQuery();
			
			// process result
			if( rs.next() ) {
				System.out.println( rs.getInt(1) + " " 
						+ rs.getString(2) + " "
						+ rs.getString(3) + " "
						+ rs.getInt(4) + " "
						+ rs.getString(5)
					);
			}
			else {
				System.out.println("No date to display for given id.");
			}
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// close resources
			try {
				JdbcUtil.closeConnection(pstmt, con, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("your job is done...");
	}
}
