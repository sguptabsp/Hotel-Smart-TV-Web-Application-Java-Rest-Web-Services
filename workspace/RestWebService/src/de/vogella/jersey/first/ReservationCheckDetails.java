package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/reservationCheck")
public class ReservationCheckDetails {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String randomGenerator(@QueryParam("roomkey") String roomkey,
			@Context HttpServletResponse servletResponse) throws SQLException {
		String status = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			System.out.println("::CONNECTING................");
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://172.17.196.224:3307/hsp_schema";
			con = DriverManager.getConnection(url, "admn", "admn");
			System.out.println("::CONNECTED !!!");

			String selQry = "select count(*)  from roomkeydetails where roomkey=? and status=? ";

			pstmt = con.prepareStatement(selQry);
			pstmt.setString(1, roomkey);
			pstmt.setString(2, "C");

			ResultSet rs = pstmt.executeQuery();
			int totCnt = 0;

			while (rs.next()) {
				totCnt = rs.getInt(1);
				System.out.println("totCnt:-" + totCnt);
			}
			if (totCnt == 1) {
				System.out.println("Reservation Status is Confirmed");
				status = "CONFIRMED";
			} else {
				System.out.println("Reservation Status is not Confirmed");
				status = "FAILURE";
			}
		} catch (Exception e) {
			System.out.println("Exception:-" + e);
			status = "FAILURE";
		} finally {
			con.close();
			pstmt.close();
		}
		return status;
	}
}