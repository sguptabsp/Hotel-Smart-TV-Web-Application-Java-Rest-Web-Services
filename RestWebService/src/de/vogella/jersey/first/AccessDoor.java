//http://121.242.10.9:8080/RestWebService/rest/opentheDoor?status=open&pointname=EML_DEMO&flag=1
package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Hanumath@20100903 Service for Displaying Messages 
@Path("/opentheDoor")
public class AccessDoor {

	static Logger logger = Logger.getLogger("A");

	@SuppressWarnings("finally")
	@GET
	@Produces( { MediaType.TEXT_PLAIN })
	public String updateFlag(@QueryParam("status") String status, 
			@QueryParam("pointname") String pointname,
			@QueryParam("flag") String flag)	throws SQLException {

		logger.info(":: Start of AccessDoor Display Class :: updateFlag()");
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuffer automatedMsg = new StringBuffer();
		try {
			/**/
            int num=Integer.parseInt(flag);
 			System.out.println("::CONNECTING................");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://172.17.196.224:1433;databaseName=PointControl"; 
             
			//String url = "jdbc:microsoft:sqlserver:@172.17.196.224:1433;DatabaseName=CMS";
			con = DriverManager.getConnection(url, "sa", "sa");
			System.out.println("::CONNECTED !!!");
        
			//String selQry = "select Status,	Flag from tblpointstatus  ";
			//pstmt = con.prepareStatement(selQry);
            String updateQry = "update tblPointStatus set Status=? ,Flag=? where PointName=? ";
			pstmt = con.prepareStatement(updateQry);
            status=status.trim().toLowerCase();
            pointname=pointname.trim();
            pstmt.setString(1, status);
			pstmt.setInt(2, num);
			pstmt.setString(3, pointname);

			int count = pstmt.executeUpdate();
			System.out.println("count:- "+count);
			if (count == 1) {
				logger.info(":: SUCCESS ::"); 
				automatedMsg.append("SUCCESS");
				con.commit();
			}
			
		

			//ResultSet rs = pstmt.executeQuery();
			//while (rs.next()) {
				//count = rs.getString(1);
			//}
			logger.info(":: Count ::" + count);
		} catch (Exception e) {
			logger.info(":: Exception ::"+e);
			automatedMsg.append("INTERNAL ERROR");
		} finally {
			con.close();
			pstmt.close();
			logger.info(":: End of AccessDoor Display Class :: updateFlag()");
			return automatedMsg.toString();
		}
	}
}