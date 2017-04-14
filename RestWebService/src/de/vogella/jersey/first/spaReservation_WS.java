
package de.vogella.jersey.first;

import java.sql.*;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

//import org.codehaus.jettison.json.JSONArray;

import net.sf.json.JSONArray;
@Path("/getSpaDetails")
public class spaReservation_WS {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String makePlainSpaDetailDisplay(
			@Context HttpServletResponse servletResponse) throws ParseException {
		System.out.println("inside spaReservation_WS");
		StringBuffer sb = new StringBuffer();
		//JSONArray arrayObj = new JSONArray();
		// System.out.println("inside spaDetail display");
		Connection conn = null;

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
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			Statement stmt = conn.createStatement();
			System.out.println("conn==" + conn);
			String query = "select * from hsp_schema.spadetails";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				sb.append(rs.getInt("spaID") + " " + rs.getString("spaDetails")
						+ " " + rs.getInt("price") + " "
						+ rs.getInt("duration") + " ");
			}
			/*String[] temp = sb.toString().split(" ");
			System.out.println("Temp==" + temp);
			for (int i = 0; i < temp.length; i++)
				System.out.println(temp[i]);
			*/
			//arrayObj.add(sb);
			// sb.append(arrayObj.toString());
			System.out.println("sb==" + sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
		//return arrayObj;
	}
}
