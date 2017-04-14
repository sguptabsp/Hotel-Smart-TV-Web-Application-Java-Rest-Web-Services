package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

// POJO, no interface no extends

//Sets the path to base URL + /hello
@Path("/spaReservation")
public class spaResREST_Test {
	
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	/*public String sayPlainTextHello() {
		int i=0;
		return "Hello Jersey "+i;
	}
	*/
	
	//public String makeReservation(int spaID,int slot) {
	public String makePlainTextReservation(@QueryParam("roomId") int roomId,
			@QueryParam("guestName") String guestName,@QueryParam("spaId") int spaId,
			@QueryParam("timeSlot") int timeSlot, @QueryParam("spaDate") String spaDate,@Context HttpServletResponse servletResponse
) throws ParseException 
	{
		System.out.println("inside .............spaResREST_Test");
		String message="slot booking unsuccessful";
		
		/*
		 public String makeReservation(spaReservationClass sp) {
		String reserID=sp.getReservationID();
		int room_no = sp.getRoom_no();
		String gName = sp.getGuestName();
		int spID = sp.getSpaID();
		int timeSlot = sp.getTimeSlot();
		
		 */
		
		/*int room_no = 101;
		String gName = "bhargav";
		int spID = 6;
		int timeSlot = 1;*/
		
		/*
		 * SimpleDateFormat sdf =new SimpleDateFormat("yyyy-dd-mm"); Calendar c1
		 * = Calendar.getInstance(); // today String dt=
		 * sdf.format(c1.getTime());
		 */

		/*
		 * java.util.Date now = new java.util.Date(); SimpleDateFormat sdf = new
		 * SimpleDateFormat( "yyyy-mm-dd HH:mm:ss" ); String
		 * sdate=sdf.format(now).toString();
		 */
		/*java.util.Date d = new java.util.Date();
		java.sql.Date date = new java.sql.Date(d.getTime());*/

		
		Date date= converDate(spaDate);
		
		
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
		int numRowsChanged = 0,i=0;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			Statement st = conn.createStatement();
			
			
			//for updating in spa reservation schedule--------------------------------
			
			String query1="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"'";
			Statement stmt1 = conn.createStatement();
			ResultSet rs2 = stmt1.executeQuery(query1);
			int j = 0;
			while (rs2.next()) {	//j==1 enrty there for given spaID and date so just update row
				j = rs2.getInt(1); //j==0 no entry for given spaID and date so insert row
			}
			if(j==0)
			{
				//create spa schedule entry for a given spaID and date
				//String query3="insert into hsp_schema.spa_schedule(spaID,date) values ("+spaID+",'"+date+"')";
				String query3="";
				for(int k=1;k<=8;k++)
				{
					if(timeSlot==k)
					{
						query3="insert into hsp_schema.spa_schedule(spaID,date,slot"+k+") values ("+spaId+",'"+date+"','booked')";
					}
				}
				/*if(timeSlot==1)
				{
					query3="insert into hsp_schema.spa_schedule(spaID,date,slot1) values ("+spaId+",'"+date+"','booked')";
				}
				else if(timeSlot==2)
				{
					query3="insert into hsp_schema.spa_schedule(spaID,date,slot2) values ("+spaId+",'"+date+"','booked')";
				}
				else if(timeSlot==3)
				{
					query3="insert into hsp_schema.spa_schedule(spaID,date,slot3) values ("+spaId+",'"+date+"','booked')";
				}
				else if(timeSlot==4)
				{
					query3="insert into hsp_schema.spa_schedule(spaID,date,slot4) values ("+spaId+",'"+date+"','booked')";
				}
				else if(timeSlot==5)
				{
					query3="insert into hsp_schema.spa_schedule(spaID,date,slot5) values ("+spaId+",'"+date+"','booked')";
				}
				else if(timeSlot==6)
				{
					query3="insert into hsp_schema.spa_schedule(spaID,date,slot6) values ("+spaId+",'"+date+"','booked')";
				}
				else if(timeSlot==7)
				{
					query3="insert into hsp_schema.spa_schedule(spaID,date,slot7) values ("+spaId+",'"+date+"','booked')";
				}
				else if(timeSlot==8)
				{
					query3="insert into hsp_schema.spa_schedule(spaID,date,slot8) values ("+spaId+",'"+date+"','booked')";
				}*/
				Statement stmt2=conn.createStatement();
				int changed=stmt2.executeUpdate(query3);
				if(changed==1)
				{
											
					//to get reserID
					String selectQuery = "select max(reservationID)+1 from hsp_schema.spaReservation";
					ResultSet rs = st.executeQuery(selectQuery);
					int reserID = 0;
					while (rs.next()) {
						reserID = rs.getInt(1);
					}
					
					//to make reservation entry
					
					
					
					
					String insertReserQuery = "insert into hsp_schema.spaReservation values("+ reserID+ ","+ roomId+ ",'"
							+ guestName+ "',"+ spaId+ ",'" + date + "'," + timeSlot + ")";

					i = st.executeUpdate(insertReserQuery);

					String insertAutoMsgQuery = "insert into demo_schema.warningMessage values (?,?,?,?,?,?,Now(),?,?)";
					String selectQuery1 = "select max(messageID)+1 from demo_schema.warningMessage";
					Statement stmt = conn.createStatement();
					ResultSet rs1 = stmt.executeQuery(selectQuery1);
					int messID = 0;
					while (rs1.next()) {
						messID = rs1.getInt(1);
					}

					PreparedStatement pst = conn.prepareStatement(insertAutoMsgQuery);
					pst.setInt(1, messID);
					pst.setString(2, "Spa Reservation message");
					pst.setString(3, "Reservation system");
					pst.setString(4, guestName);
					pst.setString(5, "Confirmed Reservation");
					String spaDetail="Spa Reservation Details--SpaID="+spaId+" time slot="+timeSlot+" GuestName="+guestName+" Room number="+roomId;
					System.out.println("spaDetail "+spaDetail);
					pst.setString(6, spaDetail);

					// pst.setString(7, Now()); //pst.setDate(7, date_time);

					pst.setInt(7, roomId);
					pst.setString(8, "n");
					System.out.println(pst + "   " + insertAutoMsgQuery);

					numRowsChanged = pst.executeUpdate();
					
					if(numRowsChanged==1)
					{
						System.out.println("slot booking successful");
						message="slot booking successful";
					}
				}
				else
				{
					System.out.println("slot booking unsuccessful");
					message="slot booking unsuccessful";
				}
			}
			else if(j==1) 
			{
				//check if time slot is free and then update;
				String query4="";
				for(int k=1;k<=8;k++)
				{
					if(timeSlot==k)
					{
						query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot"+k+"='booked'";
					}
				}
				/*
				if(timeSlot==1)
				
				{
					query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot1='booked'";
				}
				else if(timeSlot==2)
				{
					query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot2='booked'";
				}
				else if(timeSlot==3)
				{
					query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot3='booked'";
				}
				else if(timeSlot==4)
				{
					query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot4='booked'";
				}
				else if(timeSlot==5)
				{
					query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot5='booked'";
				}
				else if(timeSlot==6)
				{
					query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot6='booked'";
				}
				else if(timeSlot==7)
				{
					query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot7='booked'";
				}
				else if(timeSlot==8)
				{
					query4="select count(*) from hsp_schema.spa_schedule where spaID="+spaId+" && date='"+date+"' && slot8='booked'";
				}
				*/
				Statement stmt3 = conn.createStatement();
				ResultSet rs3 = stmt3.executeQuery(query4);
				int k = 0;
				while (rs3.next()) {
					k = rs3.getInt(1);
				}
				if(k==0) //slot is not yet booked
				{
					String query5="";
					for(k=1;k<=8;k++)
					{
						if(timeSlot==k)
						{
							query5="update hsp_schema.spa_schedule set slot"+k+"='booked' where spaID="+spaId+" && date='"+date+"'";
						}
					}
					/*
					if(timeSlot==1)
					{
						query5="update hsp_schema.spa_schedule set slot1='booked' where spaID="+spaId+" && date='"+date+"'";
					}
					if(timeSlot==2)
					{
						query5="update hsp_schema.spa_schedule set slot2='booked' where spaID="+spaId+" && date='"+date+"'";
					}
					if(timeSlot==3)
					{
						query5="update hsp_schema.spa_schedule set slot3='booked' where spaID="+spaId+" && date='"+date+"'";
					}
					if(timeSlot==4)
					{
						query5="update hsp_schema.spa_schedule set slot4='booked' where spaID="+spaId+" && date='"+date+"'";
					}
					if(timeSlot==5)
					{
						query5="update hsp_schema.spa_schedule set slot5='booked' where spaID="+spaId+" && date='"+date+"'";
					}
					if(timeSlot==6)
					{
						query5="update hsp_schema.spa_schedule set slot6='booked' where spaID="+spaId+" && date='"+date+"'";
					}
					if(timeSlot==7)
					{
						query5="update hsp_schema.spa_schedule set slot7='booked' where spaID="+spaId+" && date='"+date+"'";
					}
					if(timeSlot==8)
					{
						query5="update hsp_schema.spa_schedule set slot8='booked' where spaID="+spaId+" && date='"+date+"'";
					}
					*/
					Statement stmt4=conn.createStatement();
					int changed=0;
					changed=stmt4.executeUpdate(query5);
					if(changed==1)
					{
												
						//to get reserID
						String selectQuery = "select max(reservationID)+1 from hsp_schema.spaReservation";
						ResultSet rs = st.executeQuery(selectQuery);
						int reserID = 0;
						while (rs.next()) {
							reserID = rs.getInt(1);
						}
						
						//to make reservation entry
						
						
						
						
						String insertReserQuery = "insert into hsp_schema.spaReservation values("+ reserID+ ","+ roomId+ ",'"
								+ guestName+ "',"+ spaId+ ",'" + date + "'," + timeSlot + ")";

						i = st.executeUpdate(insertReserQuery);

						String insertAutoMsgQuery = "insert into demo_schema.warningMessage values (?,?,?,?,?,?,Now(),?,?)";
						String selectQuery1 = "select max(messageID)+1 from demo_schema.warningMessage";
						Statement stmt = conn.createStatement();
						ResultSet rs1 = stmt.executeQuery(selectQuery1);
						int messID = 0;
						while (rs1.next()) {
							messID = rs1.getInt(1);
						}

						PreparedStatement pst = conn.prepareStatement(insertAutoMsgQuery);
						pst.setInt(1, messID);
						pst.setString(2, "call message");
						pst.setString(3, "Reservation system");
						pst.setString(4, guestName);
						pst.setString(5, "Confirmed Reservation");
						pst.setString(6, "SPA details::");

						// pst.setString(7, Now()); //pst.setDate(7, date_time);

						pst.setInt(7, roomId);
						pst.setString(8, "n");
						System.out.println(pst + "   " + insertAutoMsgQuery);

						numRowsChanged = pst.executeUpdate();
						
						if(numRowsChanged==1)
						{
							System.out.println("slot booking successful");
							message="slot booking successful";
						}
					}
					else
					{
						System.out.println("slot booking unsuccessful");
						message="slot booking unsuccessful";
					}
				}
				else  //slot is already booked
				{
					System.out.println("slot is already booked");
					message="slot is already booked";
				}
			}
			else
			{
				System.out.println("Error in spa schedule");
				message="Error in spa schedule";
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return message;

	}
	
	public Date converDate(String date) throws ParseException{
		String dd=new String();
		String mm=new String();
		String yyyy=new String();
		int i=date.length();
		int j=0;
		for(;;)
		{
			while(date.charAt(j)!='/')
			{
			dd+=date.charAt(j);
			j++;
			System.out.println(dd);
			}
			j++;
			while(date.charAt(j)!='/')
			{
			mm+=date.charAt(j);
			j++;
			System.out.println(mm);
			}
			j++;
			while(j!=date.length())
			{
			yyyy+=date.charAt(j);
			j++;
			System.out.println(yyyy);
			}
			break;
		}
		String dateFrmt=yyyy+"-"+mm+"-"+dd;
		System.out.println(dateFrmt);
				
		SimpleDateFormat sdfInput =  new SimpleDateFormat (  "yyyy-MM-dd"  ) ; 

	    java.util.Date date123 = (java.util.Date) sdfInput.parse(dateFrmt) ;  
	    System.out.println("date="+date123);

		java.sql.Date da = new java.sql.Date(date123.getTime());
		System.out.println("hello:::::::"+da);
		return da;
	}

}
