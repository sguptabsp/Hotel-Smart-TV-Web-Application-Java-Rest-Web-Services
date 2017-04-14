//added by bhargav on 12 sep as needed for calling from eCheckInApp
//http://localhost:8080/RestWebService/rest/getRoomnoFromReserID?reserID=1
package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
//runs presently from mobile
//URL--http://localhost:8080/RestWebService/rest/getRoomnoFromReserID?reserID=1

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/getRoomnoFromReserID")
public class getRoomnum_WS {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String makePlainTextGetRoomNofromReserID(
			@QueryParam("reserID") int reserID,
			@Context HttpServletResponse servletResponse) throws ParseException {
		System.out.println("inside getRoomnum_WS");
		/*
		 * String gName = request.getParameter("gName"); int room_no =
		 * Integer.parseInt(request.getParameter("room_no")); int noOfPass =
		 * Integer.parseInt(request.getParameter("noOfPass")); String dest =
		 * request.getParameter("destination"); String date =
		 * request.getParameter("MyDate"); Date date1 = null;
		 */

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
		
		String mess = null;
		int roomno = 0;
		String task="Getting room number from reservationID::";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to db=="+conn);
			
			String query1="select * from hsp_schema.spareservation where reservationID="+reserID;
			
			Statement stmt1 = conn.createStatement();
			ResultSet rs = stmt1.executeQuery(query1);
			
			while (rs.next()) {
				roomno = rs.getInt("room_no");
				mess="Room number : "+roomno;
			}
			if(roomno==0)
			{
				mess="ReservationID not found";
			}
			// return mess;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("reservation id="+reserID);
		return mess;
	}
}
