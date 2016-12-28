package java8.chap5;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("Java 8", "Lambdas", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
		
		Stream<String> emptyStream = Stream.empty();
		
		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers).sum();
		
		Stream.iterate(0, n -> n + 2)
		.limit(10)
		.forEach(System.out::println);
	}
}
