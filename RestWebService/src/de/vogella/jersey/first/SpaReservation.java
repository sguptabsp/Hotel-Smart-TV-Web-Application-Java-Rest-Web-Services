//http://localhost:8080/RestWebService/rest/getSpaIdDetails?callback=OnSuccess
package de.vogella.jersey.first;

import java.sql.*;
import java.text.ParseException;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import de.vogella.jersey.first.vo.SpaDetailsVo;
import net.sf.json.JSONArray;

@Path("/getSpaIdDetails")
public class SpaReservation {
	static Logger logger = Logger.getLogger("SpaReservation");

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSpaDetails(@QueryParam("callback") String callback,
			@Context HttpServletResponse servletResponse)
			throws ParseException, SQLException {
		logger.info(":: Start of SpaReservation Display Class :: getSpaDetails()");
		StringBuffer spaMsg = new StringBuffer();
		Connection conn = null;
		Statement stmt = null;
		JSONArray jsonArray = new JSONArray();
		try {
			System.out.println("::CONNECTING................");
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
			System.out.println("::CONNECTED !!!");

			String query = "select spaID, spaDetails, price, duration  from spadetails";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int totCnt = 0;
			while (rs.next()) {
				SpaDetailsVo spaDetailsVo = new SpaDetailsVo();
				spaDetailsVo.setSpaId(rs.getInt("spaID"));
				spaDetailsVo.setSpaDetails(rs.getString("spaDetails"));
				spaDetailsVo.setPrice(rs.getInt("price"));
				spaDetailsVo.setDuration(rs.getInt("duration"));
				jsonArray.add(spaDetailsVo);
				totCnt++;
			}
			//spaMsg.append(callback + " ({ totalCount: " + totCnt+ ", \"spaDetailsVO\":");
			spaMsg.append(jsonArray);
			//spaMsg.append("})");
			rs.close();
			logger.info("::spaMsg::" + spaMsg);

		} catch (Exception e) {
			logger.info(":: Exception ::" + e);
			spaMsg.append("INTERNAL ERROR");
		} finally {
			conn.close();
			stmt.close();
			logger.info(":: End of SpaReservation Display Class :: getSpaDetails()");
			return spaMsg.toString();
		}
	}
}