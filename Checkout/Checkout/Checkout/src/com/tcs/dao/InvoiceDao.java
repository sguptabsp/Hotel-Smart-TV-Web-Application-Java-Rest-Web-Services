package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.tcs.beans.InvoiceBean;
import com.tcs.connection.DBConnection;
import com.tcs.utility.DateUtility;

public class InvoiceDao {

	PreparedStatement prepstmnt = null;
	ResultSet rs = null;
	Connection con=null;

	public InvoiceBean getInvoiceDetail(InvoiceBean invoice) throws SQLException
	{
		con = DBConnection.createConnection();
		String query1 = "Select REGISNO from Booking3 where RoomNo='"+invoice.getRoomNo()+"' AND Cust_Name ='"+invoice.getName()+"' AND AVALABILITY = 'N'";
		System.out.println(query1);
		prepstmnt = con.prepareStatement(query1);
		rs=prepstmnt.executeQuery();
		if(!rs.next())
		{
			System.out.println("in null");
			return null;
		}
		else
		{
			con = DBConnection.createConnection();
			String query3 = "Select * from Booking3 where RoomNo='"+invoice.getRoomNo()+"' AND Cust_Name ='"+invoice.getName()+"'";
			prepstmnt = con.prepareStatement(query3);
			rs=prepstmnt.executeQuery();
			int noOfDays = DateUtility.daysBetween(invoice.getCheckInDate(), invoice.getCheckOutDate());
			System.out.println("no of days"+noOfDays);

			while(rs.next())
			{
				invoice.setRegNo(rs.getInt(3));
				System.out.println(rs.getInt(3));
				invoice.setMealCharges(rs.getDouble(6));
				System.out.println(rs.getDouble(6));
				invoice.setSpaCharges(rs.getDouble(7));
				invoice.setRoomCharges(noOfDays*rs.getDouble(8));
				invoice.setTaxCharges(50*noOfDays);
				invoice.setTotalCharges(invoice.getMealCharges()+invoice.getSpaCharges()+invoice.getRoomCharges()+invoice.getTaxCharges());
			}
			DBConnection.CloseAll(con, prepstmnt, rs);
		}

		con = DBConnection.createConnection();
		Date date = invoice.getCheckOutDate();
		java.sql.Date dt = new java.sql.Date(date.getTime());
		String query2 = "UPDATE Booking3 SET CheckOut_Date='" + dt+ "', Avalability ='Y',TotalCharges='"+ invoice.getTotalCharges()+"' where RoomNo='"+invoice.getRoomNo()+"'"; 
		System.out.println(query2);
		prepstmnt = con.prepareStatement(query2);
		rs=prepstmnt.executeQuery();

		DBConnection.CloseAll(con, prepstmnt, rs);
		return invoice;

	}

}
