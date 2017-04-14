<%@ page language="java" import="java.util.*"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conference Rooms Avalability</title>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<script src="js/jquery.js"></script>
<script src="js/interface.js"></script>
<script type="text/javascript" src="js/datetimepicker_css.js"></script>

<script type="text/javascript">
<%
 

ArrayList<String> room= (ArrayList<String>)request.getAttribute("conf_room");

String sel_room="";
String delimiter = "-";
for(int i=0;i<room.size();i++)
{
    sel_room= sel_room+ room.get(i) + delimiter;
}

%> 
function callme(N)
{
  var sel = document.getElementsByTagName('input');
  for (var i=0; i<sel.length; i++) {
    if (sel[i].name == N) { sel[i].checked = false; }
  }
}
function call(text)
{
	var name=new Array("gingerhotel","facebook","twitter","linkedin","youtube","gingerfeedback","indiapress",
			"onlinenewspapers","newspapers","allnewspapers");
	var link=new Array("http://www.gingerhotels.com/",
			"http://www.facebook.com",
			"http://www.twitter.com",
			"http://www.linkedin.com",
			"http://www.youtube.com",
			"http://www.gingerhotels.com/contactus/Customer_Feedback.aspx",
			"http://www.indiapress.org/index.php/",
			"http://www.onlinenewspapers.com/",
			"http://newspapers.com/",
			"http://allnewspapers.com/");
	for(var i=0;i<name.length;i++)
	{
		if(text==name[i])
		{
			//window.location=link[i];
			  //alert("link"+link[i]);
			  window.open(link[i],'_blank');
		}
	}
}
function validate()
{
	if(document.getElementById("CRoom").value=='')
    {
       document.getElementById("messageId").innerHTML="<center>Please Select Any Available Conference Room.</center>";
       document.getElementById(CRoom).focus();
       return false;
    }
	else if(document.getElementById("username").value=='')
	{
		document.getElementById("messageId").innerHTML="<center>Please enter the Person name.</center>";
	    document.getElementById(username).focus();
	    return false;
	}
	else if(document.getElementById("datetime").value=='')
	{
		document.getElementById("messageId").innerHTML="<center>Please enter the Booking date and Time .</center>";
    document.getElementById(datetime).focus();
	    return false;
	}
	else
	{
			       document.getElementById("array").value= "<%= sel_room %>";
		   
			
			       return true;
    }  return true;
	} 

function callhref(text)
{
	//alert(text);
	if(text=="index1")
	{
		window.location.href=text+".jsp";
	}
	else	
		window.location.href=text+".html";
		//window.open(text+".html",'_blank');
	//window.location.href=location of file on server
}
</script>

<script type="text/javascript">
	
	$(document).ready(
		function()
		{
			
			$('#dock2').Fisheye(
				{
					maxWidth: 60,
					items: 'a',
					itemsText: 'span',
					container: '.dock-container2',
					itemWidth: 80,
					proximity: 80,
					alignment : 'left',
					valign: 'bottom',
					halign : 'center'
				}
			)
		}
	);

</script>

<style type="text/css">

body {
	margin: 0;
	padding: 0;
	background-color: #FFFFFF;
	background-image: url(images/bg.png);
	background-position: center top;
	background-repeat: no-repeat;
	font-family: "Lucida Grande", Verdana, sans-serif;
	font-size: 100%;
	color:black;
}

.sample {
	border-width: 0px;
	border-spacing: 0;
	border-collapse: collapse;
	border-style: outset;
	
	
}

.heading {
	color: black;
	margin: 10px;
	vertical-align: center;
	text-align: center;
	font-family: verdana;
	font-size: 22px;
	font-weight: bold;
	top: 20px;
}

.sample th {
	color: black;
	margin: 10px;
	vertical-align: center;
	background-color :  #FDEEF4;
	text-align: center;
	font-family: verdana;
	font-size: 12px;
	font-weight: medium;
	color: black;
	top: 10px;
}

.txt {
	color: black;
	margin: 10px;
	text-align: center;
	font-family: verdana;
	font-size: 12px;
	color: black;
	top: 10px;
}
</style>
</head>

