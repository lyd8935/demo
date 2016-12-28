package java8.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.chap4.Dish;

public class Mapping {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
		
		String[] arrayOfWorlds = {"GoodBye", "world"};
		Stream<String> streamofWords = Arrays.stream(arrayOfWorlds);
//		streamofWords.forEach(System.out::println);
		
		words.stream().map(word -> word.split(""))
					.map(Arrays::stream)
					.distinct()
					.collect(Collectors.toList());
		
		words.stream().map(word -> word.split(""))
					.flatMap(Arrays::stream)
					.distinct()
					.collect(Collectors.toList());
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().map(n -> n * n).collect(Collectors.toList());
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
					.collect(Collectors.toList());
		
		if(Dish.menu.stream().anyMatch(Dish::isVegetarian)){
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}
		
		Dish.menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
		
	}
}
