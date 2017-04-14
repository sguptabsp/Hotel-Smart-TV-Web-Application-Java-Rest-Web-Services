package de.vogella.jersey.first;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
//Hanumath@20100903 Service for Displaying Messages 
@Path("/DoorOpen")

public class CallWebservice {
	
	

		static Logger logger = Logger.getLogger("A");

		@SuppressWarnings("finally")
		@GET
		@Produces( { MediaType.TEXT_PLAIN })
		public String callservice(@QueryParam("status") String status,@QueryParam("flag") String flag)	throws SQLException {

			logger.info(":: Start of CallWebservice  Class :: callservice()");
			 String URL = "http://localhost:8080/RestWebService/rest/opentheDoor?status="+status+"&pointname=EML_DEMO&flag="+flag+"";  
			 String URLtoCall = URL ;
			 String response="";
				 try  
				 {
					 System.out.println("URLtoCall :"+ URLtoCall); 
					 String responseString = httpGet(URLtoCall); 
					 System.out.println("responseString :"+ responseString);
					 // Do something with the returned response, currently just printing to console
					 response=responseString; 
					 
				 }
			     catch (IOException e)        
				 {   
					 // Handle exception here, currently just printing stack trace            
					 e.printStackTrace();  
					 response="INTERNAL ERROR";
				 } 
			     return response; 
			 }
			
		
       public static String httpGet(String urlString) throws IOException 
       {  URL url = new URL(urlString);
          HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
          // Check for successful response code or throw error
          if (conn.getResponseCode() != 200) 
          {
        	  //conn.disconnect();
        	  throw new IOException(conn.getResponseMessage()); 
        	  
          }            
          // Buffer the result into a string 
          BufferedReader buffrd = new BufferedReader(  
          new InputStreamReader(conn.getInputStream()));
          StringBuilder sb = new StringBuilder();
          String line; 
          while ((line = buffrd.readLine()) != null)
          {  sb.append(line);  
          
          }
          buffrd.close();
          conn.disconnect();
          return sb.toString();   
          
       } 
	
}
