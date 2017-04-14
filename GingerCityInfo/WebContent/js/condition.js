function display()
    {
     var location = document.getElementById("location").value;
     var category = document.getElementById("category").value;
     var frm = eval("document.forms['searchForm']");
     if(location == 'Delhi' && category == 'Restaurant')
     {
       frm.action="delhi_resturants.html";
     }
     if(location == 'Mumbai' && category == 'Restaurant')
     {
       frm.action="MumbaiRestaurants.html";
     }
     if(location == 'Chennai' && category == 'Restaurant')
     {
       frm.action="ChennaiRestaurants.html";
     }
     
     if(category == 'Wikipedia')
     {
       window.open("http://en.wikipedia.org/wiki/"+location);
     }
     if(category == 'Place of Interest')
     {
       window.open("http://www.tourisminindia.com/city/"+location+".aspx");
     }
     if(category == 'Taxi Services')
     {
       if(location == 'Mumbai')
	  {
	   window.open("http://www.megacabs.com/");
	  }
	  if(location == 'Chennai')
	  {
	   window.open("http://www.bookcab.in/");
	  }
     }
     if(category == 'Just Dial')
     {
       window.open("http://justdial.com/"+location);
     }
     
     frm.submit();
     
  }
    
    
 function wiki(location)
	{
	  window.location.href = "http://en.wikipedia.org/wiki/"+location;
	}
	
 function restaurant(location)
	{
 	 window.location.href = "http://bookmyrestaurant.co.in/city-"+location;
	}	
 function places(location)
	{
     window.location.href = "http://www.tourisminindia.com/city/"+location+".aspx";
	}

 function justdial(location)
	{
 	 window.location.href = "http://justdial.com/"+location;
	}
 
 function taxi(location)
 	{	
	  if(location == 'Mumbai')
	  {
	   window.location.href = "http://www.megacabs.com/";
	  }
	  if(location == 'Chennai')
	  {
	   window.location.href = "http://www.bookcab.in/";
	  }
 	}