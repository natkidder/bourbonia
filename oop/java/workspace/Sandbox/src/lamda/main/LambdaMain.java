package lamda.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import lambda.bean.StringFunction;

public class LambdaMain {

	private static final String CHOICES = 
			"1. Store Lamda variables in a list\n" +
					"2.  Store a Lamba expression in a variable\n" +
					"3.  Use a Lamba expression in a parameter\n\n" +
					"Select Choice: ";
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(CHOICES);
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			loopThroughCollection();
			break;
		case 2:
			storeLamdaExpressionInVariable();
			break;
		case 3:
			useLambaExprInParam();
			break;
		default:
			System.exit(1);
		}
	}
	private static void loopThroughCollection() {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		numbers.add(1);
		numbers.forEach( (n) -> { System.out.println(n*n); } );
	}
	private static void storeLamdaExpressionInVariable() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
		Consumer<Integer> method = (n) -> { System.out.println(n%2); };
		numbers.forEach( method );
	}
	private static void useLambaExprInParam() {
		StringFunction exclaim = (s) -> s + "!";
		StringFunction ask = (s) -> s + "?";
		printFormatted("Hello", exclaim);
		printFormatted("Hello", ask);
	}
	public static void printFormatted(String str, StringFunction stringFunction) {
		String result = stringFunction.run(str);
		System.out.println(result);
	}
}
