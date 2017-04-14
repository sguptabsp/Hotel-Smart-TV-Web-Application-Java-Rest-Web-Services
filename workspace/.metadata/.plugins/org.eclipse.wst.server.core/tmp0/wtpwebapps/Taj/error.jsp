<!--http://localhost:8081/GingerTV/index1.jsp?srno='el0C1111050004'-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<script src="js/jquery.js"></script>
<script src="js/keynav.js"></script>
<script src="js/sliding_effect.js"></script>
<script src="js/interface.js"></script>
<title>GingerTV</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<script type="text/javascript">
function call(text)
{
	//alert(text);

	var name=new Array("facebook","twitter","linkedin","youtube","gingerhotel","gingerfeedback");
	var link=new Array("http://www.facebook.com",
			"http://www.twitter.com",
			"http://www.linkedin.com",
			"http://www.youtube.com",
			"http://www.gingerhotels.com/",
			"http://www.gingerhotels.com/contactus/Customer_Feedback.aspx");
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
function callhref(text)
{
	//alert(text);
	if(text=="index1")
	{
		<% 
		HttpSession sess1=request.getSession(true);
		System.out.println("inside callhref of error.jsp..srno=="+sess1.getAttribute("srno2"));
		%>;
		window.location.href=text+".jsp?srno="+<%=sess1.getAttribute("srno2")%>;
		//window.location.href=text+".jsp?srno='el0C1111050004'";
	}
	else	
		window.location.href=text+".html";
		//window.open(text+".html",'_blank');
	//window.location.href=location of file on server
}

$(document).ready(function() {
    // Initialize jQuery keyboard navigation
    $('ul li ').keynav('withfocus','sliding-element');
	 // $('ul li').keynav('withfocus','sliding-element');
    // Set the first div as the one with focus, this is optional
	//('ul li.text').next().removeClass.addClass('withfocus');

     //$('ul li:first').removeClass.addClass('withfocus');

	// bind click event to perform some useful tasks
	$('ul li ').bind("click", function() {
callme();	});

	// lets hide all usefull texts
	closeAll();
});

function callme()
{
	/*alert("call me");
	window.location="http://timesofindia.indiatimes.com/";*/
}
function openUp($e) {
	closeAll();

	$e.find("div").slideDown();
}

function closeAll() {
	$('ul li').each(function() { $(this).find("div").slideUp() });
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
</head>

<body onload="" >
<div class="header">
<!--		<img src="images/GingerLogo.gif" onclick="callhref('index1')"/>	-->
	</div>

	<div class="container">
<!--	<div class="sidenav">-->
<!--	<h3>Reservations@Ginger</h3>-->
<!--			<ul id="sliding-navigation" class="sliding-navigation">-->
<!--				<li id="1" class="sliding-element" onclick="call('gingerhotel')"><a><img src="images/navicon/ginger.png" style="vertical-align: middle"/> Ginger Hotel</a></li>-->
<!--			</ul>   -->
<!--		<h3>Social Media Network</h3>-->
<!--			<ul id="sliding-navigation" class="sliding-navigation">-->
<!--				<li id="2" class="sliding-element" onclick="call('facebook')"><a><img src="images/navicon/facebook.png" style="vertical-align: middle;" /> Facebook</a></li>-->
<!--				<li id="3" class="sliding-element" onclick="call('twitter')"><a><img src="images/navicon/twitter.png" style="vertical-align: middle;"/> Twitter</a></li>-->
<!--				<li id="4" class="sliding-element" onclick="call('linkedin')"><a><img src="images/navicon/linkedin.png" style="vertical-align: middle;"/> LinkedIn</a></li>-->
<!--			</ul>-->
<!---->
<!--        <h3>Web Channels</h3>-->
<!--			<ul id="sliding-navigation" class="sliding-navigation">-->
<!--				<li id="5" class="sliding-element" onclick="callhref('news')"><a><img src="images/navicon/newspaper.gif" style="vertical-align: middle"></img> NEWS</a></li>-->
<!--				<li id="6" class="sliding-element" onclick="callhref('entertainment')"><a><img src="images/navicon/entertainment2.gif" style="vertical-align: middle"></img> Movies/Music</a></li>-->
<!--				<li id="7" class="sliding-element" onclick="callhref('regional')"><a><img src="images/navicon/regional.gif" style="vertical-align: middle"></img> Regional</a></li>-->
<!--				<li id="8" class="sliding-element" onclick="callhref('devotional')"><a><img src="images/navicon/religous.png" style="vertical-align: middle"></img> Devotional</a></li>-->
<!--			</ul>-->
<!---->
<!---->
<!--        <h3>Info Entertainment</h3>-->
<!--			<ul id="sliding-navigation" class="sliding-navigation">-->
<!--				<li id="9" class="sliding-element" onclick="call('youtube')"><a><img src="images/navicon/youtube.png" style="vertical-align: middle"/> Youtube</a></li>-->
<!--				<li id="10" class="sliding-element" onclick="callhref('newspaper')"><a><img src="images/navicon/newspaper.gif" style="vertical-align: middle"/> Newspapers</a></li>		-->
<!--			</ul>-->
<!--		</div>-->
	<div class="content">
		<center>
		<table align="center" border="0px" style="width:990px; height:556px; margin-top: 20px; border-color: #c13100;border-width: 2px;" cellpadding="0px" cellspacing="0px">
		<tr>
		<td align="center">
			<table  style="margin-top: -150px; " border="0px" cellpadding="0px" cellspacing="0">
    		<tr>
<!--    			<td width="245px" style="padding-left: 30px"><img src="images/namaste.png" alt="Welcome"/></td>-->
    			<td width="595px" align="center" style=" background-color: ;vertical-align: top; padding-left: 30px;padding-top: 30px;">

    				<br/><br/>
    				<div id="gName" style=""></div> <br/>
  					
  					<%
  						String err= request.getAttribute("error").toString();
  						if(!err.equalsIgnoreCase("unauthorized box") && !err.equalsIgnoreCase("no reservation found"))
  						{
  							err="Internal Error";
  						}
  						
  					%>
  					<br/><br/><br/><h3><%=err %></h3>
    			</td>
    		</tr>    		
    		</table>
    	</td>
    	</tr>
    	</table>
    	</center>
<!--    	<table align="center" border="0px" style="width:700px;  margin-top: 5px; border-color: #c13100;border-width: 2px;" cellpadding="0px" cellspacing="0px">-->
<!--		<tr><td align="right"><a href="http://www.testmyspeed.com/" style="text-decoration: none;">Test your internet speed</a>-->
<!--    	</td></tr>-->
<!--    	</table>-->
	</div>
	</div>
	<div class="dock2" id="dock2">
  <div class="dock-container2">
  <a class="dock-item2" href="javascript:callhref('index1')"><span>Home</span><img src="images/dock/home.png" alt="Home" /></a> 
<!--  <a class="dock-item2" href="javascript:call('gingerhotel')"><span>Ginger Hotels</span><img src="images/dock/ginger.png" alt="Ginger Hotels" /></a> -->
  <a class="dock-item2" href="javascript:callhref('socialnetworks')"><span>Social Networking</span><img src="images/dock/social.png" alt="Social Networking" /></a> 
  <a class="dock-item2" href="javascript:callhref('news')"><span>Web Channels</span><img src="images/dock/webchannel.png" alt="Web Channels" /></a>
  <a class="dock-item2" href="javascript:call('youtube')"><span>Youtube</span><img src="images/dock/youtube1.png" alt="InfoEntertainment" /></a>
  <a class="dock-item2" href="javascript:callhref('newspaper')"><span>Newspaper</span><img src="images/dock/newspaper.png" alt="Info Entertainment" /></a>
  <a class="dock-item2" href="javascript:callhref('feedback')"><span>Feedback</span><img src="images/dock/feedback.png" alt="Feedback" /></a>
  <a class="dock-item2" href="javascript:callhref('spaReservation')"><span>Spa Reservation</span><img src="images/dock/spa.png" alt="Spa Reservation" /></a>
  <a class="dock-item2" href="javascript:callhref('restaurant')"><span>Restaurant Booking</span><img src="images/dock/restaurant.png" alt="Restaurant Booking" /></a> 
  
</div>
</div>
</body>
</html> 