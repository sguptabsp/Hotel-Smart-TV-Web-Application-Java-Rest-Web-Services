<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javaScript" type="text/javascript" src="js/calendar.js"></script>
   <link href="css/calendar.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
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
<form name="checkout" action = "CheckOutServlet">
<table align="center" border="0" cellspacing="5" cellpadding="25">
<tr >
<td colspan="2" align="center" style=font-size:x-large;><b>Enter Your Details:</td>
</tr>
<tr><td colspan="2"><div id="msg" style="color: red; font-size: 15px;">
<% if(errorMsg!=null) { %>
    <%= errorMsg %>
<% }%>

</div></td></tr>
<tr>
<td  align="left"><b>Name: </b></td>
<td><input type="text" name="name" /></td>
</tr>
<tr>
<td  align="left"><b>Room No.:</b></td>
<td> <input type="text" name="roomNo" /></td>
</tr>
<tr>
<td  align="left"><b>Check-In Date:</b></td>
<td> <input type="text" name="checkInDate" /><input type="button" name="dd" onClick="setYears(1980, 2020);
       showCalender(this, 'checkInDate');" style="background: url('images/cal.gif')"/></td>
</tr>
<tr>
<td  align="center"><b>Check-Out Date: </b></td>
<td><input type="text" name="checkOutDate" /><input type="button" name="dd" onClick="setYears(1980, 2020);
       showCalender(this, 'checkOutDate');" style="background: url('images/cal.gif')"/></td>
</tr>
<tr >
<td  align="center" colspan="2"><input type="submit" name="b1" id="bot1" value="Check Out" />      
<input type="button" name="b2" id="bot2" value="Cancel" /></td>
</tr>
</table> 
</form>
</div>
</div>

<!-- Calender Script  --> 

    <table id="calenderTable">
        <tbody id="calenderTableHead">
          <tr>
            <td colspan="4" align="center">
              <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
               this.selectedIndex, false));" id="selectMonth">
                  <option value="0">Jan</option>
                  <option value="1">Feb</option>
                  <option value="2">Mar</option>
                  <option value="3">Apr</option>
                  <option value="4">May</option>
                  <option value="5">Jun</option>
                  <option value="6">Jul</option>
                  <option value="7">Aug</option>
                  <option value="8">Sep</option>
                  <option value="9">Oct</option>
                  <option value="10">Nov</option>
                  <option value="11">Dec</option>
              </select>
            </td>
            <td colspan="2" align="center">
                <select onChange="showCalenderBody(createCalender(this.value, 
                document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
                </select>
            </td>
            <td align="center">
                <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
            </td>
          </tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr style="">
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
    </table>

<!-- End Calender Script  --> 

</body>
</html> 