package de.vogella.jersey.first;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/makeSpaReservation")
public class MakeSpaReservation {

	static Logger logger = Logger.getLogger("AutomatedMessages");

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	// public String makeReservation(int spaID,int slot) {
	public String makeSpaReservation(@QueryParam("roomId") int roomId,
			@QueryParam("guestName") String guestName,
			@QueryParam("spaId") int spaId,
			@QueryParam("timeSlot") int timeSlot,
			@QueryParam("spaDate") String spaDate,
			@Context HttpServletResponse servletResponse)
			throws ParseException, SQLException {

		logger.info(":: Start of MakeSpaReservation :: makeSpaReservation()");
		String message = "Slot Booking Unsuccessful";

		Connection con = null;
		Statement cntStmt = null;
		Statement insertStmt = null;
		Statement resSelectStmt =null;
		Statement updatedStmt =null;
		Statement selStmt = null;
		
		try {
			// Hanumath@20110314 DataBase connection Starts
			System.out.println("::CONNECTING................");
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hsp_schema";
			con = DriverManager.getConnection(url, "root", "root");
			System.out.println("::CONNECTED !!!");

			resSelectStmt = con.createStatement();

			Date date = converDate(spaDate);

			con.setAutoCommit(false);
			
			
			//Start Of Count Spa Schedule
			
			String cntQry = "select count(*) from spa_schedule where spaID=" + spaId + " && date='" + date + "'";
			cntStmt = con.createStatement();
			ResultSet cntrs = cntStmt.executeQuery(cntQry);
			int j = 0;
			while (cntrs.next()) {    // j==1 entry there for given spaID and date so just update row
				j = cntrs.getInt(1);  // j==0 no entry for given spaID and date so insert row
			}
			//End Of Count Spa Schedule
			
			//Start of insert selected slot info into spa schedule table.
			if (j == 0) {
				// create spa schedule entry for a given spaID and date String
				String insertQry = "";
				if (timeSlot == 1) {
					insertQry = "insert into spa_schedule(spaID,date,slot1) values ("
							+ spaId + ",'" + date + "','booked')";
				} else if (timeSlot == 2) {
					insertQry = "insert into spa_schedule(spaID,date,slot2) values ("
							+ spaId + ",'" + date + "','booked')";
				} else if (timeSlot == 3) {
					insertQry = "insert into spa_schedule(spaID,date,slot3) values ("
							+ spaId + ",'" + date + "','booked')";
				} else if (timeSlot == 4) {
					insertQry = "insert into spa_schedule(spaID,date,slot4) values ("
							+ spaId + ",'" + date + "','booked')";
				} else if (timeSlot == 5) {
					insertQry = "insert into spa_schedule(spaID,date,slot5) values ("
							+ spaId + ",'" + date + "','booked')";
				} else if (timeSlot == 6) {
					insertQry = "insert into spa_schedule(spaID,date,slot6) values ("
							+ spaId + ",'" + date + "','booked')";
				} else if (timeSlot == 7) {
					insertQry = "insert into spa_schedule(spaID,date,slot7) values ("
							+ spaId + ",'" + date + "','booked')";
				} else if (timeSlot == 8) {
					insertQry = "insert into spa_schedule(spaID,date,slot8) values ("
							+ spaId + ",'" + date + "','booked')";
				}
				insertStmt = con.createStatement();
				int changed = insertStmt.executeUpdate(insertQry);
				if (changed == 1) {
					// to get reserID
					String selectQuery = "select max(reservationID)+1 from spaReservation";
					ResultSet rs = resSelectStmt.executeQuery(selectQuery);
					int reserID = 0;
					while (rs.next()) {
						reserID = rs.getInt(1);
					}

					// to make reservation entry
					String insertReserQuery = "insert into hsp_schema.spaReservation values("
							+ reserID + "," + roomId + ",'"	+ guestName	+ "'," + spaId + ",'" + date + "'," + timeSlot + ")";

					int insertResCnt = resSelectStmt.executeUpdate(insertReserQuery);
					
					String spaDetails = "<center><u>Spa Reservation Details</u></center> Guest Name:" + guestName
					+ " </br> Room Number:" + roomId + "</br> Spa Id:" + spaId + "</br> Time Slot:" + timeSlot ;
					
					
					int count = insertAutomatedmsg(con,"Spa Reservation message","sr","Staff", spaDate, roomId,guestName,spaDetails);

					if (count == 1 && insertResCnt==1) {
						System.out.println("Slot Booking Successful");
						message = "Slot Booking Successful";
					}
					insertStmt.close();
				} else {
					System.out.println("Slot Booking Unsuccessful");
					message = "Slot Booking Unsuccessful";
				}
			} else if (j == 1) {
				// check if time slot is free and then update;
				String query4 = "";
				if (timeSlot == 1) {
					query4 = "select count(*) from spa_schedule where spaID="
							+ spaId
							+ " && date='"
							+ date
							+ "' && slot1='booked'";
				} else if (timeSlot == 2) {
					query4 = "select count(*) from spa_schedule where spaID="
							+ spaId
							+ " && date='"
							+ date
							+ "' && slot2='booked'";
				} else if (timeSlot == 3) {
					query4 = "select count(*) from spa_schedule where spaID="
							+ spaId
							+ " && date='"
							+ date
							+ "' && slot3='booked'";
				} else if (timeSlot == 4) {
					query4 = "select count(*) from spa_schedule where spaID="
							+ spaId
							+ " && date='"
							+ date
							+ "' && slot4='booked'";
				} else if (timeSlot == 5) {
					query4 = "select count(*) from spa_schedule where spaID="
							+ spaId
							+ " && date='"
							+ date
							+ "' && slot5='booked'";
				} else if (timeSlot == 6) {
					query4 = "select count(*) from spa_schedule where spaID="
							+ spaId
							+ " && date='"
							+ date
							+ "' && slot6='booked'";
				} else if (timeSlot == 7) {
					query4 = "select count(*) from spa_schedule where spaID="
							+ spaId
							+ " && date='"
							+ date
							+ "' && slot7='booked'";
				} else if (timeSlot == 8) {
					query4 = "select count(*) from spa_schedule where spaID="
							+ spaId
							+ " && date='"
							+ date
							+ "' && slot8='booked'";
				}
				selStmt = con.createStatement();
				ResultSet rs3 = selStmt.executeQuery(query4);
				int k = 0;
				while (rs3.next()) {
					k = rs3.getInt(1);
				}
				if (k == 0) // slot is not yet booked
				{
					String query5 = "";
					if (timeSlot == 1) {
						query5 = "update spa_schedule set slot1='booked' where spaID="
								+ spaId + " && date='" + date + "'";
					}
					if (timeSlot == 2) {
						query5 = "update spa_schedule set slot2='booked' where spaID="
								+ spaId + " && date='" + date + "'";
					}
					if (timeSlot == 3) {
						query5 = "update spa_schedule set slot3='booked' where spaID="
								+ spaId + " && date='" + date + "'";
					}
					if (timeSlot == 4) {
						query5 = "update spa_schedule set slot4='booked' where spaID="
								+ spaId + " && date='" + date + "'";
					}
					if (timeSlot == 5) {
						query5 = "update spa_schedule set slot5='booked' where spaID="
								+ spaId + " && date='" + date + "'";
					}
					if (timeSlot == 6) {
						query5 = "update spa_schedule set slot6='booked' where spaID="
								+ spaId + " && date='" + date + "'";
					}
					if (timeSlot == 7) {
						query5 = "update spa_schedule set slot7='booked' where spaID="
								+ spaId + " && date='" + date + "'";
					}
					if (timeSlot == 8) {
						query5 = "update spa_schedule set slot8='booked' where spaID="
								+ spaId + " && date='" + date + "'";
					}
					 updatedStmt = con.createStatement();
					int changed = 0;
					changed = updatedStmt.executeUpdate(query5);
					if (changed == 1) {

						
						// to get reserID
						String selectQuery = "select max(reservationID)+1 from hsp_schema.spaReservation";
						ResultSet rs = resSelectStmt.executeQuery(selectQuery);
						int reserID = 0;
						while (rs.next()) {
							reserID = rs.getInt(1);
						}

						// to make reservation entry

						String insertReserQuery = "insert into hsp_schema.spaReservation values("
								+ reserID + "," + roomId + ",'"	+ guestName + "'," + spaId + ",'" + date + "',"	+ timeSlot + ")";

						int insertResCnt = resSelectStmt.executeUpdate(insertReserQuery);

						String spaDetails = "<center><u>Spa Reservation Details</u></center> Guest Name:" + guestName
						+ " </br> Room Number:" + roomId + "</br> Spa Id:" + spaId + "</br> Time Slot:" + timeSlot ;
						
						
						int count = insertAutomatedmsg(con,"Call message", "cm", "Staff", spaDate, roomId, guestName, spaDetails);
						
						if (count == 1 && insertResCnt==1) {
							System.out.println("Slot Booking Successful");
							message = "Slot Booking Successful";
						}
						updatedStmt.close();
						
					} else {
						System.out.println("Slot Booking Unsuccessful");
						message = "Slot Booking Unsuccessful";
					}
					selStmt.close();
				} else // slot is already booked
				{
					System.out.println("Slot is already booked");
					message = "Slot is already booked";
				}				
			} else {
				System.out.println("Error in spa schedule");
				message = "Error in spa schedule";
			}
			
			con.commit();
		} catch (Exception e) {
			logger.info(":: Exception ::" + e);
			message = "INTERNAL ERROR";
		} finally {
			con.close();
			cntStmt.close();	
			resSelectStmt.close();
			logger.info(":: End of SpaReservation Display Class :: getSpaDetails()");
			return message;
		}
	}

