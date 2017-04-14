package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class indexCheckout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Insert title here</title>\r\n");
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
      out.write("               url:'http://localhost:8080/RestWebService/rest/getCheckoutDetailsJsn?reserID=16030',\r\n");
      out.write("               success: function(data)\r\n");
      out.write("               {\r\n");
      out.write("            \t   document.getElementById(\"dispName\").innerHTML = data.Name;\r\n");
      out.write("            \t   document.getElementById(\"dispRoomNo\").innerHTML = data.Roomno;\r\n");
      out.write("            \t   document.getElementById(\"dispReservationNo\").innerHTML = data.ReservationID;\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"dispCheckindate\").innerHTML = data.Checkindate;\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"dispCheckoutdate\").innerHTML = data.Checkoutdate;\r\n");
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

 String errorMsg = (String)request.getAttribute("errorMsg");

      out.write("\r\n");
      out.write("<body style=\"background:#FFF5EE ;\">\r\n");
      out.write("<h1 align=\"center\">Express Check Out</h1>\r\n");
      out.write("<br></br>\r\n");
      out.write("<br></br>\r\n");
      out.write("<br></br>\r\n");
      out.write("<div style=\"width: 100%; float: center;\">\r\n");
      out.write("<div style=\" float: left; margin-left:25px; width: 45%;\"><a target=\"_blank\" href=\"\"><img src=\"images/Check_out.jpg\" alt=\"checkout\" height=\"630\" width=\"580\" /></a></div>\r\n");
      out.write("<div  style=\"margin-right:10px;  float: right; width: 50%; \">\r\n");
      out.write("<form name=\"checkout\" action = \"InvoiceDetails.jsp\">\r\n");
      out.write("<table align=\"center\" border=\"0\" cellspacing=\"5\" cellpadding=\"25\">\r\n");
      out.write("<tr >\r\n");
      out.write("<td colspan=\"2\" align=\"center\" style=font-size:x-large;><b>Enter Your Details:</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td  align=\"left\"><b>Name: </b></td>\r\n");
      out.write("<td><div id=\"dispName\"></div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td  align=\"left\"><b>Room No.:</b></td>\r\n");
      out.write("<td><div id=\"dispRoomNo\"></div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td  align=\"left\"><b>Reservation No.:</b></td>\r\n");
      out.write("<td><div id=\"dispReservationNo\"></div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td  align=\"left\"><b>Check-In Date:</b></td>\r\n");
      out.write("<td><div id=\"dispCheckindate\"></div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td  align=\"center\"><b>Check-Out Date:</b></td>\r\n");
      out.write("<td><div id=\"dispCheckoutdate\"></div></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr >\r\n");
      out.write("<td  align=\"center\" colspan=\"2\"><input type=\"submit\" name=\"b1\" id=\"bot1\" value=\"Check Out\" />      \r\n");
      out.write("<input type=\"button\" name=\"b2\" id=\"bot2\" value=\"Cancel\" /></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table> \r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html> ");
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
