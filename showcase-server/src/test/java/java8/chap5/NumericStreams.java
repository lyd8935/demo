package java8.chap5;

import java.util.stream.IntStream;

import java8.chap4.Dish;

public class NumericStreams {
	public static void main(String[] args) {
		int calories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
		
		Dish.menu.stream().mapToInt(Dish::getCalories).boxed();
		
		Dish.menu.stream().mapToInt(Dish::getCalories).max();
		
		IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
		System.out.println(evenNumbers.count());
	}
}
