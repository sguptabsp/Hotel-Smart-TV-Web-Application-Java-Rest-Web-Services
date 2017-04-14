<%@ page language="java" import="com.tcs.beans.InvoiceBean;" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice Details</title>
<link rel="stylesheet" type="text/css"  />
<script src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    
    testService();

});


function testService()
       {
           $.ajax(
           {
               dataType: 'json',
               headers: {
                   Accept:"application/json",
                   "Access-Control-Allow-Origin": "*"
               },
               type:'GET',
               url:'http://localhost:8080/RestWebService/rest/getInvoiceChkoutJson?reserID=16030',
               success: function(data)
               {
                  
            	   document.getElementById("dispGuest").innerHTML = data.Name;
            	   document.getElementById("dispRoomId").innerHTML = data.Roomno;
            	   document.getElementById("dispRsrvNo").innerHTML = data.ReservationID;
					document.getElementById("dispMealC").innerHTML = data.meal_charges;
					document.getElementById("dispSpaC").innerHTML = data.spa_charges;
					document.getElementById("dispRoomC").innerHTML = data.room_per_day_charges;
					document.getElementById("dispTotal").innerHTML = data.Total;
					//document.writeln("Room no : " + data.Roomno);
                   //document.writeln("CheckIndate : " + data.CheckIndate);
                  // document.writeln("CheckOutdate : " + data.CheckOutdate);
					//document.writeln("ReservationID : " + data.ReservationID);
					
					
				
               },
               error: function(data)
               {
                   alert("error");
               }
           });
       }

</script>
</head>
<body>
<h1 align="center">INVOICE DETAILS</h1>
<div class="img" style="margin-left: 0px;"><a target="_blank"
	href=""><img src="images/Check_out2.jpg" alt="checkout"
	width="1300px" height="250" /></a></div>
<br></br>
<div align="center">
<form name="checkout" action="PaymentMode.jsp" >

<table border="1" cellspacing="0" width="600px" height="390px">
	<tr style="background-color: #ffffff;">
		<td width="600px">
		<center>
		   <table border="0" cellspacing="0">
			  <tr height="25px" style="background-color: #ffffff;"></tr>
			  <tr style="background-color: #ffffff;">
				<td colspan="2" align="right" valign="">
				   <font size="5" color="#6e6e11" style="font-style: italic"><b>GUEST
				FOLIO DETAILS</b> &nbsp;&nbsp;<img src="images/logoAllambie.png"
					height="70px" width="80px" alt=""
					style="margin-left: 70px; margin-right: 10px;" /> </font>
				<hr />
				</td>
			  </tr>

			<tr style="background-color: #ffffff;">
				<td align="left" height="60px" width="250px">
				<table border="0" cellspacing="0" align="left">
					<tr>

						<td><sub> <img
							style="margin-left: 30px; margin-top: 15px;" alt=""
							src="images/inv.png" height="60px" width="70px"> </sub></td>
					</tr>
					<tr>
						<td align="center" style="font-family: Verdana; color: #ffffff;"><sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Service
						Guaranteed</sup></td>
					</tr>
				</table>
				</td>
				<td width="410px">
				<table border="0" align="left">
					<tr height="5px"></tr>
					<tr>
						<td align="right" width="270px">Guest Name :</td>
						<td align="left" style="font-size: small" width="140px">
						<div id="dispGuest"></div>
						</td>
					</tr>
					<tr>
						<td align="right">Room :</td>
						<td style="font-size: small" align="left">
						<div id="dispRoomId"></div>
						</td>
					</tr>
					<tr>
						<td align="right">Reservation No :</td>
						<td align="left" style="font-size: small">
						<div id="dispRsrvNo"></div>
						</td>
					</tr>
				</table>
				</td>
			</tr>

			<tr style="background-color: #ffffff;">
				<td colspan="2">
				<table border="1" cellspacing="0">
					<tr bgcolor="#ffffff">
						<td width="540px" align="left">&nbsp;&nbsp;<b>Description</b></td>
						<td width="200px" align="left">&nbsp;&nbsp;<b>Service</b></td>
						<td width="250px" align="center"><b>Amount </b><font size="1">(in
						Rs.)</font></td>

					</tr>
					<tr>
						<td colspan="3" bgcolor="#ffffff">
						<div id="invoiceDisp">
						<table>
						</table>
						</div>
						</td>
					</tr>

				</table>
				</td>
			</tr>

			<tr bgcolor="#ffffff">
				<td colspan="4">
				<table border="1" cellspacing="0" width="100%">
					<tr>
						<td width="350px">
						<table border="0" cellspacing="0" style="font-size: small">
							<tr>
								<td valign="middle">Make all payments through cash, credit
								card or cheque.<br />
								<center>
								<font size="3" color="#006633" face="verdana"
									style="font-style: italic"><br>
								Thank you for your business. Wish to serve you again.</br>
								</font>
								</center>
								</td>

							</tr>
						</table>
						</td>
						<td align="right">
						<table width="288px" border="1" cellspacing="0"
							style="font-size: small">
							<tr>
								<td width="118px">Meal Charges</td>
								<td width="130px" align="center" bgcolor="#ffffff">
								<div id="dispMealC"></div>
								</td>
							</tr>
							<tr>
								<td width="118px">Spa Services</td>
								<td width="130px" align="center" bgcolor="#ffffff">
								<div id="dispSpaC"></div>
								</td>
							</tr>
							<tr>
								<td width="118px">Room Charges</td>
								<td width="130px" align="center" bgcolor="#ffffff">
								<div id="dispRoomC"></div>
								</td>
							</tr>
							<tr>
								<td width="118px">OTHERS</td>
								<td width="130px" align="center" bgcolor="#ffffff">
								12% Tax on Room expenses
								</td>
							</tr>
						</table>

						<table width="288px" border="1" cellspacing="0"
							style="font-size: small">
							<tr>
								<td><b>TOTAL</b></td>
								<td align="center" bgcolor="#ffffff">
								<div id="dispTotal"></div>
								</td>
							</tr>
						</table>
						</td>
					</tr>

				</table>

				</td>
			</tr>
		</table>
		</td>
	</tr>

	<tr height="10px" style="background-color: #ffffff;">
		<td align="center"><input type="Submit" name="b1" id = "confirm" value="Confirm" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" name="cancel" id="cancel" value="Cancel" /></td>
	</tr>

</table>

</form>
</div>
</body>
</html>