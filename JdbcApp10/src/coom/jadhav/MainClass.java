package coom.jadhav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.getConnection();
			
//			String sql = "UPDATE STUDENTS SET age=? where city=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, 11);
//			pstmt.setString(2, "pune");
			
//			String sql = "DELETE FROM STUDENTS where city=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, "pune");
			
//			int rowAffected = pstmt.executeUpdate();
//			if( rowAffected != 0 )
//				System.out.println("Success...");
//			else
//				System.out.println("Failed...");
			
			// we update multiple records using id also for that use Batch 
			// using batch support non select opration.
			
			String sql = "UPDATE STUDENTS SET age=? where id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,20);
			pstmt.setInt(2, 7);
			pstmt.addBatch();
			
			pstmt.setInt(1,25);
			pstmt.setInt(2, 15);
			pstmt.addBatch();
			
			pstmt.setInt(1,22);
			pstmt.setInt(2, 17);
			pstmt.addBatch();
			
			pstmt.setInt(1,23);
			pstmt.setInt(2, 18);
			pstmt.addBatch();
			
			int arr[] = pstmt.executeBatch();
			for ( int i=0 ; i<arr.length ; i++ ) {
				System.out.println( i+1 +" -------------> " + arr[i]);
			}
			
			
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
