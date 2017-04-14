






<html>

<head>

<title>Billdesk Payment Gateway</title>

<link href="css/stylesheet.css" rel="stylesheet" type="text/css">

<SCRIPT type="text/javascript" src="js/vnumpad.js"></SCRIPT>

<script language ='javascript'>

					

					function CCPopUp(SEALURL, cId){

					  window.open(""+SEALURL+"index.php?page=showCert&cId="+cId+"", "win",'toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=0,width=700,height=585');

					  self.name = "mainWin";

					}

					

					</script>

<script language=javascript>



function MM_preloadImages() { //v3.0

  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();

    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)

    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}

}



</script>



<script language=javascript>

function openWin1(url)

{

var j=window.open(url,"jj","left=20, top=20, width=446,height=325,scrollbars=1") 

}

</script>



<SCRIPT LANGUAGE="javascript" type="text/javascript">

var issubmit=false;





function cancelForm(){

		var frm = eval("document.forms['form1']");
		frm.action="CheckOutServlet?b1=Cancel";
        frm.submit(); 



}

function validateForm(btnName)

{

	

	var CVV = new RegExp("^[0-9]{3}$");
/*
if (document.form1.cnumber.value.substring(0,1)=='4')

	{

//		alert("Starts with "+document.form1.cnumber.value.substring(0,1));

		document.form1.cardType.value='V'

//		alert("Card Type "+document.form1.cardType.value);

	}

if (document.form1.cnumber.value.substring(0,1)=='5')

	{

//		alert("Starts with "+document.form1.cnumber.value.substring(0,1));

		document.form1.cardType.value='M'

//		alert("Card Type "+document.form1.cardType.value);

	}

	if (!validateCard(document.form1.cnumber.value,document.form1.cardType.value,document.form1.expmon.value,document.form1.expyr.value))

	{

		document.form1.cnumber.focus();

		return false;

	}

	if (! document.form1.cvv2.value.match(CVV))

	{

		alert("Please enter a valid CVV2 number (e.g. 350)");

		document.form1.cvv2.focus();

		return false;

	}	
*/
	if (checkName(document.form1.cname2.value))

	{

		alert("Please enter a valid first name (e.g. Alok Bisen) without any special characters");

		document.form1.cname2.focus();

		return false;

	}

	if (document.form1.cname2.value== 'Please enter your name specified on the card')

	{

		alert("Please enter a valid first name (e.g. Alok Bisen) without any special characters");

		document.form1.cname2.focus();

		return false;

	}

	/*if (document.form1.Imgver.value.length== 0)

	{

		alert("Please type the exact characters you see in the picture");

		document.form1.Imgver.focus();

		return false;

	}*/

	



	else

	{

		var frm = eval("document.forms['form1']");

        if(btnName=='Success')
        {
              frm.action="CheckOutServlet?b1=makepayment";
        }

        frm.submit(); 
	}

		return false;

}

function checkName(str)

{

	str = trimSpaces(str);

	if(str=="")

	{



			return true;

	}

	else if(str.length>50 || str.length < 3)

	{

			return true;

	}

	else if(!(checkForPraSpcChar("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ. ",str)))

    {

			return true;

    }

	else

	{

		return false;

	}

}

function checkForPraSpcChar(str, obj)

{

	var str1 = str;

    var str2 = obj;

	var str2Len = obj.length;

    var i,j;

    var ch;

    var check=false;

	for (i=0; i<str2.length; i++)

	{

       	check=false;

       	ch = str2.charAt(i);

		for (j=0; j<str1.length; j++)

		{



   			if (ch == str1.charAt(j))

			{

		     			check=true;

            	break;

            }

     	}

		if (!check)

			break;

     }

	    return check;

}

function trimSpaces (str)

