
package de.vogella.jersey.first;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.text.ParseException;

@Path("/getInvoiceJson")
public class getInvoice_Jsn {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String makePlainTextGetGuestDetailsfromReserID(
			@QueryParam("reserID") int reserID,
			@QueryParam("callback") String callback,
			@Context HttpServletResponse servletResponse) throws ParseException {
		
		System.out.println("inside getInvoice_Jsn");
		System.out.println("reserID" + reserID);
		Connection conn = null;
		String url = "jdbc:mysql://172.17.196.224:3307/hsp_schema";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "admn";
		String password = "admn";
		
		String mess = null;
		int roomno = 0;
		double amount=0.00;
		double total=0.00;
		String task="Getting invoice details from reservationID::";
		JSONObject arrayObj = new JSONObject();
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to db=="+conn);
			
			String query1="select * from hsp_schema.invoice_details where reservation_id="+reserID;
			
			Statement stmt1 = conn.createStatement();
			ResultSet rs = stmt1.executeQuery(query1);
			
			while (rs.next()) {
				roomno = rs.getInt("roomno");
				amount=rs.getDouble("amount");
				total=rs.getDouble("total");
				if(roomno==0)
				{
					mess="ReservationID not found";
					break;
				}
				arrayObj.put("Roomno", roomno);
				arrayObj.put("Amount",amount);
				arrayObj.put("Total", total);
				arrayObj.put("ReservationID", reserID);
				System.out.println("message"+arrayObj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("reservation id="+reserID);
		return arrayObj.toString();
	}
}
