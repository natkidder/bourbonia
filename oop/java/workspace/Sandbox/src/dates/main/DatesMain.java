package dates.main;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatesMain {

	private static final String CHOICES = 
			"1. Print a formatted local date and time\n\n" +
					"Select Choice: ";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(CHOICES);
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			formatPrintLocalDateTime();
			break;
		default:
			System.exit(1);
		}
	}

	private static void formatPrintLocalDateTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

		// Format the LocalDateTime object to a string
		String formattedDateTime = now.format(formatter);
		System.out.println(formattedDateTime);
	}

}
