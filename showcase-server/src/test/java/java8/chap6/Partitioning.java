package java8.chap6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java8.chap4.Dish;

public class Partitioning {
	public static void main(String[] args) {
		Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		System.out.println("partitionedMenu = " + partitionedMenu);
		
		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = Dish.menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
		System.out.println("vegetarianDishesByType = " + vegetarianDishesByType);
		
		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.menu.stream()
				.collect(Collectors.partitioningBy(Dish::isVegetarian
										, Collectors.collectingAndThen(
												Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
		System.out.println("mostCaloricPartitionedByVegetarian = " + mostCaloricPartitionedByVegetarian);
		
		
	}
}
