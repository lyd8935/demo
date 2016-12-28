package java8.chap6;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import java8.chap4.Dish;

public class Summarizing {
	public static void main(String[] args) {
		long howManyDishs = Dish.menu.stream().count();
		System.out.println("howManyDishs = " + howManyDishs);
		
		Comparator<Dish> dishCaloriesComparator = Comparator.comparing(Dish::getCalories);
		Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		System.out.println("mostCalorieDish = " + mostCalorieDish.get());
		
		int totalCalories = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println("totalCalories = " + totalCalories);
		
		double avgCalories = Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
		System.out.println("avgCalories = " + avgCalories);
		
		IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println("menuStatistics = " + menuStatistics);
		
		String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println(shortMenu);
	}
}
