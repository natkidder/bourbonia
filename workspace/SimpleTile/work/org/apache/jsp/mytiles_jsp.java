package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mytiles_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage_005fflush;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fputList_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage_005fflush = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005fputList_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage_005fflush.release();
    _005fjspx_005ftagPool_005ftiles_005fputList_0026_005fname.release();
    _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("   \r\n");
      out.write("\r\n");
      if (_jspx_meth_tiles_005finsert_005f0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_tiles_005finsert_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f0 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage_005fflush.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f0.setParent(null);
    // /mytiles.jsp(6,0) name = page type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f0.setPage("Layout.jsp");
    // /mytiles.jsp(6,0) name = flush type = boolean reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f0.setFlush(true);
    int _jspx_eval_tiles_005finsert_005f0 = _jspx_th_tiles_005finsert_005f0.doStartTag();
    if (_jspx_eval_tiles_005finsert_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fputList_005f0(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f0(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f1(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f2(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f3(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f4(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f5(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_tiles_005finsert_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_tiles_005finsert_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage_005fflush.reuse(_jspx_th_tiles_005finsert_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage_005fflush.reuse(_jspx_th_tiles_005finsert_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fputList_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:putList
    org.apache.struts.tiles.taglib.PutListTag _jspx_th_tiles_005fputList_005f0 = (org.apache.struts.tiles.taglib.PutListTag) _005fjspx_005ftagPool_005ftiles_005fputList_0026_005fname.get(org.apache.struts.tiles.taglib.PutListTag.class);
    _jspx_th_tiles_005fputList_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fputList_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsert_005f0);
    // /mytiles.jsp(7,1) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fputList_005f0.setName("j2ee");
    int _jspx_eval_tiles_005fputList_005f0 = _jspx_th_tiles_005fputList_005f0.doStartTag();
    if (_jspx_eval_tiles_005fputList_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_tiles_005fadd_005f0(_jspx_th_tiles_005fputList_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_tiles_005fadd_005f1(_jspx_th_tiles_005fputList_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_tiles_005fadd_005f2(_jspx_th_tiles_005fputList_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_tiles_005fadd_005f3(_jspx_th_tiles_005fputList_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        int evalDoAfterBody = _jspx_th_tiles_005fputList_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_tiles_005fputList_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fputList_0026_005fname.reuse(_jspx_th_tiles_005fputList_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fputList_0026_005fname.reuse(_jspx_th_tiles_005fputList_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fadd_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fputList_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:add
    org.apache.struts.tiles.taglib.AddTag _jspx_th_tiles_005fadd_005f0 = (org.apache.struts.tiles.taglib.AddTag) _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.get(org.apache.struts.tiles.taglib.AddTag.class);
    _jspx_th_tiles_005fadd_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fadd_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fputList_005f0);
    // /mytiles.jsp(8,2) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fadd_005f0.setValue("Servlets");
    int _jspx_eval_tiles_005fadd_005f0 = _jspx_th_tiles_005fadd_005f0.doStartTag();
    if (_jspx_th_tiles_005fadd_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.reuse(_jspx_th_tiles_005fadd_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.reuse(_jspx_th_tiles_005fadd_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fadd_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fputList_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:add
    org.apache.struts.tiles.taglib.AddTag _jspx_th_tiles_005fadd_005f1 = (org.apache.struts.tiles.taglib.AddTag) _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.get(org.apache.struts.tiles.taglib.AddTag.class);
    _jspx_th_tiles_005fadd_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fadd_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fputList_005f0);
    // /mytiles.jsp(9,2) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fadd_005f1.setValue("JSP");
    int _jspx_eval_tiles_005fadd_005f1 = _jspx_th_tiles_005fadd_005f1.doStartTag();
    if (_jspx_th_tiles_005fadd_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.reuse(_jspx_th_tiles_005fadd_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.reuse(_jspx_th_tiles_005fadd_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005fadd_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fputList_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:add
    org.apache.struts.tiles.taglib.AddTag _jspx_th_tiles_005fadd_005f2 = (org.apache.struts.tiles.taglib.AddTag) _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.get(org.apache.struts.tiles.taglib.AddTag.class);
    _jspx_th_tiles_005fadd_005f2.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fadd_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fputList_005f0);
    // /mytiles.jsp(10,2) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fadd_005f2.setValue("Struts");
    int _jspx_eval_tiles_005fadd_005f2 = _jspx_th_tiles_005fadd_005f2.doStartTag();
    if (_jspx_th_tiles_005fadd_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.reuse(_jspx_th_tiles_005fadd_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.reuse(_jspx_th_tiles_005fadd_005f2);
    return false;
  }

  private boolean _jspx_meth_tiles_005fadd_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fputList_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:add
    org.apache.struts.tiles.taglib.AddTag _jspx_th_tiles_005fadd_005f3 = (org.apache.struts.tiles.taglib.AddTag) _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.get(org.apache.struts.tiles.taglib.AddTag.class);
    _jspx_th_tiles_005fadd_005f3.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fadd_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fputList_005f0);
    // /mytiles.jsp(11,2) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fadd_005f3.setValue("EJB");
    int _jspx_eval_tiles_005fadd_005f3 = _jspx_th_tiles_005fadd_005f3.doStartTag();
    if (_jspx_th_tiles_005fadd_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.reuse(_jspx_th_tiles_005fadd_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fadd_0026_005fvalue_005fnobody.reuse(_jspx_th_tiles_005fadd_005f3);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f0 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsert_005f0);
    // /mytiles.jsp(13,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f0.setName("title");
    // /mytiles.jsp(13,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f0.setValue("JTutor.net - My First Tiles Application");
    int _jspx_eval_tiles_005fput_005f0 = _jspx_th_tiles_005fput_005f0.doStartTag();
    if (_jspx_th_tiles_005fput_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f1 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsert_005f0);
    // /mytiles.jsp(14,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f1.setName("header");
    // /mytiles.jsp(14,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f1.setValue("header.jsp");
    int _jspx_eval_tiles_005fput_005f1 = _jspx_th_tiles_005fput_005f1.doStartTag();
    if (_jspx_th_tiles_005fput_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f2 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f2.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsert_005f0);
    // /mytiles.jsp(15,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f2.setName("footer");
    // /mytiles.jsp(15,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f2.setValue("footer.jsp");
    int _jspx_eval_tiles_005fput_005f2 = _jspx_th_tiles_005fput_005f2.doStartTag();
    if (_jspx_th_tiles_005fput_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f2);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f3 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f3.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsert_005f0);
    // /mytiles.jsp(16,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f3.setName("menu");
    // /mytiles.jsp(16,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f3.setValue("menu.jsp");
    int _jspx_eval_tiles_005fput_005f3 = _jspx_th_tiles_005fput_005f3.doStartTag();
    if (_jspx_th_tiles_005fput_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f3);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f4 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f4.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsert_005f0);
    // /mytiles.jsp(17,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f4.setName("body");
    // /mytiles.jsp(17,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f4.setValue("body.jsp");
    int _jspx_eval_tiles_005fput_005f4 = _jspx_th_tiles_005fput_005f4.doStartTag();
    if (_jspx_th_tiles_005fput_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f4);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f5 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f5.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsert_005f0);
    // /mytiles.jsp(18,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f5.setName("website");
    // /mytiles.jsp(18,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f5.setValue("www.JTutor.net");
    int _jspx_eval_tiles_005fput_005f5 = _jspx_th_tiles_005fput_005f5.doStartTag();
    if (_jspx_th_tiles_005fput_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f5);
    return false;
  }
}
