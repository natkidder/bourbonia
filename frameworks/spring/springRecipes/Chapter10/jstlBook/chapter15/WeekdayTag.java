package com.jstlbook.examples;

import java.util.*;
import javax.servlet.jsp.JspTagException;

public class WeekdayTag
  extends javax.servlet.jsp.jstl.core.ConditionalTagSupport {

    public boolean condition() throws JspTagException {
        Calendar now = Calendar.getInstance();
        if (now.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            return false;
        if (now.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            return false;
        return true;
    }

}

