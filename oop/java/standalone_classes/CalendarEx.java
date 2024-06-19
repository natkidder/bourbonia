import java.util.*;

public class CalendarEx {
    public static void main(String args[]) {
        final int AUGUST = 7;
        final int OCTOBER = 9;
        Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int twoYear = year - (int)Math.floor(year/100) * 100;
		Calendar deadline = Calendar.getInstance();
		deadline.set(year, OCTOBER, 31, 23, 59, 59);
		long nowMillis = now.getTimeInMillis();
		long deadlineMillis = deadline.getTimeInMillis();
		long daysLeft = (deadlineMillis - nowMillis)/(1000 * 60 * 60 * 24);
		if (month >= AUGUST && month <= OCTOBER)  {
			System.out.println("System Reminder:  Data Collection for FY"+twoYear+" will close in "+daysLeft+" days.  October 31, "+year+" will be the last day to record FY"+twoYear+" data within OEPM.");
		}
	}
}