{

    var len = str.length;

	var str1 = str;

    var loop=true;



	while(loop)

	{



		if (str1.charAt(0) == " ")

		{

			str1 = str1.substring(1);

			len = str1.length;

		}

		else if(str1.charAt((len-1)) == " ")

		{

			str1 = str1.substring(0,(len-2));

			len = str1.length;

		}

		else

		{

			loop = false;

		}

	}

	return (str1);

}
/*
function mod10( cardNumber ) {

	var ar = new Array( cardNumber.length );

	var i = 0,sum = 0;





    	for( i = 0; i < cardNumber.length; ++i ) {

    		ar[i] = parseInt(cardNumber.charAt(i));

    	}

    	for( i = ar.length -2; i >= 0; i-=2 ) {

    		ar[i] *= 2;

    		if( ar[i] > 9 ) ar[i]-=9;

    	}





        	for( i = 0; i < ar.length; ++i ) {

        		sum += ar[i];

        	}

        	return (((sum%10)==0)?true:false);

    }





        function expired( month, year ) {



        	var now = new Date();

        	var expiresIn = new Date(year,month,0,0,0);

        	expiresIn.setMonth(expiresIn.getMonth());

        	if( now.getTime() < expiresIn.getTime() ) return false;

        	return true;

    }


*/


        function validateCard(cardNumber,cardType,cardMonth,cardYear) {









			if( cardNumber.length == 0 ) {

        		alert("Please enter a valid card number.");

        		return false;

        	}

        	for( var i = 0; i < cardNumber.length; ++i ) {

        		var c = cardNumber.charAt(i);





            		if( c < '0' || c > '9' ) {

            			alert("Please enter a valid card number without any spaces or other special characters.");

            			return false;

            		}

            	}
/*
            	var length = cardNumber.length;





                	switch( cardType ) {

                                              		case 'M':





                                    			if( length != 16 ) {

                                    				alert("Please enter a valid card number.");

                                    				return;

                                    			}

                                    			var prefix = parseInt( cardNumber.substring(0,2));





	                                        			if( prefix < 51 || prefix > 55) {

                                        				alert("Please enter valid card number.");

                                        				return;

                                        			}

                                        			break;

												case 'V':





                                            			if( length != 16 && length != 13 ) {

                                            				alert("Please enter a valid card number.");

                                            				return;

                                            			}

                                            			var prefix = parseInt( cardNumber.substring(0,1));







                                                			if( prefix != 4 ) {

                                                				alert("Please enter valid card number.");

                                                				return;

                                                			}

                                                			break;

                                                	}

                                                	if( !mod10( cardNumber ) ) {

                                                		alert("Sorry! This is not a valid card number.");

                                                		return false;

                                                	}

                                                	if( expired( cardMonth, cardYear ) ) {

                                                		alert("Sorry! The expiry date that you have entered is invalid.");

                                                		return false;

                                                	}



                                                	return true;*/

                                            }



</script>





<script language="JavaScript1.2" type="text/javascript">

<!--

   

   var opened = false, vkb = null, text = null, insertionS = 0, insertionE = 0;

   var opened1 = false, vkb1 = null

   var userstr = navigator.userAgent.toLowerCase();

   var isgecko = (userstr.indexOf('gecko') != -1) && (userstr.indexOf('applewebkit') == -1);

   function numpad_change()

   {

     document.getElementById("switch").innerHTML = (opened ? "Virtual Numpad" : "Hide Numpad");

     opened = !opened;

	



	 if (opened){

	 document.getElementById("cnumber").value="";

	 document.getElementById("cnumber").readOnly=true;

	 }else {

	 document.getElementById("cnumber").readOnly=false;

	 }

     if(opened && !vkb)

     {

       vkb = new VBDNUMpad("numpad",  

                         pad_callback,

                         "",          

                         "14px",      

                         "#000",      

                         "#FFF",      

                         "#EDEDDE",   

                         "#FFF",      

                         true,        

                         "#CC3300",   

                         "#FF9000",   

                         "#CC3300",   

                         false,       

                         true);       

				 

	



     }

     else {

 	

       vkb.Show(opened);

	   }



	

     text = document.getElementById("cnumber");



     text.focus();

	 



     if(document.attachEvent)

       text.attachEvent("onblur", backFocus);

   }

   

