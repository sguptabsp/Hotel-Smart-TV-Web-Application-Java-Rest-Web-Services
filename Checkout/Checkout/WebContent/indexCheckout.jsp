<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Out</title>
<link rel="stylesheet" type="text/css" href="css/ckostyle.css" />
<style type="text/css">
div.img
{
  margin: 10px;
  height: auto;
  width: auto;
  float: left;
  text-align: center;
}	
</style>
</head>
<body>
<br></br>
<h1 align="center">Express Check Out</h1>
<br></br>
<br></br>
<br></br>
<div class="img"  style=margin-left:25px;><a target="_blank" href=""><img src="images/Check_out.jpg" alt="checkout" width="570px" height="630" /></a></div>
<div  style="margin-right:25px; width: 50%; height: 630;">
<form name="checkout" action = "CheckOutServlet">
<table align="center" cellspacing="50" cellpadding="20">
<tr >
<td colspan="2" align="center" style=font-size:x-large;><b>Enter Your Details:</td>
</tr>
<tr></tr>
<tr>
<td  align="left">Name: </td>
<td><input type="text" name="name" /></td>
</tr>
<tr>
<td  align="left">Room No.:</td>
<td> <input type="text" name="roomNo" /></td>
</tr>
<tr>
<td  align="left">Check-In Date:</td>
<td> <input type="text" name="checkInDate" /></td>
</tr>
<tr>
<td  align="center">Check-Out Date: </td>
<td><input type="text" name="checkOutDate" /></td>
</tr>
<tr >
<td  align="center" colspan="2"><input type="submit" name="b1" id="bot1" value="Check Out" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name="b2" id="bot2" value="Cancel" /></td>
</tr>
</table> 
</form>

</div>
</body>
</html>