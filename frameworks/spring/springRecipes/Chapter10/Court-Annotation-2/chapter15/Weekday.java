package com.jstlbook.examples;

import java.util.*;

public class Weekday {

    public boolean isWeekday() {
        Calendar now = Calendar.getInstance();
        if (now.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            return false;
        if (now.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            return false;
        return true;
    }	

}