function numpad1_change()

   {

     document.getElementById("switch1").innerHTML = (opened1 ? "Virtual Numpad" : "Hide Numpad");

     opened1 = !opened1;



	 if (opened1){

	 	 document.getElementById("cvv2").value="";

	 document.getElementById("cvv2").readOnly=true;

	 }else {

	 document.getElementById("cvv2").readOnly=false;

	 }

	 

     if(opened1 && !vkb1)

     {

       vkb1 = new VBDNUMpad("numpad1", 

                         pad_callback1,

                         "",           

                         "14px",       

                         "#000",       

                         "#FFF",       

                         "#EDEDDE",    

                         "#FFF",       

                         true,         

                         "#CC3300",    

                         "#FF9966",    

                         "#CC3300",    

                         false,        

                         true);        

				 

	

     }

     else{

	

       vkb1.Show(opened1);

	   }



     text = document.getElementById("cvv2");



     text.focus();

	 



     if(document.attachEvent)

       text.attachEvent("onblur", backFocus);

   }   



   function backFocus()

   {

     if(opened)

     {

       setRange(text, insertionS, insertionE);



       text.focus();

     }

   }



   // Advanced callback function:

   //

   function pad_callback(ch)

   {

     var val = text.value;

   	 document.getElementById("cnumber").readOnly=false;



     switch(ch)

     {

       case "Back":

         if(val.length)

         {

           var span = null;



           if(document.selection)

             span = document.selection.createRange().duplicate();



           if(span && span.text.length > 0)

           {

             span.text = "";

             getCaretPositions(text);

           }

           else{

			 deleteAtCaret(text);



			 }

         }



         break;



       default:

         insertAtCaret(text, (ch == "Enter" ? ((window.opera || window.netscape) ? '\r\n' : '\n') : ch));

     }

   	 document.getElementById("cnumber").readOnly=true;

   }

   

   

    function pad_callback1(ch)

   {

     var val = text.value;

	 document.getElementById("cvv2").readOnly=false;



     switch(ch)

     {

       case "Back":

         if(val.length)

         {

           var span = null;



           if(document.selection)

             span = document.selection.createRange().duplicate();



           if(span && span.text.length > 0)

           {

             span.text = "";

             getCaretPositions(text);

           }

           else{



             deleteAtCaret(text);

			 

			 }

         }



         break;



       default:

         insertAtCaret(text, (ch == "Enter" ? ((window.opera || window.netscape) ? '\r\n' : '\n') : ch));

     }

	 document.getElementById("cvv2").readOnly=false;

   }



   // This function retrieves the position (in chars, relative to

   // the start of the text) of the edit cursor (caret), or, if

   // text is selected in the TEXTAREA, the start and end positions

   // of the selection.

   //

   function getCaretPositions(ctrl,pos1)

   {

     var CaretPosS = -1, CaretPosE = 0;

     



	 

     // Mozilla way:

     if(ctrl.selectionStart || (ctrl.selectionStart == '0'))

     {

       CaretPosS = ctrl.selectionStart;

       CaretPosE = ctrl.selectionEnd;



       insertionS = CaretPosS == -1 ? CaretPosE : CaretPosS;

       insertionE = CaretPosE;

     }

     // IE way:

     else if(document.selection && ctrl.createTextRange)

     {

       var start = end = 0;

       try

       {

         start = Math.abs(document.selection.createRange().moveStart("character", -10000000)); // start



         if (start > 0)

         {

           try

           {

             var endReal = Math.abs(ctrl.createTextRange().moveEnd("character", -10000000));



             var r = document.body.createTextRange();

             r.moveToElementText(ctrl);

             var sTest = Math.abs(r.moveStart("character", -10000000));

             var eTest = Math.abs(r.moveEnd("character", -10000000));



             if ((ctrl.tagName.toLowerCase() != 'input') && (eTest - endReal == sTest))

               start -= sTest;

           }

           catch(err) {}

         }

       }

       catch (e) {}



       try

       {

         end = Math.abs(document.selection.createRange().moveEnd("character", -10000000)); // end

         if(end > 0)

         {

           try

           {

             var endReal = Math.abs(ctrl.createTextRange().moveEnd("character", -10000000));



             var r = document.body.createTextRange();

             r.moveToElementText(ctrl);

             var sTest = Math.abs(r.moveStart("character", -10000000));

             var eTest = Math.abs(r.moveEnd("character", -10000000));



             if ((ctrl.tagName.toLowerCase() != 'input') && (eTest - endReal == sTest))

              end -= sTest;

           }

           catch(err) {}

         }

       }

       catch (e) {}



       insertionS = start;

       insertionE = end

     }

   }



   function setRange(ctrl, start, end)

   {

     if(ctrl.setSelectionRange) // Standard way (Mozilla, Opera, ...)

     {

       ctrl.setSelectionRange(start, end);

     }

     else // MS IE

     {

       var range;



       try

       {

         range = ctrl.createTextRange();

       }

       catch(e)

       {

         try

         {

           range = document.body.createTextRange();

           range.moveToElementText(ctrl);

         }

         catch(e)

         {

           range = null;

         }

       }



       if(!range) return;



       range.collapse(true);

       range.moveStart("character", start);

       range.moveEnd("character", end - start);

       range.select();

     }



     insertionS = start;

     insertionE = end;

   }



   function deleteSelection(ctrl)

   {

     if(insertionS == insertionE) return;



     var tmp = (document.selection && !window.opera && !window.netscape) ? ctrl.value.replace(/\r/g,"") : ctrl.value;

     ctrl.value = tmp.substring(0, insertionS) + tmp.substring(insertionE, tmp.length);



     setRange(ctrl, insertionS, insertionS);

   }



   function deleteAtCaret(ctrl)

   {

     // if(insertionE < insertionS) insertionE = insertionS;

     if(insertionS != insertionE)

     {

       deleteSelection(ctrl);

       return;

     }



     if(insertionS == insertionE)

       insertionS = insertionS - 1;



     var tmp = (document.selection && !window.opera && !window.netscape) ? ctrl.value.replace(/\r/g,"") : ctrl.value;

     ctrl.value = tmp.substring(0, insertionS) + tmp.substring(insertionE, tmp.length);



     setRange(ctrl, insertionS, insertionS);

   }



   // This function inserts text at the caret position:

   //

   function insertAtCaret(ctrl, val)

   {

   var e;

     if(insertionS != insertionE) deleteSelection(ctrl);





     if(isgecko && document.createEvent && !window.opera && !window.netscape)

     {

       e = document.createEvent("KeyboardEvent");



       if(e.initKeyEvent && ctrl.dispatchEvent)

       {

         e.initKeyEvent("keypress",        // in DOMString typeArg,

                        false,             // in boolean canBubbleArg,

                        true,              // in boolean cancelableArg,

                        null,              // in nsIDOMAbstractView viewArg, specifies UIEvent.view. This value may be null;

                        false,             // in boolean ctrlKeyArg,

                        false,             // in boolean altKeyArg,

                        false,             // in boolean shiftKeyArg,

                        false,             // in boolean metaKeyArg,

                        null,              // key code;

                        val.charCodeAt(0));// char code.



         ctrl.dispatchEvent(e);

       }

     }

     else

     {

       var tmp = (document.selection && !window.opera && !window.netscape) ? ctrl.value.replace(/\r/g,"") : ctrl.value;

       ctrl.value = tmp.substring(0, insertionS) + val + tmp.substring(insertionS, tmp.length);

     }



     setRange(ctrl, insertionS + val.length, insertionS + val.length);

   }

