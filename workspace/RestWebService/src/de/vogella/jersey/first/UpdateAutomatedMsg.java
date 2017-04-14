package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

//Hanumath@20100903 Service for Update Automated Messages.
@Path("/updateAutomatedMsg")
public class UpdateAutomatedMsg {

	static Logger logger = Logger.getLogger(UpdateAutomatedMsg.class);

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAutomatedMessage(@QueryParam("msgId") String msgId)
			throws SQLException {

		Logger logger = Logger.getLogger(this.getClass());
		logger.info("Start of UpdateAutomatedMsg:: updateAutomatedMessage()");
		Connection con = null;
		PreparedStatement pstmt = null;
		String msgStatus = "FAILED";
		try {
			// Hanumath@20110103 DataBase connection Starts
			System.out.println("::CONNECTING................");
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hsp_schema";
			con = DriverManager.getConnection(url, "root", "root");
			System.out.println("::CONNECTED !!!");
			con.setAutoCommit(false);
			
			String updateQry = "update automatedmsg_tbl set msg_status=? where msg_id=? ";
			pstmt = con.prepareStatement(updateQry);

			pstmt.setString(1, "R");
			pstmt.setString(2, msgId);

			int count = pstmt.executeUpdate();
			System.out.println("count:- "+count);
			if (count == 1) {
				msgStatus = "SUCCESS";
				con.commit();
			}

			logger.info(":: msgStatus ::" + msgStatus);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			msgStatus = "INTERNAL_ERROR";
			throw e;
		} finally {
			con.close();
			logger.info("End of UpdateAutomatedMsg:: updateAutomatedMessage()");
			return msgStatus;
		}
	}
}