package java8.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java8.chap4.Dish;

public class Reducing {
	public static void main(String[] args) {
		 List<Integer> numbers = Arrays.asList(3,4,5,1,2);
		 
		 int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
		 System.out.println(sum1);
		 numbers.stream().reduce(0, Integer::sum);
		 
		 Optional<Integer> sum2 = numbers.stream().reduce((a, b) -> a + b);
		 Optional<Integer> max = numbers.stream().reduce(Integer::max);
		 Optional<Integer> min = numbers.stream().reduce(Integer::min);
		 
		 Dish.menu.stream().map(d -> 1).reduce(0, Integer::sum);
		 
	}
}