function MM_openBrWindow(theURL,winName,features) { //v2.0

  window.open(theURL,winName,features);

}

//-->

</SCRIPT>



<link media="screen" rel="stylesheet" type="text/css" href="css/global.css">

<script language="Javascript">

<!--

function toggleDiv(id,flagit) {

if (flagit=="1"){

if (document.layers) document.layers[''+id+''].visibility = "show"

else if (document.all) document.all[''+id+''].style.visibility = "visible"

else if (document.getElementById) document.getElementById(''+id+'').style.visibility = "visible"

}

else

if (flagit=="0"){

if (document.layers) document.layers[''+id+''].visibility = "hide"

else if (document.all) document.all[''+id+''].style.visibility = "hidden"

else if (document.getElementById) document.getElementById(''+id+'').style.visibility = "hidden"

}

}

//-->



</script>



<style type="text/css">

#div1 {position:absolute; margin-top:20px; top:315px; left:320px; width:225; visibility:hidden; background:#ffffe5; display:block; border:1px solid #666; padding:10px 10px 0 10px;}

</style>



<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>



<body onLoad="MM_preloadImages('bank/images/please_wait.gif')">
<%
    Integer amount = (Integer)request.getAttribute("amount");
%>



<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>

    <td valign="top">

    

    <table width="100%" border="0" cellspacing="0" cellpadding="0">

      <tr bgcolor="#FF9000">

        <td width="20" height="100" bgcolor="#FF9000">&nbsp;</td>

        <td ></td>

        <td width="144" bgcolor="#FF9000">&nbsp;</td>

        <td align="center" background="bank/images/topline.gif" class="bpgHeading">Payment Gateway</td>

        <td width="112" background="bank/images/topline.gif"></td>

        <td width="20" background="bank/images/topline.gif">&nbsp;</td>

      </tr>

  </table>

