package web;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Test {
	public static final String DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_DAY = "yyyy-MM-dd";
	private static Calendar cal = Calendar.getInstance();
	private static Calendar cal2 = Calendar.getInstance();

	public static String now() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TIME);
		return sdf.format(cal.getTime());
	}
	public static String weddingDate() {
		cal2.set(2009,8,10);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DAY);
		Date date = cal2.getTime();
		return sdf.format(date);
	}

	public static void main(String args[]) {
		System.out.println("Now : " + now());
		System.out.println("Wedding Day: " + weddingDate());
	}
}

