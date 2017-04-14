package com.tcs.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.beans.InvoiceBean;
import com.tcs.dao.InvoiceDao;
import com.tcs.utility.DateUtility;

/**
 * Servlet implementation class for Servlet: CheckOutServlet
 *
 */
public class CheckOutServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CheckOutServlet() {
		super();
	}   	

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher view=null;
		
		if(request.getParameter("b1").equals("Check Out"))
		{
			String name = request.getParameter("name");
			String roomNo = request.getParameter("roomNo");
			String checkInDate = request.getParameter("checkInDate");
			String checkOutDate = request.getParameter("checkOutDate");
			InvoiceBean invoice=null;

			invoice = new InvoiceBean();
			invoice.setName(name);
			invoice.setRoomNo(Integer.parseInt(roomNo));
			invoice.setCheckInDate(DateUtility.getDate(checkInDate, "yyyy-MM-dd"));
			invoice.setCheckOutDate(DateUtility.getDate(checkOutDate, "yyyy-MM-dd"));

			InvoiceDao ID = new InvoiceDao();
			try {
				invoice = ID.getInvoiceDetail(invoice);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
			if(invoice==null)
			{
				String errorMsg = "Either wrong detail of Guest or Guest already checked our";
				request.setAttribute("errorMsg", errorMsg);
				view=request.getRequestDispatcher("indexCheckout.jsp");
			}
			else
			{
			request.setAttribute("invoice", invoice);
		    view=request.getRequestDispatcher("InvoiceDetails.jsp");
			}
			System.out.println("Meal charges" + invoice.getMealCharges());
			System.out.println("spa charges" + invoice.getSpaCharges());
			System.out.println("total charges" + invoice.getTotalCharges());
		}
		if(request.getParameter("b1").equals("Confirm"))
		{
			String guestName= request.getParameter("guestName");
			String regNo = request.getParameter("regNo");
			String amount =  request.getParameter("amount");
			
			InvoiceBean bean = new InvoiceBean();
			bean.setName(guestName);
			bean.setRegNo(Integer.parseInt(regNo));
			bean.setTotalCharges(Double.parseDouble(amount));
			request.setAttribute("bean", bean);
			view=request.getRequestDispatcher("PaymentMode.jsp");

		}
		if(request.getParameter("b1").equals("Cancel"))
		{
			view=request.getRequestDispatcher("indexCheckout.jsp");
		}
		view.forward(request,response);

	}  	

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view=null;
		if(request.getParameter("b1").equals("Cancel"))
		{
			view=request.getRequestDispatcher("indexCheckout.jsp");
		}
		if(request.getParameter("b1").equals("paynow"))
		{
			
			Integer amount = Integer.parseInt(request.getParameter("amount"));
			request.setAttribute("amount", amount);
			view=request.getRequestDispatcher("CreditCard.jsp");
			
		}
		view.forward(request,response);
	}   	  	    
}