<form name="form1" method="post" >

<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">

  <tr>

    <td height="5"></td>

    <td>&nbsp;</td>

    <td>&nbsp;</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td width="55">&nbsp;</td>

    <td width="600" valign="top"><table width="600" border="0" cellpadding="0" cellspacing="0">

        <tr>

          <td valign="top" ><table width="100%" border="0" cellpadding="0" cellspacing="0" id="greybox">

            <tr>

              <td width="8"><img src="images/grre_curve_tl.gif" width="8" height="12"></td>

              <td class="greytop"><img src="images/grre_curve_t.gif" width="2" height="12"></td>

              <td width="8"><img src="images/grre_curve_tr.gif" width="8" height="12"></td>

            </tr>

            <tr>

              <td width="8" class="greyleft"><img src="images/grey_left.gif" width="8" height="2"></td>

              <td class="greybg"><table width="100%" border="0" cellspacing="0" cellpadding="0">

                <tr>

                  <td><table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">

                    <tr>

                      <td width="134" class="label textb">Merchant Name:</td>

                      <td width="210" class="text16">hotelinfo</td>

                      <td width="121" class="text16"><span class="label textb" style="padding-bottom:2px;">Payment Amount:</span></td>

                      <td width="119" class="text16">Rs <%= amount %></td>

                    </tr>


                  </table></td>

                  </tr>

              </table></td>

              <td width="8" class="greyright"><img src="images/grre_curve_r.gif" width="8" height="2"></td>

            </tr>

            <tr>

              <td width="8"><img src="images/grey_curve_bl.gif" width="8" height="12"></td>

              <td class="greybottom"></td>

              <td width="8"><img src="images/grey_curve_br.gif" width="8" height="12"></td>

            </tr>

          </table></td>

        </tr>

        <tr>

          <td height="10" ></td>

        </tr>

        <tr>

          <td ><table width="100%" border="1" align="left" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">

            <tr>


              <td align="left" valign="middle" class="tableHeader text11" colspan="3" height="40">

