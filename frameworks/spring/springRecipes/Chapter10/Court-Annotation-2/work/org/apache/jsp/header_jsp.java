package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("\n");
      out.write("<title>JSP Standard Tag Library: Learning JSTL</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("<!--\n");
      out.write("body {\n");
      out.write(" Font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 13px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: normal;\n");
      out.write(" color: #000000;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write("td {\n");
      out.write(" font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 13px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: normal;\n");
      out.write(" color: #000000;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write("th {\n");
      out.write(" font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 13px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: bold;\n");
      out.write(" color: #000000;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".normal {\n");
      out.write(" Font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 13px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: normal;\n");
      out.write(" color: #000000;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".menu {\n");
      out.write(" font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 10px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: normal;\n");
      out.write(" color: #cc0000;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".menublack {\n");
      out.write(" font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 10px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: normal;\n");
      out.write(" color: #000000;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".menubold {\n");
      out.write(" font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 11px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: bold;\n");
      out.write(" color: #000000;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".menugrey {\n");
      out.write(" font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 10px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: normal;\n");
      out.write(" color: #999999;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write("b {\n");
      out.write(" font-family: Arial,Helvetica,sans-serif;\n");
      out.write(" font-size: 13px;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" font-weight: bold;\n");
      out.write(" color: #000000;\n");
      out.write(" text-decoration: none\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a:link {\n");
      out.write(" font-family: Arial,Helvetica,san-serif;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" color: #cc0000;\n");
      out.write(" text-decoration: none;\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a:visited {\n");
      out.write(" font-family: Arial,Helvetica,san-serif;\n");
      out.write(" font-style: normal;\n");
      out.write(" line-height: normal;\n");
      out.write(" color: #cc0000;\n");
      out.write(" text-decoration: none;\n");
      out.write(" background:transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a:hover {\n");
      out.write(" text-decoration:underline;\n");
      out.write("}\n");
      out.write("-->\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"#ffffff\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<table border=0 cellpadding=0 cellspacing=0 width=100%>\n");
      out.write("<tr>\n");
      out.write("<td align=\"right\" width=150>\n");
      out.write("<a name=\"top_of_page\">\n");
      out.write("<img src=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" hspace=\"0\" vspace=\"0\">\n");
      out.write("</a></td>\n");
      out.write("\n");
      out.write("<td width=20><img src=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" width=\"16\" hspace=\"0\" vspace=\"0\" height=\"1\"></td>\n");
      out.write("\n");
      out.write("<td valign=top align=\"center\">\n");
      out.write("<a href=\"http://www.manning.com\"><img src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" border=0 alt=\"Manning Publications\"></a>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("<tr><td><img src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" width=\"130\" hspace=\"0\" vspace=\"0\" height=\"12\"></td></tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<td valign=top align=\"right\" width=150>\n");
      out.write("\n");
      out.write("<!-- left column table -->\n");
      out.write("<table cellpadding=0 cellspacing=0 border=0 align=right>\n");
      out.write("\n");
      out.write("<tr><td align=right><div class=\"menubold\">JSP&nbsp;Standard<br>Tag&nbsp;Library:<br>Learning&nbsp;JSTL</td>\n");
      out.write("<tr><td>&nbsp;</td>\n");
      out.write("\n");
      out.write("<tr><td align=right><div class=\"menubold\">Inside&nbsp;the&nbsp;book</div></td>\n");
      out.write("<tr><td align=right><div class=\"menu\"><a \n");
      out.write("href=\"http://www.manning.com/getpage.html?project=bayern&filename=contents.html\">Table&nbsp;of&nbsp;Contents</a></div></td>\n");
      out.write("\n");
      out.write("<tr><td>&nbsp;</td>\n");
      out.write("\n");
      out.write("<tr><td align=right><div class=\"menubold\">About&nbsp;the&nbsp;book</div></td>\n");
      out.write("<tr><td align=\"right\"><div class=\"menu\"><a href=\"http://www.manning.com/bayern/index.html#author\">About&nbsp;the&nbsp;author</a></div></td>\n");
      out.write("<tr><td>&nbsp;</td><tr><td align=\"right\"><div class=\"menubold\"><a href=\"http://www.manning.com\">The Publisher</a></div></td>\n");
      out.write("<tr><td align=\"right\"><div class=\"menu\"><a href=\"http://www.manning.com/forthcoming.html\">In&nbsp;press</a></div></td>\n");
      out.write("<tr><td align=\"right\"><div class=\"menu\"><a href=\"http://www.manning.com/development.html\">Under&nbsp;development</a></div></td>\n");
      out.write("<tr><td align=\"right\"><div class=\"menu\"><a href=\"http://www.manning.com/newbooks.html\">Recently&nbsp;published</a></div></td>\n");
      out.write("<tr><td align=\"right\"><div class=\"menu\"><a href=\"http://www.manning.com/ebooks.html\">ebooks</a></div></td>\n");
      out.write("<tr><td align=\"right\"><div class=\"menu\"><a href=\"http://www.manning.com/catalog_subject.html\">Catalog</a></div></td>\n");
      out.write("<tr><td align=\"right\"><div class=\"menu\"><a href=\"http://www.manning.com/comments.html\">Contact us</a></div></td>\n");
      out.write("\n");
      out.write("\n");
      out.write("<tr><td>&nbsp;</td><tr><td align=right><div class=\"menubold\"><a href=\"http://www.manning.com/mcart/orderpage.html?project=bayern\"> Order</a></div></td>\n");
      out.write("</table>\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("<td></td>\n");
      out.write("<!-- column 3 -->\n");
      out.write("<td valign=top>\n");
      out.write("<table border=0>\n");
      out.write("<tr><td valign=top>\n");
      out.write("<img src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\" alt=\"JSP Standard Tag Library: Learning JSTL\" height=180 width=150 hspace=0 border=0></td>\n");
      out.write("\n");
      out.write("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("<td valign=top>\n");
      out.write("<b><font size=+1>JSP Standard Tag Library: Learning JSTL</font></b><br><b><a href=\"#author\">Shawn Bayern</a></b><br><br>June 2002, Softbound, 400 pages<br>\n");
      out.write("ISBN 1930110529<br>\n");
      out.write("<p>\n");
      out.write("You can order this book from your bookstore<br>\n");
      out.write("by using the ISBN and title listed above.\n");
      out.write("</td>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<p>\n");
      out.write("\n");
      out.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" hspace=\"3\" vspace=\"3\" width=\"280\" align=\"right\">\n");
      out.write("<tr><td align=center>\n");
      out.write("<a href=\"http://www.manning.com/mcart/orderpage.html?project=bayern\"><image src=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\" height=43 width=200 alt=\"Join the Mailing List\" border=0></a>\n");
      out.write("</td>\n");
      out.write("<tr><td align=center>\n");
      out.write("<b><font size=-1>\n");
      out.write("JOIN THE MAILING LIST\n");
      out.write("</b>\n");
      out.write("</td>\n");
      out.write("</table>\n");
      out.write("<table border=0 vspace=3 cellpadding=10 cellspacing=0>\n");
      out.write("<tr bgcolor=\"#e0e0ee\" align=center> \n");
      out.write("<td>Visit the Author's book site: <a \n");
      out.write("href=\"http://www.jstlbook.com\">www.jstlbook.com</a>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<br /> <br />\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    _jspx_th_c_005furl_005f0.setValue("/images/dance_small.gif");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    _jspx_th_c_005furl_005f1.setValue("/images/spacer.gif");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    _jspx_th_c_005furl_005f2.setValue("/images/logo.gif");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    _jspx_th_c_005furl_005f3.setValue("/images/spacer.gif");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    _jspx_th_c_005furl_005f4.setValue("/images/cover150.jpg");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    _jspx_th_c_005furl_005f5.setValue("/images/stay2.jpg");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }
}
