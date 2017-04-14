package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {

    public static Connection createConnection()
    {
    	Connection con=null;	
try{

	System.out.println("::CONNECTING................");
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://172.17.196.224:3307/hsp_schema";
	// Get the Connection object from Driver Manager
	con = DriverManager.getConnection(url, "admn", "admn");
	System.out.println("::CONNECTED !!!");
	con.setAutoCommit(false); 
  }
catch (Exception e) {
// TODO: handle exception
System.out.println(" Exception Occurred in testStatement ");

try 
{
con.rollback();
} 

catch (SQLException sqle) 
{
System.out.println(" SQLException while roll back in testStatement ");
}

}
return con;
    }
    public static void CloseAll(Connection conn,java.sql.PreparedStatement prepstmnt,ResultSet rs )
    {

try {
if(rs != null)
rs.close();
if(prepstmnt != null)
prepstmnt.close();
if(conn != null)
conn.close();
} catch (Exception e) {
System.out.println(
" Exception while cleaning up resources in testPreparedStatement");
}

    }
}