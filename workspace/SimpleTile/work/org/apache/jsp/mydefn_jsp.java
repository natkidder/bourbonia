package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mydefn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fdefinition_0026_005fpage_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ftiles_005fdefinition_0026_005fpage_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ftiles_005fdefinition_0026_005fpage_005fid.release();
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName.release();
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName_005fnobody.release();
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

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_tiles_005fdefinition_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_tiles_005finsert_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_tiles_005finsert_005f1(_jspx_page_context))
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

  private boolean _jspx_meth_tiles_005fdefinition_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:definition
    org.apache.struts.tiles.taglib.DefinitionTag _jspx_th_tiles_005fdefinition_005f0 = (org.apache.struts.tiles.taglib.DefinitionTag) _005fjspx_005ftagPool_005ftiles_005fdefinition_0026_005fpage_005fid.get(org.apache.struts.tiles.taglib.DefinitionTag.class);
    _jspx_th_tiles_005fdefinition_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fdefinition_005f0.setParent(null);
    // /mydefn.jsp(2,0) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fdefinition_005f0.setId("mydefn1");
    // /mydefn.jsp(2,0) name = page type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fdefinition_005f0.setPage("layoutDefn.jsp");
    int _jspx_eval_tiles_005fdefinition_005f0 = _jspx_th_tiles_005fdefinition_005f0.doStartTag();
    if (_jspx_eval_tiles_005fdefinition_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\r\n");
        out.write("\t");
        if (_jspx_meth_tiles_005fput_005f0(_jspx_th_tiles_005fdefinition_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f1(_jspx_th_tiles_005fdefinition_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f2(_jspx_th_tiles_005fdefinition_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f3(_jspx_th_tiles_005fdefinition_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f4(_jspx_th_tiles_005fdefinition_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_tiles_005fdefinition_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_tiles_005fdefinition_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fdefinition_0026_005fpage_005fid.reuse(_jspx_th_tiles_005fdefinition_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fdefinition_0026_005fpage_005fid.reuse(_jspx_th_tiles_005fdefinition_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fdefinition_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f0 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fdefinition_005f0);
    // /mydefn.jsp(4,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f0.setName("title");
    // /mydefn.jsp(4,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f0.setValue("JTutor.net - Using Definition in Tiles");
    int _jspx_eval_tiles_005fput_005f0 = _jspx_th_tiles_005fput_005f0.doStartTag();
    if (_jspx_th_tiles_005fput_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fdefinition_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f1 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fdefinition_005f0);
    // /mydefn.jsp(5,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f1.setName("header");
    // /mydefn.jsp(5,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f1.setValue("header.jsp");
    int _jspx_eval_tiles_005fput_005f1 = _jspx_th_tiles_005fput_005f1.doStartTag();
    if (_jspx_th_tiles_005fput_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fdefinition_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f2 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f2.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fdefinition_005f0);
    // /mydefn.jsp(6,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f2.setName("footer");
    // /mydefn.jsp(6,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f2.setValue("footer.jsp");
    int _jspx_eval_tiles_005fput_005f2 = _jspx_th_tiles_005fput_005f2.doStartTag();
    if (_jspx_th_tiles_005fput_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f2);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fdefinition_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f3 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f3.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fdefinition_005f0);
    // /mydefn.jsp(7,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f3.setName("menu");
    // /mydefn.jsp(7,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f3.setValue("menu.jsp");
    int _jspx_eval_tiles_005fput_005f3 = _jspx_th_tiles_005fput_005f3.doStartTag();
    if (_jspx_th_tiles_005fput_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f3);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005fdefinition_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f4 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f4.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005fdefinition_005f0);
    // /mydefn.jsp(8,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f4.setName("body");
    // /mydefn.jsp(8,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f4.setValue("body.jsp");
    int _jspx_eval_tiles_005fput_005f4 = _jspx_th_tiles_005fput_005f4.doStartTag();
    if (_jspx_th_tiles_005fput_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f4);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsert_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f0 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f0.setParent(null);
    // /mydefn.jsp(11,0) name = beanName type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f0.setBeanName("mydefn1");
    // /mydefn.jsp(11,0) name = flush type = boolean reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f0.setFlush(true);
    int _jspx_eval_tiles_005finsert_005f0 = _jspx_th_tiles_005finsert_005f0.doStartTag();
    if (_jspx_eval_tiles_005finsert_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f5(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_tiles_005fput_005f6(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_tiles_005finsert_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_tiles_005finsert_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName.reuse(_jspx_th_tiles_005finsert_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName.reuse(_jspx_th_tiles_005finsert_005f0);
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
    // /mydefn.jsp(12,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f5.setName("title");
    // /mydefn.jsp(12,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f5.setValue("Using overloaded definitions in tiles");
    int _jspx_eval_tiles_005fput_005f5 = _jspx_th_tiles_005fput_005f5.doStartTag();
    if (_jspx_th_tiles_005fput_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f5);
    return false;
  }

  private boolean _jspx_meth_tiles_005fput_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:put
    org.apache.struts.tiles.taglib.PutTag _jspx_th_tiles_005fput_005f6 = (org.apache.struts.tiles.taglib.PutTag) _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(org.apache.struts.tiles.taglib.PutTag.class);
    _jspx_th_tiles_005fput_005f6.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fput_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsert_005f0);
    // /mydefn.jsp(13,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f6.setName("body");
    // /mydefn.jsp(13,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fput_005f6.setValue("newbody.jsp");
    int _jspx_eval_tiles_005fput_005f6 = _jspx_th_tiles_005fput_005f6.doStartTag();
    if (_jspx_th_tiles_005fput_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f6);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsert_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.tiles.taglib.InsertTag _jspx_th_tiles_005finsert_005f1 = (org.apache.struts.tiles.taglib.InsertTag) _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName_005fnobody.get(org.apache.struts.tiles.taglib.InsertTag.class);
    _jspx_th_tiles_005finsert_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsert_005f1.setParent(null);
    // /mydefn.jsp(15,0) name = beanName type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f1.setBeanName("mydefn1");
    // /mydefn.jsp(15,0) name = flush type = boolean reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsert_005f1.setFlush(true);
    int _jspx_eval_tiles_005finsert_005f1 = _jspx_th_tiles_005finsert_005f1.doStartTag();
    if (_jspx_th_tiles_005finsert_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName_005fnobody.reuse(_jspx_th_tiles_005finsert_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fflush_005fbeanName_005fnobody.reuse(_jspx_th_tiles_005finsert_005f1);
    return false;
  }
}
