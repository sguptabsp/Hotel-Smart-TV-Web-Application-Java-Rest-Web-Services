//added by bhargav on 12 sep as needed for calling from eCheckInApp
//http://localhost:8080/RestWebService/rest/randomGenerator?reservationId=1066606&roomNo=101
package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/randomGenerator")
public class RandomGenerator {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String randomGenerator(@QueryParam("reservationId") String reservationId,
			@QueryParam("roomNo") String roomNo,
			@QueryParam("callback") String callback,
			@Context HttpServletResponse servletResponse) throws SQLException {
		String randomNo = "";
		Connection conn = null;
		PreparedStatement keySelectPStmt = null;
		PreparedStatement pstmt =null;
		PreparedStatement updatedPstmt =null;

		try {

			String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			int N = alphabet.length();
			Random r = new Random();

			for (int i = 0; i < 10; i++) {
				randomNo = randomNo	+ String.valueOf(alphabet.charAt(r.nextInt(N)));
			}

			System.out.println("::CONNECTING to db................");
			
			//if deployed on server
			
			String url = "jdbc:mysql://172.17.196.224:3307/hsp_schema";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password = "admn";
			
			
			//if deployed on hanumath's system/public DMZ domain
			
			/*
			String url = "jdbc:mysql://localhost:3306/hsp_schema";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password="root";
			*/
			
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to db=="+conn);
			conn.setAutoCommit(false);
			
			String selQry = "select count(*)  from roomkeydetails where reservationId=? and roomNo=? ";
			
			pstmt = conn.prepareStatement(selQry);
			pstmt.setString(1, reservationId);
			pstmt.setString(2, roomNo);
			
			ResultSet rs = pstmt.executeQuery();
			int totCnt=0;
			
			while (rs.next()) {
				totCnt = rs.getInt(1);
				System.out.println("totCnt:-"+totCnt);
			}
			if(totCnt==0){
				String insertkeyQry = "insert into roomkeydetails (roomkey, reservationId, roomNo, status) values(?,?,?,?)";

				keySelectPStmt = conn.prepareStatement(insertkeyQry);
				
				keySelectPStmt.setString(1, randomNo);
				keySelectPStmt.setString(2, reservationId);
				keySelectPStmt.setString(3, roomNo);
				keySelectPStmt.setString(4, "C");
				
				int insertkeyCnt = keySelectPStmt.executeUpdate();
				if(insertkeyCnt==0){
					System.out.println("Some Problem Occur in Data Base!!");
					randomNo ="0";
				}else{
					System.out.println("Data Inserted Successfully!!");
				}
				keySelectPStmt.close();
			}else{
				String updateQry = "update roomkeydetails set roomkey=? where reservationId=? and  roomNo=?";
				updatedPstmt = conn.prepareStatement(updateQry);
				updatedPstmt.setString(1, randomNo);
				updatedPstmt.setString(2, reservationId);
				updatedPstmt.setString(3, roomNo);
				int updatekeyCnt = updatedPstmt.executeUpdate();
				if(updatekeyCnt==0){
					System.out.println("Some Problem Occur in Data Base!!");
					randomNo ="0";
				}else{
					System.out.println("Data Updated Successfully!!");
				}
				updatedPstmt.close();
			}
			conn.commit();
					
		} catch (Exception e) {
			System.out.println("Exception:-" + e);
			conn.rollback();
			randomNo ="0";
		} finally {
			conn.close();			
			pstmt.close();
		}
		return randomNo;
	}
}