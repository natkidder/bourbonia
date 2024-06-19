package com.jstlbook.examples;

import java.util.*;

public class TimeTag
  extends javax.servlet.jsp.jstl.core.ConditionalTagSupport {

  private int day = -1;
  private int after = -1;
  private int before = -1;

  public void setDay(String s) {
    if (s.equals("sunday"))
      day = Calendar.SUNDAY;
    else if (s.equals("monday"))
      day = Calendar.MONDAY;
    else if (s.equals("tuesday"))
      day = Calendar.TUESDAY;
    else if (s.equals("wednesday"))
      day = Calendar.WEDNESDAY;
    else if (s.equals("thursday"))
      day = Calendar.THURSDAY;
    else if (s.equals("friday"))
      day = Calendar.FRIDAY;
    else if (s.equals("saturday"))
      day = Calendar.SATURDAY;
    else throw new IllegalArgumentException("bad weekday: " + s); 
  }

  public void setBefore(int i) {						
    if (i < 0 || i > 23)							
      throw new IllegalArgumentException("bad hour: " + i);		
    before = i;									
  }											 

  public void setAfter(int i) {
    if (i < 0 || i > 23)
      throw new IllegalArgumentException("bad hour: " + i);
    after = i;
  }

  protected boolean condition() {
    Calendar now = Calendar.getInstance();
    int currentDay = now.get(Calendar.DAY_OF_WEEK);
    int currentHour = now.get(Calendar.HOUR_OF_DAY);

    if (day != -1 && currentDay != day)
      return false;

    if (before != -1 && currentHour >= before)
      return false;

    if (after != -1 && currentHour < after)
      return false;

    return true;
  }
}

