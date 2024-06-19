package multithreading.main;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class MultithreadingMain_2 {
	static volatile int count = 0;
	private static final String CHOICES =
			"1. Run ThreadLocal\n" +
	        "2. Use a volatile varialbe\n\n" +
					"Select Choice: ";
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
  		System.out.println(CHOICES);
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
			System.out.println(threadLocalEx(date));
			break;
		case 2:
   			// https://www.baeldung.com/java-volatile-variables-thread-safety
			volatileVariableEx();
		default:
			System.exit(1);
		}
		// TODO Auto-generated method stub
	}
	private static String threadLocalEx(Date date) {
	    final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
	        // SimpleDateFormat is not thread-safe, so give one to each thread
	        @Override
	        protected SimpleDateFormat initialValue()
	        {
	            return new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        }
	    };
  		return formatter.get().format(date);
	}
	/*
	 * https://www.baeldung.com/java-volatile-variables-thread-safety
	 */
	private static void volatileVariableEx() {
		Thread t1 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        for(int index=0; index<1000; index++) {
		        	try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            increment();
		        }
		    }
		});
		Thread t2 = new Thread(new Runnable() {
      		    @Override
		    public void run() {
		        for(int index=0; index<1000; index++) {
		        	try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
      						e.printStackTrace();
					}
		            increment();
		        }
		    }
		});
		try {
			t1.start();
			t2.start();
			t1.join();  // wait for the thread to die
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}
 	static void increment() {
	    count++;
	}
}