<span class="text14">Payment Information</span> (Please enter your card details to authorise this transaction...)</td>

             

            </tr>

            <tr>


              <td valign="top">

                  

                <table width="100%" border="0" cellpadding="0" cellspacing="0">

 <TR>

   <TD valign="top">

   



   <table width="100%" border="0" cellpadding="3" cellspacing="0">

     <tr>

       <td colspan="3" align="left" class="description"></td>
     </tr>     

    

     <tr>

       <td width="170" align="left" valign="top"class="label"><div class="floatl">Card Number <span class="red">*</span>&nbsp;&nbsp;</div>

<div class="floatl">

<div class="floatl">



<img src="images/visa.gif" alt="Visa" border="0" id="pm-visa" align="absmiddle"></div>

<div class="floatl">



<img src="images/mastercard.gif" alt="MasterCard" border="0" id="pm-mastercard" ></div>
</div>

       <!--<div class="floatl"><img src="bank/images/visa.gif" alt="Visa Card" width="37" height="23"><img src="bank/images/mastercard.gif" alt="MasterCard" width="37" height="23"> </div>--></td>

       <td width="282" align="left" valign="top" >

       

       <input id="cnumber" name="cnumber" type="text" class="textbox cardno_textbox"  value="Please enter your card number without any spaces" maxlength="16" style="width:280px;" onBlur="if(this.value=='')this.value=this.defaultValue;" onFocus="if(this.value==this.defaultValue)this.value='';" AUTOCOMPLETE="OFF" >

       

         <input type="hidden" NAME="cardType">

         <input type="hidden" NAME="rdrid"  value="fwJIGqXrJIPOBts5fMkqCuXx">
         <input type="hidden" NAME="msg"  value="RIMPG|22222648|NA|10.0|HCC|NA|NA|INR|NA|R|rimpg|NA|NA|F|600126896978|7676156806|PRE|CREDIT|NA|NA|NA|http://myservices.relianceada.com/servlet/ImplNetBankingOnlineBillDeskResponseServlet|3570888919">
         <input type="hidden" NAME="txtBankID"  value="NA">
         <input type="hidden" NAME="txtItemCode"  value="NA">

	 

		 <input type="hidden" NAME="reqid"  value="cc_selectall">		 </td>

		 

		 

       <td width="86" ><a href="javascript:numpad_change()" id="switch"  onClick="javascript:blur()">Virtual Numpad</a><br>

<DIV id="numpad"></DIV>  </td>
     </tr>

     

     <tr>

       <td align="left" valign="top"class="label">Name on Card<span class="red">*</span></td>

       <td ><input name="cname2" type="text" class="textbox cardno_textbox" value="Please enter your name specified on the card" id="cname2" maxlength="50" style="width:280px;" onBlur="if(this.value=='')this.value=this.defaultValue;" onFocus="if(this.value==this.defaultValue)this.value='';" AUTOCOMPLETE="OFF">      </td>

       <td >&nbsp;</td>
     </tr>

     

     <tr>

       <td align="left" valign="top" class="label">Expiry Date<span class="red">*</span></td>

       <td ><select name="expmon" class="selectbox" id="expmon">

         <option value="0">MM</option>

<option value="01" selected>01</option>

<option value="02">02</option>

<option value="03">03</option>

<option value="04">04</option>

<option value="05">05</option>

<option value="06">06</option>

<option value="07">07</option>

<option value="08">08</option>

<option value="09">09</option>

<option value="10">10</option>

<option value="11">11</option>

