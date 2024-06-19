package org.apache.jsp.chapter05;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/c.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl.release();
    _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.release();
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

      out.write('\n');
      out.write('\n');
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<h4>Chapter 5:  Controlling flow with loops</h4>\n");
      out.write("<a href=\"../index.jsp\">[Return to main page]</a>\n");
      out.write("\n");
      out.write("<ul>\n");
      out.write("  ");
      if (_jspx_meth_c_005fimport_005f1(_jspx_page_context))
        return;
      out.write('\n');
      out.write(' ');
      out.write(' ');
      if (_jspx_meth_c_005fimport_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</ul>\n");
      out.write("\n");
      if (_jspx_meth_c_005fimport_005f3(_jspx_page_context))
        return;
      out.write('\n');
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

  private boolean _jspx_meth_c_005fimport_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.el.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.el.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.el.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    _jspx_th_c_005fimport_005f0.setUrl("../header.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
      if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fimport_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.el.core.ImportTag _jspx_th_c_005fimport_005f1 = (org.apache.taglibs.standard.tag.el.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl.get(org.apache.taglibs.standard.tag.el.core.ImportTag.class);
    _jspx_th_c_005fimport_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f1.setParent(null);
    _jspx_th_c_005fimport_005f1.setUrl("/link.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f1 = _jspx_th_c_005fimport_005f1.doStartTag();
      if (_jspx_eval_c_005fimport_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_c_005fimport_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_c_005fimport_005f1[0]++;
          _jspx_th_c_005fimport_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_c_005fimport_005f1.doInitBody();
        }
        do {
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_005fparam_005f0(_jspx_th_c_005fimport_005f1, _jspx_page_context, _jspx_push_body_count_c_005fimport_005f1))
            return true;
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_005fparam_005f1(_jspx_th_c_005fimport_005f1, _jspx_page_context, _jspx_push_body_count_c_005fimport_005f1))
            return true;
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_005fparam_005f2(_jspx_th_c_005fimport_005f1, _jspx_page_context, _jspx_push_body_count_c_005fimport_005f1))
            return true;
          out.write('\n');
          out.write(' ');
          out.write(' ');
          int evalDoAfterBody = _jspx_th_c_005fimport_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_c_005fimport_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_c_005fimport_005f1[0]--;
        }
      }
      if (_jspx_th_c_005fimport_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl.reuse(_jspx_th_c_005fimport_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fparam_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fimport_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fimport_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.el.core.ParamTag _jspx_th_c_005fparam_005f0 = (org.apache.taglibs.standard.tag.el.core.ParamTag) _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.get(org.apache.taglibs.standard.tag.el.core.ParamTag.class);
    _jspx_th_c_005fparam_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fparam_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fimport_005f1);
    _jspx_th_c_005fparam_005f0.setName("chapter");
    _jspx_th_c_005fparam_005f0.setValue("05");
    int _jspx_eval_c_005fparam_005f0 = _jspx_th_c_005fparam_005f0.doStartTag();
    if (_jspx_th_c_005fparam_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fparam_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fimport_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fimport_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.el.core.ParamTag _jspx_th_c_005fparam_005f1 = (org.apache.taglibs.standard.tag.el.core.ParamTag) _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.get(org.apache.taglibs.standard.tag.el.core.ParamTag.class);
    _jspx_th_c_005fparam_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fparam_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fimport_005f1);
    _jspx_th_c_005fparam_005f1.setName("file");
    _jspx_th_c_005fparam_005f1.setValue("scroll.jsp");
    int _jspx_eval_c_005fparam_005f1 = _jspx_th_c_005fparam_005f1.doStartTag();
    if (_jspx_th_c_005fparam_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fparam_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fimport_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fimport_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.el.core.ParamTag _jspx_th_c_005fparam_005f2 = (org.apache.taglibs.standard.tag.el.core.ParamTag) _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.get(org.apache.taglibs.standard.tag.el.core.ParamTag.class);
    _jspx_th_c_005fparam_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fparam_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fimport_005f1);
    _jspx_th_c_005fparam_005f2.setName("desc");
    _jspx_th_c_005fparam_005f2.setValue("<i>paging</i> through numbers");
    int _jspx_eval_c_005fparam_005f2 = _jspx_th_c_005fparam_005f2.doStartTag();
    if (_jspx_th_c_005fparam_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fimport_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.el.core.ImportTag _jspx_th_c_005fimport_005f2 = (org.apache.taglibs.standard.tag.el.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl.get(org.apache.taglibs.standard.tag.el.core.ImportTag.class);
    _jspx_th_c_005fimport_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f2.setParent(null);
    _jspx_th_c_005fimport_005f2.setUrl("/link.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f2 = _jspx_th_c_005fimport_005f2.doStartTag();
      if (_jspx_eval_c_005fimport_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_c_005fimport_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_c_005fimport_005f2[0]++;
          _jspx_th_c_005fimport_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_c_005fimport_005f2.doInitBody();
        }
        do {
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_005fparam_005f3(_jspx_th_c_005fimport_005f2, _jspx_page_context, _jspx_push_body_count_c_005fimport_005f2))
            return true;
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_005fparam_005f4(_jspx_th_c_005fimport_005f2, _jspx_page_context, _jspx_push_body_count_c_005fimport_005f2))
            return true;
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_005fparam_005f5(_jspx_th_c_005fimport_005f2, _jspx_page_context, _jspx_push_body_count_c_005fimport_005f2))
            return true;
          out.write('\n');
          out.write(' ');
          out.write(' ');
          int evalDoAfterBody = _jspx_th_c_005fimport_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_c_005fimport_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_c_005fimport_005f2[0]--;
        }
      }
      if (_jspx_th_c_005fimport_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl.reuse(_jspx_th_c_005fimport_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fparam_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fimport_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fimport_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.el.core.ParamTag _jspx_th_c_005fparam_005f3 = (org.apache.taglibs.standard.tag.el.core.ParamTag) _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.get(org.apache.taglibs.standard.tag.el.core.ParamTag.class);
    _jspx_th_c_005fparam_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fparam_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fimport_005f2);
    _jspx_th_c_005fparam_005f3.setName("chapter");
    _jspx_th_c_005fparam_005f3.setValue("05");
    int _jspx_eval_c_005fparam_005f3 = _jspx_th_c_005fparam_005f3.doStartTag();
    if (_jspx_th_c_005fparam_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fparam_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fimport_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fimport_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.el.core.ParamTag _jspx_th_c_005fparam_005f4 = (org.apache.taglibs.standard.tag.el.core.ParamTag) _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.get(org.apache.taglibs.standard.tag.el.core.ParamTag.class);
    _jspx_th_c_005fparam_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fparam_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fimport_005f2);
    _jspx_th_c_005fparam_005f4.setName("file");
    _jspx_th_c_005fparam_005f4.setValue("scrollAlternate.jsp");
    int _jspx_eval_c_005fparam_005f4 = _jspx_th_c_005fparam_005f4.doStartTag();
    if (_jspx_th_c_005fparam_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fparam_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fimport_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fimport_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.el.core.ParamTag _jspx_th_c_005fparam_005f5 = (org.apache.taglibs.standard.tag.el.core.ParamTag) _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.get(org.apache.taglibs.standard.tag.el.core.ParamTag.class);
    _jspx_th_c_005fparam_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fparam_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fimport_005f2);
    _jspx_th_c_005fparam_005f5.setName("desc");
    _jspx_th_c_005fparam_005f5.setValue("<i>paging</i> through numbers, alternating rows");
    int _jspx_eval_c_005fparam_005f5 = _jspx_th_c_005fparam_005f5.doStartTag();
    if (_jspx_th_c_005fparam_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fparam_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_c_005fparam_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fimport_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.el.core.ImportTag _jspx_th_c_005fimport_005f3 = (org.apache.taglibs.standard.tag.el.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.el.core.ImportTag.class);
    _jspx_th_c_005fimport_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f3.setParent(null);
    _jspx_th_c_005fimport_005f3.setUrl("../footer.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f3 = _jspx_th_c_005fimport_005f3.doStartTag();
      if (_jspx_th_c_005fimport_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f3.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f3);
    }
    return false;
  }
}
