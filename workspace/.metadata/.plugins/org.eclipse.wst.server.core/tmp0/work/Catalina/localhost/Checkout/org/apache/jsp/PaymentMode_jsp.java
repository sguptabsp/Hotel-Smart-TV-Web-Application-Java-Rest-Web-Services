package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.tcs.beans.InvoiceBean;;

public final class PaymentMode_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/tb.css\" />\r\n");
      out.write("</head>\r\n");

	InvoiceBean bean = (InvoiceBean) request.getAttribute("bean");

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function submitForm(btnName)\r\n");
      out.write("\r\n");
      out.write("  {\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\t     var frm = eval(\"document.forms['ImplInstantPayForm']\");\r\n");
      out.write("\r\n");
      out.write("\t     if(btnName=='Success')\r\n");
      out.write("\t     {\r\n");
      out.write("\t       if(document.getElementById(\"mode\").checked==true)\r\n");
      out.write("\t       {\r\n");
      out.write("\t\t       frm.action=\"CheckOutServlet?amount=\"+");
      out.print( bean.getTotalCharges() );
      out.write("+\"&b1=paynow\";\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t   else\r\n");
      out.write("\t\t   {\r\n");
      out.write("\t\t     document.getElementById(\"errMsg\").innerHTML='Please select payment mode';\r\n");
      out.write("\t\t     return false;\r\n");
      out.write("\t\t     \r\n");
      out.write("\t\t   }\r\n");
      out.write("\r\n");
      out.write("\t     }\r\n");
      out.write("\r\n");
      out.write("\t     else if(btnName=='Cancel')\r\n");
      out.write("\t     {\r\n");
      out.write("\t\t\t\t frm.action=\"CheckOutServlet?b1=Cancel\";\r\n");
      out.write("\t\t }\r\n");
      out.write("\r\n");
      out.write("\t     frm.submit();\r\n");
      out.write("\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function Display()\r\n");
      out.write("{\r\n");
      out.write("\r\n");
      out.write(" document.getElementById(\"Card1\").innerHTML = '<input type=\"radio\" name=\"credit\" value=\"visa\" checked=\"checked\">VISA';\r\n");
      out.write(" document.getElementById(\"Card2\").innerHTML =  '<input type=\"radio\" name=\"credit\" value=\"master\">MASTER';\r\n");
      out.write(" document.getElementById(\"Card3\").innerHTML =  '<input type=\"radio\" name=\"credit\" value=\"americanExpress\">American Express';\r\n");
      out.write("  \r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<h1 align=\"center\">INVOICE DETAILS</h1>\r\n");
      out.write("<div class=\"img\" style=\"margin-left: 0px;\"><a target=\"_blank\"\r\n");
      out.write("\thref=\"\"><img src=\"images/Check_out2.jpg\" alt=\"checkout\"\r\n");
      out.write("\twidth=\"1300px\" height=\"250\" /></a></div>\r\n");
      out.write("<br></br>\r\n");
      out.write("<div align=\"center\" style=\"width:50%; margin-left: 25%\" >\r\n");
      out.write("<form name=\"ImplInstantPayForm\" action=\"\" method=\"post\">\r\n");
      out.write("<table class=\"poptable\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"\r\n");
      out.write("\twidth=\"50%\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Instant Payment</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t   <td><div id=\"errMsg\" style=\"color : red; font-size:15px\"></div>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><!-- Data Display -->\r\n");
      out.write("\r\n");
      out.write("\t\t<table class=\"poptable\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td valign='top' align='left' width=\"100\"><b>Reservation No :</b></td>\r\n");
      out.write("\t\t\t\t<td valign=\"top\" align='left' width=\"200\">");
      out.print( bean.getRegNo() );
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<!--For HSD and DATACARD PrePaid-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr class=\"rowaltbg\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td valign='top' align='left' width=\"100\"><b>Guest Name :</b></td>\r\n");
      out.write("\t\t\t\t<td valign=\"top\" align='left' width=\"200\">");
      out.print( bean.getName() );
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--For HSD and DATACARD PrePaid-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td valign='top' align='left' width=\"100\"><b>Payable Amount :</b></td>\r\n");
      out.write("\t\t\t\t<td valign=\"top\" align='left' width=\"200\"><input type=\"text\" readonly=\"readonly\" name=\"payAmount\" maxlength=\"10\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print( bean.getTotalCharges() );
      out.write("\" id=\"payAmt\" class=\"dtext\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--For HSD and DATACARD PrePaid-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr class=\"rowaltbg\">\r\n");
      out.write("\t\t\t\t<td valign='top' align='left'  width=\"100\"><b>Payment Mode :</b></td>\r\n");
      out.write("\t\t\t\t<td valign=\"top\" align='left' width=\"300\"><input type=\"radio\" name=\"mode\" value=\"creditCard\" id=\"mode\" onclick=\"Display()\">Credit Card &nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"mode\" id=\"mode\" value=\"debitCard\" >Debit Card &nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"mode\" id=\"mode\" value=\"netBanking\">Net Banking \r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t <td valign=\"top\" align='left' colspan=\"2\">\r\n");
      out.write("\t\t\t <div id=\"msg\"></div>\r\n");
      out.write("\t\t\t </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t <td valign=\"top\" align='left' width=\"150\">\r\n");
      out.write("\t\t\t <div id=\"Card1\"></div>\r\n");
      out.write("\t\t\t </td>\r\n");
      out.write("\t\t\t <td valign=\"top\" align='left' width=\"200\">\r\n");
      out.write("\t\t\t <div id=\"Card2\"></div>\r\n");
      out.write("\t\t\t </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t <td valign=\"top\" align='left' width=\"150\">\r\n");
      out.write("\t\t\t <div id=\"Card3\"></div>\r\n");
      out.write("\t\t\t </td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--For HSD and DATACARD PrePaid-->\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" align=\"right\" style=\"padding: 5px 0;\" id=\"buttonID\"><a><img\r\n");
      out.write("\t\t\t\t\tsrc=\"images/b_paynow.jpg\" class=\"hand m_r10\"\r\n");
      out.write("\t\t\t\t\tborder=\"0\" onClick=\"submitForm('Success');\" /></a> <a><img\r\n");
      out.write("\t\t\t\t\tsrc=\"images/b_cancel.jpg\" class=\"hand\" border=\"0\"\r\n");
      out.write("\t\t\t\t\tonClick=\"submitForm('Cancel');\" /></a></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
