package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import connectionFactory.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
/**
 * Servlet implementation class ConfRoomServlet
 */

 
public class ConfRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList <String> room= new ArrayList<String>();
		PreparedStatement prepstmnt = null;
        ResultSet rs = null;
        Connection con=null; 
        RequestDispatcher view=null;
		String Items[]= request.getParameterValues("checkbox_group");
		String query="Select CR_Name from Conference_RoomBook where";
        for(int i=0; i<Items.length;i++)
        {
            if(Items[i].equals("keyboard"))
          {
             if(i==0)
              query= query + " keyboard='A'";
             else
               query= query + " AND keyboard='A'";
           }
          if(Items[i].equals("mouse"))
          {
             if(i==0)
              query= query + " mouse='A'";
             else
               query= query + " AND mouse='A'";
           }
          if(Items[i].equals("tv"))
          {
             if(i==0)
              query= query + " tv='A'";
             else
               query= query + " AND tv='A'";
           }
          if(Items[i].equals("projector"))
          {
             if(i==0)
              query= query + " projector='A'";
             else
               query= query + " AND projector='A'";
           }
          if(Items[i].equals("phone"))
          {
             if(i==0)
              query= query + " phone='A'";
             else
               query= query + " AND phone='A'";
           }
          if(Items[i].equals("M20")|| Items[i].equals("M35")|| Items[i].equals("M50"))
          {
              int l=Integer.parseInt(Items[i]);
          
              if(i==0)
                  query= query + " MaxMembers="+l;
              else
                  query= query + " AND MaxMembers="+l;
          }
        }
        query= query + " AND CR_Status='A'";  
        con=DBConnection.createConnection();  
        try {
			prepstmnt = con.prepareStatement(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			rs=prepstmnt.executeQuery();
			while (rs.next()) {
	            room.add(rs.getString("CR_Name")); 
	        }
			request.setAttribute("conf_room", room); 
			request.setAttribute("msg", "a"); 
            view=request.getRequestDispatcher("CR_Booking2.jsp"); 
			view.forward(request,response); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.CloseAll(con, prepstmnt, rs); 
	
	
	}
	
}
