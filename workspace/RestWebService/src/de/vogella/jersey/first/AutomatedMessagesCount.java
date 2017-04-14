package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

//Hanumath@20100903 for Automated Message Count Service
@Path("/automatedMsgCnt")
public class AutomatedMessagesCount {

	static Logger logger = Logger.getLogger(AutomatedMessagesCount.class);

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAutomatedMessageCount(@QueryParam("roomId") String roomId)
			throws SQLException {

		Logger logger = Logger.getLogger(this.getClass());
		logger.info("Start AutomatedMessagesCount:: getAutomatedMessageCount()");
		Connection con = null;
		PreparedStatement pstmt = null;
		String count = null;
		try {
			// Hanumath@20110103 DataBase connection Starts
			System.out.println("::CONNECTING................");
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://172.17.199.87:3306/hsp_schema";
			con = DriverManager.getConnection(url, "root", "root");
			System.out.println("::CONNECTED !!!");
			
			String selQry = "select count(*) from automatedmsg_tbl where msg_roomno in(?,?) and msg_status=?";
			pstmt = con.prepareStatement(selQry);

			pstmt.setString(1, roomId);
			pstmt.setString(2, "000");
			pstmt.setString(3, "U");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getString(1);
			}

			logger.info(":: Count ::" + count);
			
		} catch (Exception e) {
			e.printStackTrace();
			count = "INTERNAL_ERROR";
			throw e;
		} finally {
			con.close();
			logger.info("End AutomatedMessagesCount:: getAutomatedMessageCount()");
			return count;
		}
	}
}