<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
               url:'http://localhost:8080/RestWebService/rest/getCheckoutDetailsJsn?reserID=16030',
               success: function(data)
               {
            	   document.getElementById("dispName").innerHTML = data.Name;
            	   document.getElementById("dispRoomNo").innerHTML = data.Roomno;
            	   document.getElementById("dispReservationNo").innerHTML = data.ReservationID;
					document.getElementById("dispCheckindate").innerHTML = data.Checkindate;
					document.getElementById("dispCheckoutdate").innerHTML = data.Checkoutdate;
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
<%
 String errorMsg = (String)request.getAttribute("errorMsg");
%>
<body style="background:#FFF5EE ;">
<h1 align="center">Express Check Out</h1>
<br></br>
<br></br>
<br></br>
<div style="width: 100%; float: center;">
<div style=" float: left; margin-left:25px; width: 45%;"><a target="_blank" href=""><img src="images/Check_out.jpg" alt="checkout" height="630" width="580" /></a></div>
<div  style="margin-right:10px;  float: right; width: 50%; ">
<form name="checkout" action = "InvoiceDetails.jsp">
<table align="center" border="0" cellspacing="5" cellpadding="25">
<tr >
<td colspan="2" align="center" style=font-size:x-large;><b>Enter Your Details:</td>
</tr>
<tr>
<td  align="left"><b>Name: </b></td>
<td><div id="dispName"></div></td>
</tr>
<tr>
<td  align="left"><b>Room No.:</b></td>
<td><div id="dispRoomNo"></div></td>
</tr>
<tr>
<td  align="left"><b>Reservation No.:</b></td>
<td><div id="dispReservationNo"></div></td>
</tr>
<tr>
<td  align="left"><b>Check-In Date:</b></td>
<td><div id="dispCheckindate"></div></td>
</tr>
<tr>
<td  align="center"><b>Check-Out Date:</b></td>
<td><div id="dispCheckoutdate"></div></td>
</tr>
<tr >
<td  align="center" colspan="2"><input type="submit" name="b1" id="bot1" value="Check Out" />      
<input type="button" name="b2" id="bot2" value="Cancel" /></td>
</tr>
</table> 
</form>
</div>
</div>
</body>
</html> 