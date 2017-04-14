<!--http://localhost:8081/GingerTV/index1.jsp?srno='el0C1111050004'-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<script src="js/jquery.js"></script>
<script src="js/keynav.js"></script>
<script src="js/sliding_effect.js"></script>
<script src="js/interface.js"></script>
<title>Allambie</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<script type="text/javascript">
function call(text)
{
	//alert("call"+ text);

	var name=new Array("facebook","twitter","linkedin","youtube","allambie","gingerfeedback");
	var link=new Array("http://www.facebook.com",
			"http://www.twitter.com",
			"http://www.linkedin.com",
			"http://www.youtube.com",
			"http://172.20.178.121:8080/HotelIBE/Allambie.jsp",
			"http://www.gingerhotels.com/contactus/Customer_Feedback.aspx");
	
	for(var i=0;i<name.length;i++)
	{
		if(text==name[i])
		{   
			//window.location=link[i];
			 // alert("link"+link[i]);
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
		System.out.println("\n\ninside callhref of index1.jsp..srno==");
		%>;
		window.location.href=text+".jsp";
		//window.location.href=text+".jsp?srno='el0C1111050004'";
	}
	else	
		window.location.href=text+".html";
		//window.open(text+".html",'_blank');
	//window.location.href=location of file on server
}


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
	$('ul li').each(function() { $(this).find("div").slideUp(); });
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
<!--onload="getSerialno()"-->
<body onload="" >


<div class="header">
<!--		<img src="images/GingerLogo.gif" style="margin-left: 20px;" onclick="callhref('index1')"/>	-->
	</div>

	<div class="container">
	
	<div class="content">
	
		<table border="0px" style="width:990px; height:556px; margin-top: 20px; border-color: #c13100;border-width: 2px;" cellpadding="0px" cellspacing="0px">
		<tr>
		<td align="right" >
			<table  style="margin-top: -80px; margin-right: 150px;" border="0px" cellpadding="0px" cellspacing="0">
    		<tr>
    			<td width="245px" style="padding-left: 30px"><img src="images/roundpic2.png" alt="Welcome"/></td>
    			<td width="350px" align="left" style=" background-color: ;vertical-align: top; padding-left: 30px;padding-top: 20px;">

    				<br/><br/>
    				
    				<div id="gName" style="color: #c13100; float:left; width: 85%; font-size:100%; font-style: italic;">
    				Dear John Miller</div> <br/>
  					
  					<br/>Allambie Hotels welcomes you 
    				<br/>We wish you a pleasant stay here <br/> and 
    				<br/>look forward to serving you again in future
    				<br/><br/>Regards
    				<br/>Allambie team
    			</td>
    		</tr>   	
    		</table>
	</div>
	</div>
	<div class="dock2" id="dock2">
  <div class="dock-container2">
  <a class="dock-item2" href="javascript:callhref('index1')"><span>Home</span><img src="images/dock/home.png" alt="Home" /></a> 
 <a class="dock-item2" href="javascript:call('allambie')"><span>Allambie Hotels</span><img src="images/dock/allambie.png" alt="Allambie Hotels" /></a>
 
  <a class="dock-item2" href="javascript:callhref('guestServices')"><span>Guest Services</span><img src="images/dock/guest.png" alt="Guest Services" /></a> 
  <a class="dock-item2" href="javascript:callhref('hotelServices')"><span>Hotel Services</span><img src="images/dock/hotel.png" alt="Hotel Services" /></a>
  </div>
</div>
</body>
</html> 