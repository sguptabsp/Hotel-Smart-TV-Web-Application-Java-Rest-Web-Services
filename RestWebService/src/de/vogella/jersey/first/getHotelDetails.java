
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

	@Path("/getHotelDetails")
	public class getHotelDetails {

		// This method is called if TEXT_PLAIN is request
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String makePlainTextGetGuestDetailsfromReserID(
				@QueryParam("sno") int sno,
				@Context HttpServletResponse servletResponse) throws ParseException {
			
			System.out.println("inside getHotelDetails");
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
		
			String roomno="",serialno="",hotelid="";
			String task="Getting room number and hotelid from SNO::";
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url, userName, password);
				System.out.println("Connected to db=="+conn);
				
				String query1="select * from hsp_schema.hoteldetails where sno="+sno;
				
				Statement stmt1 = conn.createStatement();
				ResultSet rs = stmt1.executeQuery(query1);
				
				while (rs.next()) {
					serialno = rs.getString("sno");
					roomno = rs.getString("roomno");
					hotelid = rs.getString("hotelid");
					if(serialno=="" ||serialno.equals(""))
					{
						mess="Unauthorized Box";
						break;
					}
					
					
					
					//System.out.println("Chkindate="+chkindate+" Chkoutdate="+chkoutdate);
					//mess="Reservation Id: 1066606\nHotel Name     : Pleasant Hotel\nRoom No.         : "+roomno+"\nCheckIn Date   : "+chkindate+" \nCheckOut Date: "+chkoutdate;
					//mess="Reservation Id : 1066606\nHotel Name : Pleasant Hotel\nRoom No. : "+roomno+"\nCheckIn Date : "+chkindate+"\nCheckOut Date : "+chkoutdate;;
					mess="serialno : "+serialno+"\nroomno : "+roomno+"\nhotelid :"+hotelid;
					System.out.println("message"+mess);
				}
				
				// return mess;
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("sno="+sno);
			return mess;
		}
	}


