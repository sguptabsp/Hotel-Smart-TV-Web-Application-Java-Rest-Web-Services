<%@ page language="java" import="com.tcs.beans.InvoiceBean;"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice Details</title>
<link rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/tb.css" />
</head>
<%
	InvoiceBean bean = (InvoiceBean) request.getAttribute("bean");
%>
<script type="text/javascript">
function submitForm(btnName)

  {

    
	     var frm = eval("document.forms['ImplInstantPayForm']");

	     if(btnName=='Success')
	     {
	       if(document.getElementById("mode").checked==true)
	       {
		       frm.action="CheckOutServlet?amount="+<%= bean.getTotalCharges() %>+"&b1=paynow";
		   }
		   else
		   {
		     document.getElementById("errMsg").innerHTML='Please select payment mode';
		     return false;
		     
		   }

	     }

	     else if(btnName=='Cancel')
	     {
				 frm.action="CheckOutServlet?b1=Cancel";
		 }

	     frm.submit();

     }



function Display()
{

 document.getElementById("Card1").innerHTML = '<input type="radio" name="credit" value="visa" checked="checked">VISA';
 document.getElementById("Card2").innerHTML =  '<input type="radio" name="credit" value="master">MASTER';
 document.getElementById("Card3").innerHTML =  '<input type="radio" name="credit" value="americanExpress">American Express';
  
}
</script>

<body>
<h1 align="center">INVOICE DETAILS</h1>
<div class="img" style="margin-left: 0px;"><a target="_blank"
	href=""><img src="images/Check_out2.jpg" alt="checkout"
	width="1300px" height="250" /></a></div>
<br></br>
<div align="center" style="width:50%; margin-left: 25%" >
<form name="ImplInstantPayForm" action="" method="post">
<table class="poptable" cellpadding="0" cellspacing="0" border="0"
	width="50%">



	<tr>
		<th>Instant Payment</th>
	</tr>
	<tr>
	   <td><div id="errMsg" style="color : red; font-size:15px"></div>
	</tr>


	<tr>
		<td><!-- Data Display -->

		<table class="poptable" cellpadding="0" cellspacing="0" border="0">

			<tr>

				<td valign='top' align='left' width="100"><b>Reservation No :</b></td>
				<td valign="top" align='left' width="200"><%= bean.getRegNo() %></td>

			</tr>
			<!--For HSD and DATACARD PrePaid-->

			<tr class="rowaltbg">

				<td valign='top' align='left' width="100"><b>Guest Name :</b></td>
				<td valign="top" align='left' width="200"><%= bean.getName() %></td>

			</tr>

			<!--For HSD and DATACARD PrePaid-->

			<tr>
				<td valign='top' align='left' width="100"><b>Payable Amount :</b></td>
				<td valign="top" align='left' width="200"><input type="text" readonly="readonly" name="payAmount" maxlength="10"
					value="<%= bean.getTotalCharges() %>" id="payAmt" class="dtext"></td>
			</tr>

			<!--For HSD and DATACARD PrePaid-->

			<tr class="rowaltbg">
				<td valign='top' align='left'  width="100"><b>Payment Mode :</b></td>
				<td valign="top" align='left' width="300"><input type="radio" name="mode" value="creditCard" id="mode" onclick="Display()">Credit Card &nbsp;&nbsp;&nbsp;
				<input type="radio" name="mode" id="mode" value="debitCard" >Debit Card &nbsp;&nbsp;&nbsp;
				<input type="radio" name="mode" id="mode" value="netBanking">Net Banking 
				</td>
			</tr>
			
			<tr>
			 <td valign="top" align='left' colspan="2">
			 <div id="msg"></div>
			 </td>
			</tr>
			
			<tr>
			 <td valign="top" align='left' width="150">
			 <div id="Card1"></div>
			 </td>
			 <td valign="top" align='left' width="200">
			 <div id="Card2"></div>
			 </td>
			</tr>
			<tr>
			 <td valign="top" align='left' width="150">
			 <div id="Card3"></div>
			 </td>
			</tr>

			<!--For HSD and DATACARD PrePaid-->
		</table>

		</td>
	</tr>


			<tr>
				<td colspan="3" align="right" style="padding: 5px 0;" id="buttonID"><a><img
					src="images/b_paynow.jpg" class="hand m_r10"
					border="0" onClick="submitForm('Success');" /></a> <a><img
					src="images/b_cancel.jpg" class="hand" border="0"
					onClick="submitForm('Cancel');" /></a></td>

			</tr>

		</table>



</form>
</div>
</body>
</html>