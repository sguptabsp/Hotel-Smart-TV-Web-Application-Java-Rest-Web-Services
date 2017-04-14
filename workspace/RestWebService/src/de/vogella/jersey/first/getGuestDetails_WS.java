//added by bhargav on 12 sep as needed for calling from eCheckInApp
//http://localhost:8080/RestWebService/rest/getGuestDetails?reserID=16030

package de.vogella.jersey.first;

import java.util.Date;
import java.text.*;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;
import java.text.ParseException;

@Path("/getGuestDetails")
public class getGuestDetails_WS {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String makePlainTextGetGuestDetailsfromReserID(
			@QueryParam("reserID") int reserID,
			@Context HttpServletResponse servletResponse) throws ParseException {
		
		System.out.println("inside getGuestDetails_WS");
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
		String mess1 = null;
		String hotelname=null;
		String chkindate=null;
		String chkoutdate=null;
		int roomno = 0;
		String task="Getting room number from reservationID::";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to db=="+conn);
			
			String query1="select * from hsp_schema.guestreg_tbl where reservation_ID="+reserID;
			
			Statement stmt1 = conn.createStatement();
			ResultSet rs = stmt1.executeQuery(query1);
			
			while (rs.next()) {
				roomno = rs.getInt("guest_roomno");
				if(roomno==0)
				{
					mess="ReservationID not found";
					break;
				}
				hotelname = "My Hotel";
				chkindate=rs.getString("guest_chkindate");
				chkoutdate=rs.getString("guest_chkoutdate");
				
				/*String pattern="dd/MM/yyyy";
				SimpleDateFormat sdf=new SimpleDateFormat(pattern);
				chkindate=sdf.format(new Date());
				String t1=chkindate.substring(0, 2);
				int t2=Integer.parseInt(t1)+5;
				chkoutdate = t2+""+chkindate.substring(2);
				*/
				
				System.out.println("Chkindate="+chkindate+" Chkoutdate="+chkoutdate);
				//mess="Reservation Id: 1066606\nHotel Name     : Pleasant Hotel\nRoom No.         : "+roomno+"\nCheckIn Date   : "+chkindate+" \nCheckOut Date: "+chkoutdate;
				//mess="Reservation Id : 1066606\nHotel Name : Pleasant Hotel\nRoom No. : "+roomno+"\nCheckIn Date : "+chkindate+"\nCheckOut Date : "+chkoutdate;;
				mess="Reservation Id : 1066606\nHotel Name : Pleasant Hotel\nCheckIn Date : "+chkindate+"\nCheckOut Date : "+chkoutdate+"\nLocation : San Francisco, CA";
				System.out.println("message"+mess);
			}
			
			// return mess;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("reservation id="+reserID);
		return mess;
	}
}
