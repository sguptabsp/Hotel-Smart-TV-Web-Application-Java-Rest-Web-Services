package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import de.vogella.jersey.first.vo.AutomatedMsgVO;

//Hanumath@20100903 Service for Displaying Messages 
@Path("/automatedMsgDisp")
public class AutomatedMessages {

	static Logger logger = Logger.getLogger(AutomatedMessages.class);

	@GET
	@Produces( { MediaType.TEXT_PLAIN })
	public ArrayList<AutomatedMsgVO> getAutomatedMessageDisp(@QueryParam("roomId") String roomId)	throws SQLException {

		Logger logger = Logger.getLogger(this.getClass());
		logger.info(":: Start of AutomatedMessages Display Class :: getAutomatedMessageDisp()");
		Connection con = null;
		PreparedStatement pstmt = null;

		ArrayList<AutomatedMsgVO> automatedArl = new ArrayList<AutomatedMsgVO>(); 
		AutomatedMsgVO automatedMsgVO = null;
		try {
			// Hanumath@20110103 DataBase connection Starts
			System.out.println("::CONNECTING................");
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://172.17.199.87:3306/hsp_schema";
			con = DriverManager.getConnection(url, "root", "root");
			System.out.println("::CONNECTED !!!");

			String selQry = "select MSG_ID,	MSG_SUBJECT, MSG_SUBTYPE, MSG_FROM,	MSG_DATETIME, MSG_ROOMNO, MSG_GUESTNAME, MSG_MESSAGES, MSG_STATUS " +
					" from automatedmsg_tbl where msg_roomno in(?,?) ";
			pstmt = con.prepareStatement(selQry);

			pstmt.setString(1, roomId);
			pstmt.setString(2, "000");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				automatedMsgVO = new AutomatedMsgVO();
				automatedMsgVO.setMsg_id(rs.getInt(1));
				automatedMsgVO.setMsg_subject(rs.getString(2));
				automatedMsgVO.setMsg_subtype(rs.getString(3));
				automatedMsgVO.setMsg_from(rs.getString(4));
				automatedMsgVO.setMsg_datetime(rs.getString(5));
				automatedMsgVO.setMsg_roomno(rs.getString(6));
				automatedMsgVO.setMsg_guestname(rs.getString(7));
				automatedMsgVO.setMsg_messages(rs.getString(8));
				automatedMsgVO.setMsg_status(rs.getString(9));
				automatedArl.add(automatedMsgVO);
			}

			logger.info(":: Automated Arl Size ::" + automatedArl.size());

		} catch (Exception e) {
			logger.info(":: Exception ::"+e);
			automatedArl = null;
		} finally {
			con.close();
			pstmt.close();
			logger.info(":: End of AutomatedMessages Display Class :: getAutomatedMessageDisp()");
			return automatedArl;
		}
	}
}