//this web service is called presently from mobile 
package de.vogella.jersey.first;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;
import java.text.ParseException;

@Path("/getInvoiceDetails")
public class getInvoiceDetails {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String makePlainTextGetGuestDetailsfromReserID(
			@QueryParam("reservation_id") int reservationid,
			@QueryParam("callback") String callback,
			@Context HttpServletResponse servletResponse) throws ParseException {
		
		System.out.println("inside getInvoice_WS");
		Connection conn = null;
		//String url = "jdbc:mysql://localhost:3306/demo_schema";
		String url = "jdbc:mysql://172.17.196.224:3307/hsp_schema";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "admn";
		String password = "admn";
		
		String mess = null;
		int roomno = 0;
		double amount=0.00;
		double total=0.00;
		String task="Getting invoice details from reservationID::";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println(conn);
			
			String query1="select * from hsp_schema.invoice_details where reservation_ID="+reservationid;
			
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
				
				mess="Reservation Id\t: 16030\nRoom No.\t: "+roomno+" \nAmount\t: "+amount+"\nTotal\t: "+total+"";
			}
			
			// return mess;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("reservation id="+reservationid);
		return mess;
	}
}
