package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionFactory.DBConnection;

/**
 * Servlet implementation class CR_Booking2
 */
public class CRBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		int chk=0; 
		ArrayList <String> room= new ArrayList<String>();
		String roomlist= request.getParameter("array");
		System.out.println("roomlist"+roomlist);
		String delimiter="-";
		String temp[]=roomlist.split(delimiter);
		for(int i=0;i<temp.length;i++)
		{
			room.add(temp[i]);
		}
		String confRoom= request.getParameter("room");
		String personName= request.getParameter("name1");
		String dateTime= request.getParameter("datetime");
		String msg="null";
		PreparedStatement prepstmnt = null;
        ResultSet rs = null;
        Connection con=null; 
        RequestDispatcher view=null;
        System.out.println("variables read"  +confRoom);
        System.out.println("variables read"  +personName);
        System.out.println("variables read"  +dateTime);
        
        String query="Select CR_id from CR_Data where BookingDateTime='"+dateTime+"' AND CR_Name ='"+confRoom+"' AND CR_Status='NA'"; 
	
        System.out.println("query prepared");
		
		con=DBConnection.createConnection();  
		System.out.println("Connection created");
		try 
		{
			prepstmnt = con.prepareStatement(query);
			System.out.println("prepare statement ppd in query");
		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Exeption occ in prepare statement ppd in query");
		}
        try 
        {
        	System.out.println("preparing resultset for query");
			rs=prepstmnt.executeQuery();
			while (rs.next()) {
				chk=chk+rs.getInt("CR_id"); 
	          //  System.out.println(rs.getInt("CR_id")); //testing
				System.out.println("chk="+chk);
	        }
			System.out.println("query executed");
			DBConnection.CloseAll(con, prepstmnt, rs);
			if(chk>0)
			{	
				System.out.println("Room already Reserved");
				msg="Room already reserved!!";
			}
			else
			{
        
				
				con=DBConnection.createConnection(); 
				System.out.println("inserting values");
				String query1="INSERT INTO CR_Data(CR_Name,BookedBy,BookingDateTime,CR_Status) VALUES (?,?,?,'NA')";   
				//String query1= "INSERT INTO CR_Data(CR_Name,BookedBy,BookingDateTime,CR_Status) VALUES ('conf21','dffdddww','23-12-12 11:00am','NA')";
				System.out.println("ppd insert query");
				prepstmnt = con.prepareStatement(query1);
				System.out.println("prepare statement ppd in query1");
				prepstmnt.setString(1, confRoom);
				//System.out.println("confRoom"+confRoom);
				prepstmnt.setString(2,personName );
				//System.out.println("personName"+personName);
				prepstmnt.setString(3, dateTime);
				//System.out.println("dateTime"+dateTime);
				//System.out.println("set values");
				int i = prepstmnt.executeUpdate();
				System.out.println("value of i="+i);
				msg="Conference Room "+confRoom+" has been booked successfully by "+personName+" at "+dateTime; 
				System.out.println(msg);
				con.commit();
				DBConnection.CloseAll(con, prepstmnt, rs);
   
			
			 
			
        } 
			request.setAttribute("msg",msg );
			request.setAttribute("conf_room", room); 
			view=request.getRequestDispatcher("CR_Booking2.jsp"); 
			view.forward(request,response); 
			}
		
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
        }}
		
	
