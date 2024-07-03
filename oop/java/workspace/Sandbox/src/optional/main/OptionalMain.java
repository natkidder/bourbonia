package optional.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OptionalMain {
	private static final String CHOICES = 
			"1. Null check, the Optional way\n\n" +
					"Select Choice: ";
	private static Scanner scanner = new Scanner(System.in);
	/*
	 * https://www.baeldung.com/java-optional
	 */
	public static void main(String[] args) {
		System.out.println(CHOICES);
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			checkIfOptionalObjPresent();
			break;
		default:
			System.exit(1);
		}	
	}

	@Test
	@DisplayName("Should be true")
	private static void checkIfOptionalObjPresent() {
		String name = "baeldung";
		Optional<String> opt = Optional.of(name);
		//		assertTrue(opt.isPresent(),"opt is present");
		chkPresence("opt is present", opt);
		Optional<String> opt2 = Optional.ofNullable("France");
		chkPresence("opt2 is present", opt2);
		Optional<String> opt3 = Optional.ofNullable(null);
		chkPresence("opt3 is present", opt2);
		chkEmpty("opt3 is empty", opt2);

	}

	private static void chkPresence(String msg, Optional<String> opt) {
		System.out.println(msg+": "+(opt.isPresent()));
	}
	private static void chkEmpty(String msg, Optional<String> opt) {
		System.out.println(msg+": "+(opt.isEmpty()));
	}

}
