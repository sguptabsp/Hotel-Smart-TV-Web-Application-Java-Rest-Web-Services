package com.tcs.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {

	public static Connection createConnection()
	{
		Connection conn=null;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
				String dburl = "jdbc:oracle:thin:@//localhost:1521/XE";
				String dbusername = "system";
				String dbpassword = "a50core";
			
				// Get the Connection object from Driver Manager
				 conn = DriverManager.getConnection(dburl, dbusername, dbpassword);
				conn.setAutoCommit(false);
		
			   }
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(" Exception Occurred in testStatement ");
				try {
					conn.rollback();
				} catch (SQLException sqle) {
					System.out.println(" SQLException while roll back in testStatement ");
				}
				
			}
			return conn;
	}
	public static void CloseAll(Connection conn,PreparedStatement prepstmnt,ResultSet rs )
	{

		try {
			if(rs != null)
				rs.close();
			if(prepstmnt != null)
				prepstmnt.close();
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(
							" Exception while cleaning up resources in testPreparedStatement");
		}
		
	}
}
