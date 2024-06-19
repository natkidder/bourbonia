package enums.main;

import java.util.Scanner;

public class EnumsMain {
	private static final String CHOICES = 
			"1. Pass an enum name as an argument and print its values\n\n" +
					"Select Choice: ";
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) {
		System.out.println(CHOICES);
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the name of the enum you want to see the values of (courseList, generalInformation or gender): ");
			String enumName = scanner.next();
			printEnumValsByName(enumName);
			break;
		default:
			System.exit(1);
		}
	}
	private static void printEnumValsByName(String enumName) {
		// TODO Auto-generated method stub
		
	}
	   public static<E extends Enum<E>> boolean isValidEnum(Class<E> enumClass, String enumName) {
	        if(enumName== null) {
	            return false; 
	        } else {
	            try {
	                Enum.valueOf(enumClass, enumName); 
	                return true; 
	            } catch (IllegalArgumentException var3){
	                return false; 
	            }
	        }
	    }
}
