package java8.chap13;

import java.util.function.Function;
import java.util.stream.LongStream;

public class Recursion {
	
	Function<String, Integer> strToInt = Integer::parseInt;
	
	public static void main(String[] args) {
		System.out.println("factorialIterative(4) = " + factorialIterative(4));
	}
	
	public static long factorialIterative(long n){
		return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
	}
	
	
}
