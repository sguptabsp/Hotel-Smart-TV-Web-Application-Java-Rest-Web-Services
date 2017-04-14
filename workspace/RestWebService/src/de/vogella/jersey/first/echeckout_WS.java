//added by bhargav on 21 sep as needed for calling from eCheckOutApp
//http://localhost:8080/RestWebService/rest/eCheckOut?reserID=1066606

package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/eCheckOut")
public class echeckout_WS {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String makePlainTexteCheckOutfromReserID(
			@QueryParam("reserID") int reserID,
			@Context HttpServletResponse servletResponse) throws ParseException {
		
		System.out.println("inside eCheckOut_WS");
		String mess=null;
		Connection conn = null;
		
		//for server
		String url = "jdbc:mysql://172.17.196.224:3307/hsp_schema";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "admn";
		
		//for hanumath's system
		/*
		String url = "jdbc:mysql://localhost:3306/hsp_schema";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password="root";
		*/
		
		try
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
		
			System.out.println("Connected to db=="+conn);
			String updateQuery="update hsp_schema.roomkeydetails set status='F' where reservationId="+reserID;
			Statement stmt1 = conn.createStatement();
			int rowsUpdated=stmt1.executeUpdate(updateQuery);
			if(rowsUpdated==1)
			{
				mess="Checkout successful";
				System.out.println("Room status updated to free");
			}
			else
			{
				mess="Checkout unsuccessful";
				System.out.println("Error in updating room status");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mess;
	}
}