<body>
<form action="CRBook" method="post" onsubmit="return validate();" >
 <input type="hidden" name="array" value=" " id="array"/>
<div id="form1" align="center" style="margin: 75px 70px 20px 100px;">
<table align="center">
<tr>
<td>&nbsp;</td>
</tr>
	<tr>
        
		<td colspan="3" class="heading" >
		</td><td>&nbsp;&nbsp;</td><td class="heading">Conference Room Booking</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
</table>

<table align="center" cellspacing="30" cellpadding="5" border="0">
<tr>
	<td style="font-size: 20px; font-family: verdana" ><label for="room">Rooms Available:</label></td>
	<td><select name="room" id="CRoom">
<option selected>---select---</option>
<% for(int i=0;i<room.size();i++){ %>
<option value="<%= room.get(i) %>"><%= room.get(i) %></option>
<%}%>
<option value="conf1" />
</select> </td>
	</tr>
<tr>
<td style="font-size: 20px;"  ><label for="room">Booked By:</label></td>
	<td style="font-size: 20px;"  ><input type="text" id="username" name="name1" value="John Miller"/></td>
	</tr>
	<tr>
	<td style="font-size: 20px;"  ><label for="date">Booking Date/Time:</label></td>
	<td><input type="text" name="datetime" value="13-06-2012" id="datetime" size="15" maxlength="30" readonly="readonly">
	<a	href="javascript:NewCssCal('datetime','ddmmyyyy','dropdown',true)"><img src="images/restaurant/cal.gif" style="border-style:none;" width="16" height="16" alt="Pick a date"></a>
	</td>
	</tr>
	<tr>
	<td align="right"><input type="submit" value="Book Room" /></td>
	<td><input type="reset" value="Reset" /></td>
	</tr>
	
</table>
<br></br>
	


<% 
String msg = (String)request.getAttribute("msg");
if(!msg.equals("a")){
%>
<div id="messageId" align="center" style=" font-family: verdana; font-size :14px; color:#D80000 ; font-weight: bold; margin-top: 100px"><%= msg %></div>
<%} %> 
</div>

<div class="dock2" id="dock2">
  <div class="dock-container2">
  <a class="dock-item2" href="javascript:callhref('index1')"><span>Home</span><img src="images/dock/home.png" alt="Home" /></a> 
<!--  <a class="dock-item2" href="javascript:call('gingerhotel')"><span>Ginger Hotels</span><img src="images/dock/ginger.png" alt="Ginger Hotels" /></a> -->
  <!--<a class="dock-item2" href="javascript:callhref('socialnetworks')"><span>Social Networking</span><img src="images/dock/social.png" alt="Social Networking" /></a> 
  <a class="dock-item2" href="javascript:callhref('news')"><span>Web Channels</span><img src="images/dock/webchannel.png" alt="Web Channels" /></a>
  <a class="dock-item2" href="javascript:call('youtube')"><span>Youtube</span><img src="images/dock/youtube1.png" alt="InfoEntertainment" /></a>
  <a class="dock-item2" href="javascript:callhref('newspaper')"><span>Newspaper</span><img src="images/dock/newspaper.png" alt="Info Entertainment" /></a>
--><a class="dock-item2" href="javascript:callhref('spaReservation')"><span>Spa Reservation</span><img src="images/dock/spa.png" alt="Spa Reservation" /></a>
  <a class="dock-item2" href="javascript:callhref('restaurant')"><span>Restaurant Booking</span><img src="images/dock/restaurant.png" alt="Restaurant Booking" /></a>
  <a class="dock-item2" href="javascript:callhref('dispMessage')"><span>Inbox</span><img src="images/dock/message.png" alt="Messages" /></a>
  <a class="dock-item2" href="javascript:callhref('pickDropService')"><span>Pick and Drop</span><img src="images/dock/pick.png" alt="Pick and Drop" /></a> 
  <a class="dock-item2" href="javascript:callhref('invoice')"><span>Invoice</span><img src="images/dock/invoice.png" alt="Invoice" /></a>
  <a class="dock-item2" href="javascript:callhref('emailLogin')"><span>Find Friends</span><img src="images/dock/friends.png" alt="Find Friends" /></a> 
  </div>
</div>
</form>
</body>
</html>