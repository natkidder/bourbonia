package com.jstlbook.examples;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.JspTagException;

public class ForEachLineTag
  extends javax.servlet.jsp.jstl.core.LoopTagSupport {

  private String filename;
  private BufferedReader input;

  public void setFilename(String s) {
    filename = s;
  }

  protected void prepare() throws JspTagException {
    try {
      if (input != null)
        input.close();
      input = new BufferedReader(new FileReader(filename));
    } catch (IOException ex) {
      throw new JspTagException(ex.toString());
    }
  }

  public void release() {
    try {
      if (input != null)
        input.close();
    } catch (IOException ex) {
      // ignore
    }
  }

  protected boolean hasNext() throws JspTagException {
    try {
      return input.ready();
    } catch (IOException ex) {
      throw new JspTagException(ex.toString());
    }
  }

  protected Object next() throws JspTagException {
    try {
      return input.readLine();
    } catch (IOException ex) {
      throw new JspTagException(ex.toString());
    }
  }

}

