package de.vogella.jersey.first;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.util.ServiceException;
import de.vogella.jersey.first.vo.ContactsVO;

//Hanumath@20110210 Service for Displaying Gmail Contact List
@Path("/contactDetails")
public class DisplayGmailContactDetails {

	static Logger logger = Logger.getLogger(DisplayGmailContactDetails.class);

	@GET
	@Produces( { MediaType.TEXT_PLAIN })
	public String getContactDetails(@QueryParam("username") String username,
			@QueryParam("password") String password, @QueryParam("callback") String callback,
			@Context HttpServletResponse servletResponse) throws SQLException {

		Logger logger = Logger.getLogger(this.getClass());
		logger.info(":: Start of Display Gmail Contact Details Class :: getContactDetails()");

		StringBuffer responseJSON = new StringBuffer();
		JSONArray arrayObj = new JSONArray();
		try {

			List<ContactsVO> Details = new ArrayList<ContactsVO>();
			List<String> GmailList = new ArrayList<String>();

			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String dateNow = formatter.format(currentDate.getTime());
			// System.out.println("DateNow is :=>  " + dateNow);

			ContactsService myService = new ContactsService("GmailAPI");

			myService.setUserCredentials(username, password);
			GmailList = printAllContacts(myService, username);
			// System.out.println("Before printAllContacts" +GmailList);
			Details = getGuestDetails();
			int count=0;
			int hoteldbsize = Details.size();
			for (int k = 0; k < hoteldbsize; k++) {
				for (int j = 0; j < GmailList.size(); j++) {
					if (GmailList.get(j).equalsIgnoreCase(
							Details.get(k).getEmail().trim())) {
						Date ChkoutDate = formatter.parse(Details.get(k).getChkOutDate());
						Date todaysDate = formatter.parse(dateNow);
						if (todaysDate.before(ChkoutDate)
								&& Details.get(k).getPermission().equalsIgnoreCase("Y")) {
							logger.info("Match :" + Details.get(k).getFirstName());
							logger.info("Match :" + Details.get(k).getRoomNo());

							arrayObj.add(Details.get(k));
							count++;
						} else {
							logger.info("Either the Checkoutdate is greater than todays or Guest Permission is N");
						}
					}
				}
			}
			responseJSON.append(""+ callback +" ({"+" totalCount: \""+count+"\",\"ContactDetails\": ");
			responseJSON.append(arrayObj);
			responseJSON.append("})");
		} catch (Exception e) {
			logger.info(":: Exception ::" + e);
			responseJSON.append("INTERNAL ERROR");
		} finally {
			logger.info(":: End of Display Gmail Contact Details Class :: getContactDetails()");
			return responseJSON.toString();
		}
	}

	public static List<String> printAllContacts(ContactsService myService,
			String username) throws ServiceException, IOException {
		logger.info(":: Inside printAllContacts ::");
		// Request the feed URL
		URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/"
				+ username + "@gmail.com/full");
		Query myQuery = new Query(feedUrl);
		myQuery.setMaxResults(1000);
		ContactFeed resultFeed = myService.query(myQuery, ContactFeed.class);
		List<String> emailList = new ArrayList<String>();
		for (int i = 0; i < resultFeed.getEntries().size(); i++) {
			ContactEntry entry = resultFeed.getEntries().get(i);
			for (Email email : entry.getEmailAddresses()) {
				emailList.add(email.getAddress());
				// System.out.print("\n");
			}
			String photoLink = entry.getContactPhotoLink().getHref();
		}
		return emailList;
	}

	public List<ContactsVO> getGuestDetails() {
		logger.info(":: Inside getGuestDetails ::");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ContactsVO> list = new ArrayList<ContactsVO>();
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database

			// Select the data from the database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsp_schema", "root", "root");
			System.out.println("after connection");
			conn.setAutoCommit(false);
			String query = "select GUEST_ID, GUEST_FNAME, GUEST_LNAME, GUEST_EMAIL, GUEST_ROOMNO, GUEST_CHKOUTDATE, GUEST_EXTN, GUEST_PERMISSION" +
					" from guestreg_tbl";
			
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				ContactsVO bean = new ContactsVO();
				bean.setGuestId(rs.getInt("GUEST_ID"));
				bean.setFirstName(rs.getString("GUEST_FNAME"));
				bean.setLastName(rs.getString("GUEST_LNAME"));
				bean.setEmail(rs.getString("GUEST_EMAIL"));				
				bean.setRoomNo(rs.getInt("GUEST_ROOMNO"));
				bean.setChkOutDate(rs.getString("GUEST_CHKOUTDATE"));
				bean.setExtn(rs.getInt("GUEST_EXTN"));
				bean.setPermission(rs.getString("GUEST_PERMISSION"));
				list.add(bean);
				// System.out.println("List :"+list);
			}
			logger.info(":: List ::" + list);
			rs.close();

			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
				logger.info(":: Exception ::" + e);
			} catch (SQLException e1) {

				logger.info(":: SQLException ::" + e1);
			}
		}
		return list;
	}
}