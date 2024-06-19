package stream.api.main;

//Java program to demonstrate 
//the use of stream in java
import java.util.*;
import java.util.stream.*;


class StreamApiMain {
	private static final String CHOICES = 
			"1. Different Collections\n" +
					"2. Show peek\n\n" +
					"Select Choice: ";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String args[])
	{
		System.out.println(CHOICES);
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			differentCollections();
			break;
		case 2:
			peekExample();
			break;
		default:
			System.exit(1);
		}
	}
	private static void differentCollections() {
		// create a list of integers
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5); 

		// demonstration of map method
		List<Integer> square 
		= numbers.stream()
		.map(x -> x * x)
		.collect(Collectors.toList());
		System.out.print("1: ");
		System.out.println(square);

		// create a list of String
		List<String> names = Arrays.asList(
				"Reflection", "Collection", "Stream");

		// demonstration of filter method
		List<String> result
		= names.stream()
		.filter(s -> s.startsWith("S"))
		.collect(Collectors.toList());

		System.out.print("2: ");
		System.out.println(result);

		// demonstration of sorted method
		List<String> show 
		= names.stream()
		.sorted()
		.collect(Collectors.toList());

		System.out.print("3: ");
		System.out.println(show);

		// create a list of integers
		List<Integer> numbers2
		= Arrays.asList(2, 3, 4, 5, 2);

		// collect method returns a set
		Set<Integer> squareSet
		= numbers2.stream()
		.map(x -> x * x)
		.collect(Collectors.toSet());  // as opposed to toList in (1)

		System.out.print("4: ");
		System.out.println(squareSet);

		// demonstration of forEach method
		System.out.print("5: \n");
		numbers.stream()
		.map(x -> x * x)
		.forEach(y -> System.out.println("   "+y));

		// demonstration of reduce method
		int even 
		= numbers.stream()
		.filter(x -> x % 2 == 0)
		.reduce(0, (ans, i) -> ans + i);

		System.out.print("6: ");
		System.out.println(even);
	}
	private static void peekExample() {
		System.out.println("peek() is for debugging");
		System.out.println("==1");
		Stream.of(true, false, true)
		.map(b -> b.toString()
				.toUpperCase())
		.peek(System.out::println);	
		System.out.println("==2");
		Stream<String> stream = Stream.of("Hello", "World");
        stream.peek(System.out::println).forEach(System.out::println);
	}
}