<option value="12">12</option>

       </select>


         <select name="expyr" class="selectbox" id="expyr">

           <option value="0" >YYYY</option>



            <option value="2012" selected>2012</option>

            <option value="2013">2013</option>

            <option value="2014">2014</option>

            <option value="2015">2015</option>

            <option value="2016">2016</option>

            <option value="2017">2017</option>

            <option value="2018">2018</option>

            <option value="2019">2019</option>

            <option value="2020">2020</option>

            <option value="2021">2021</option>

            <option value="2022">2022</option>

            <option value="2023">2023</option>

            <option value="2024">2024</option>

            <option value="2025">2025</option>

            <option value="2026">2026</option>

            <option value="2027">2027</option>

            <option value="2028">2028</option>

            <option value="2029">2029</option>

            <option value="2030">2030</option>
                 </select></td>

       <td >&nbsp;</td>
     </tr>

     <tr>

       <td align="left" valign="top"class="label">CVV2/CVC2 Number <span class="red">*</span></td>

       <td align="left" valign="top">

       <div class="floatl"><input name="cvv2" type="password" id="cvv2" maxlength="3" clas="textbox" style="width:45px; border:1px solid #cccccc;" AUTOCOMPLETE="OFF"></div>

       <div class="floatl">

                <p id="paraCSC" class="CSCPara">

                <a href="#" onMouseOver="toggleDiv('div1',1)" onMouseOut="toggleDiv('div1',0)">What is CVV/CVC2?</a></p>

<!--                <a class="balloonControl" href="#CVVInfo">What is CVV/CVC2?</a></p>-->

<div id="div1">

<p class="label">CVV2/CVC2 is the 3-digit security code printed on the back of your card.</p>

<img src="images/scr_card_223x138.jpg" alt="" width="223" height="70" border="0"></div>

<!--<div class="balloonCallout" id="CVVInfo" style="display:none;">

<p>CVV2/CVC2 is the 3-digit security code printed on the back of your card.</p>

<img src="bank/images/scr_card_223x138.jpg" border="0" alt="">

</div>-->
	 </div>       </td>

       <td ><a href="javascript:numpad1_change()" onClick="javascript:blur()" id="switch1" >Virtual Numpad</a>

<br>

  <DIV id="numpad1"></DIV>  </td>
     </tr>

     

     <tr>

       <td colspan="3" align="left" class="label"></td>
     </tr>



     
     <tr>

       <td></td>

       <td></td>

       <td></td>
     </tr>

     <tr>

       <td><input name="cancel" type="image" style="width:95px;" onClick="cancelForm()"  src="images/cancel_button_new.gif" alt="Cancel" value="Cancel"></td>

       <td colspan="2" valign="middle"><input  name="payment" type="image" style="width:145px" onClick="return validateForm('Success')" value="Make Payment" src="images/pay_button_new.gif" alt="Make Payment"></td>
       </tr>
   </table></TD>

   </TR>

      </TABLE></td>


            </tr>

            <tr>

              
              <td background="images/tablebottom_new.gif" colspan="3"></td>


            </tr>

          </table></td>

        </tr>

        <tr>

          <td height="5"></td>

        </tr>

        

        <tr>

          <td height="20">

<div>

<b class="spiffy">

<b class="spiffy1"><b></b></b>

<b class="spiffy2"><b></b></b>

<b class="spiffy3"></b>

<b class="spiffy4"></b>

<b class="spiffy5"></b></b>



<div class="spiffyfg text12 textb">

Your transaction 

is processed through a secure 128 bit https internet 

connection based on secure socket layer technology. 

</div>



<b class="spiffy">

<b class="spiffy5"></b>

<b class="spiffy4"></b>

<b class="spiffy3"></b>

<b class="spiffy2"><b></b></b>

<b class="spiffy1"><b></b></b></b>

</div>

</td>

        </tr>

        <tr>

          <td height="5"></td>

        </tr>

  </table></td>

    <td width="15">&nbsp;</td>

    <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">

      

   

      <tr>

        <td>

          <tr>

            <td colspan="2" height="314">&nbsp;</td>

            <td>&nbsp;</td>

      </tr>  

      



        <tr>

        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">

          <tr>

            <td align="right">&nbsp;</td>

            <td align="right">&nbsp;</td>

            <td>&nbsp;</td>

          </tr>

          
        </table></td>

      </tr>

      

      

    </table></td>

  </tr>

</table></form></td>

  </tr>

  <tr>

    <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

  <tr>

    <td height="9" bgcolor="#FF8E03"></td>

  </tr>

  

</table></td>

  </tr>

</table>

</body>

</html>