	public Date converDate(String date) throws ParseException {
		String dd = new String();
		String mm = new String();
		String yyyy = new String();
		int i = date.length();
		int j = 0;
		for (;;) {
			while (date.charAt(j) != '-') {
				dd += date.charAt(j);
				j++;
				//System.out.println(dd);
			}
			j++;
			while (date.charAt(j) != '-') {
				mm += date.charAt(j);
				j++;
				//System.out.println(mm);
			}
			j++;
			while (j != date.length()) {
				yyyy += date.charAt(j);
				j++;
				//System.out.println(yyyy);
			}
			break;
		}
		String dateFrmt = yyyy + "-" + mm + "-" + dd;
		System.out.println(dateFrmt);

		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");

		java.util.Date date123 = (java.util.Date) sdfInput.parse(dateFrmt);
		System.out.println("date=" + date123);

		java.sql.Date da = new java.sql.Date(date123.getTime());
		System.out.println("hello:::::::" + da);
		return da;
	}
	
	public int insertAutomatedmsg(Connection con, String msg_subject, String msg_subtype, String msg_from, String msg_datetime, int msg_roomno,
			String msg_guestname, String msg_messages){
		int count = 0;
		try {
			String query = "select ifNULL(max(MSG_ID),0)+1 from automatedmsg_tbl";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int msg_id = 0;
			while (rs.next()) {
				msg_id = rs.getInt(1);
			}
			rs.close();

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO automatedmsg_tbl (msg_id,msg_subject,msg_subtype,msg_from,msg_datetime,msg_roomno,msg_guestname,msg_messages,msg_status) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, msg_id);
			ps.setString(2, msg_subject);
			ps.setString(3, msg_subtype);
			ps.setString(4, msg_from);
			ps.setString(5, msg_datetime);
			ps.setString(6, String.valueOf(msg_roomno));
			ps.setString(7, msg_guestname);
			ps.setString(8, msg_messages);
			ps.setString(9, "U");
			count = ps.executeUpdate();
			con.commit();
			ps.close();
		} catch (Exception e) {
			logger.info(":: Exception ::" + e);
		}
		return count;
	}
}