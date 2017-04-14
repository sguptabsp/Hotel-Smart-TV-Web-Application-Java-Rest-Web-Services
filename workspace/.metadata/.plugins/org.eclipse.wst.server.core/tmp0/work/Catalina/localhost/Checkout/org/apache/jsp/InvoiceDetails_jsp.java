package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tcs.beans.InvoiceBean;;

public final class InvoiceDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Invoice Details</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"  />\r\n");
      out.write("<script src=\"js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function () {\r\n");
      out.write("    \r\n");
      out.write("    testService();\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function testService()\r\n");
      out.write("       {\r\n");
      out.write("           $.ajax(\r\n");
      out.write("           {\r\n");
      out.write("               dataType: 'json',\r\n");
      out.write("               headers: {\r\n");
      out.write("                   Accept:\"application/json\",\r\n");
      out.write("                   \"Access-Control-Allow-Origin\": \"*\"\r\n");
      out.write("               },\r\n");
      out.write("               type:'GET',\r\n");
      out.write("               url:'http://localhost:8080/RestWebService/rest/getInvoiceChkoutJson?reserID=16030',\r\n");
      out.write("               success: function(data)\r\n");
      out.write("               {\r\n");
      out.write("                  \r\n");
      out.write("            \t   document.getElementById(\"dispGuest\").innerHTML = data.Name;\r\n");
      out.write("            \t   document.getElementById(\"dispRoomId\").innerHTML = data.Roomno;\r\n");
      out.write("            \t   document.getElementById(\"dispRsrvNo\").innerHTML = data.ReservationID;\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"dispMealC\").innerHTML = data.meal_charges;\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"dispSpaC\").innerHTML = data.spa_charges;\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"dispRoomC\").innerHTML = data.room_per_day_charges;\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"dispTotal\").innerHTML = data.Total;\r\n");
      out.write("\t\t\t\t\t//document.writeln(\"Room no : \" + data.Roomno);\r\n");
      out.write("                   //document.writeln(\"CheckIndate : \" + data.CheckIndate);\r\n");
      out.write("                  // document.writeln(\"CheckOutdate : \" + data.CheckOutdate);\r\n");
      out.write("\t\t\t\t\t//document.writeln(\"ReservationID : \" + data.ReservationID);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("               },\r\n");
      out.write("               error: function(data)\r\n");
      out.write("               {\r\n");
      out.write("                   alert(\"error\");\r\n");
      out.write("               }\r\n");
      out.write("           });\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1 align=\"center\">INVOICE DETAILS</h1>\r\n");
      out.write("<div class=\"img\" style=\"margin-left: 0px;\"><a target=\"_blank\"\r\n");
      out.write("\thref=\"\"><img src=\"images/Check_out2.jpg\" alt=\"checkout\"\r\n");
      out.write("\twidth=\"1300px\" height=\"250\" /></a></div>\r\n");
      out.write("<br></br>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<form name=\"checkout\" action=\"PaymentMode.jsp\" >\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\" cellspacing=\"0\" width=\"600px\" height=\"390px\">\r\n");
      out.write("\t<tr style=\"background-color: #ffffff;\">\r\n");
      out.write("\t\t<td width=\"600px\">\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t   <table border=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t  <tr height=\"25px\" style=\"background-color: #ffffff;\"></tr>\r\n");
      out.write("\t\t\t  <tr style=\"background-color: #ffffff;\">\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"right\" valign=\"\">\r\n");
      out.write("\t\t\t\t   <font size=\"5\" color=\"#6e6e11\" style=\"font-style: italic\"><b>GUEST\r\n");
      out.write("\t\t\t\tFOLIO DETAILS</b> &nbsp;&nbsp;<img src=\"images/logoAllambie.png\"\r\n");
      out.write("\t\t\t\t\theight=\"70px\" width=\"80px\" alt=\"\"\r\n");
      out.write("\t\t\t\t\tstyle=\"margin-left: 70px; margin-right: 10px;\" /> </font>\r\n");
      out.write("\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr style=\"background-color: #ffffff;\">\r\n");
      out.write("\t\t\t\t<td align=\"left\" height=\"60px\" width=\"250px\">\r\n");
      out.write("\t\t\t\t<table border=\"0\" cellspacing=\"0\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td><sub> <img\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"margin-left: 30px; margin-top: 15px;\" alt=\"\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"images/inv.png\" height=\"60px\" width=\"70px\"> </sub></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\" style=\"font-family: Verdana; color: #ffffff;\"><sup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Service\r\n");
      out.write("\t\t\t\t\t\tGuaranteed</sup></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td width=\"410px\">\r\n");
      out.write("\t\t\t\t<table border=\"0\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t<tr height=\"5px\"></tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\" width=\"270px\">Guest Name :</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" style=\"font-size: small\" width=\"140px\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"dispGuest\"></div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">Room :</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"font-size: small\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"dispRoomId\"></div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">Reservation No :</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"left\" style=\"font-size: small\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"dispRsrvNo\"></div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr style=\"background-color: #ffffff;\">\r\n");
      out.write("\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t<table border=\"1\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t<td width=\"540px\" align=\"left\">&nbsp;&nbsp;<b>Description</b></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"200px\" align=\"left\">&nbsp;&nbsp;<b>Service</b></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"250px\" align=\"center\"><b>Amount </b><font size=\"1\">(in\r\n");
      out.write("\t\t\t\t\t\tRs.)</font></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"3\" bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"invoiceDisp\">\r\n");
      out.write("\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t\t\t<table border=\"1\" cellspacing=\"0\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"350px\">\r\n");
      out.write("\t\t\t\t\t\t<table border=\"0\" cellspacing=\"0\" style=\"font-size: small\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td valign=\"middle\">Make all payments through cash, credit\r\n");
      out.write("\t\t\t\t\t\t\t\tcard or cheque.<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font size=\"3\" color=\"#006633\" face=\"verdana\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"font-style: italic\"><br>\r\n");
      out.write("\t\t\t\t\t\t\t\tThank you for your business. Wish to serve you again.</br>\r\n");
      out.write("\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t</center>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<table width=\"288px\" border=\"1\" cellspacing=\"0\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"font-size: small\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"118px\">Meal Charges</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"130px\" align=\"center\" bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"dispMealC\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"118px\">Spa Services</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"130px\" align=\"center\" bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"dispSpaC\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"118px\">Room Charges</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"130px\" align=\"center\" bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"dispRoomC\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"118px\">OTHERS</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"130px\" align=\"center\" bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t\t\t12% Tax on Room expenses\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<table width=\"288px\" border=\"1\" cellspacing=\"0\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"font-size: small\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><b>TOTAL</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"center\" bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"dispTotal\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr height=\"10px\" style=\"background-color: #ffffff;\">\r\n");
      out.write("\t\t<td align=\"center\"><input type=\"Submit\" name=\"b1\" id = \"confirm\" value=\"Confirm\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<input type=\"button\" name=\"cancel\" id=\"cancel\" value=\"Cancel\" /></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
