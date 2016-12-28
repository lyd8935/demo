package java8.chap6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import java8.chap4.Dish;
import java8.chap4.Dish.CaloricLevel;

public class Grouping {
	public static void main(String[] args) {
		Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));
		System.out.println("dishesByType = " + dishesByType);
		
		Map<CaloricLevel, List<Dish>> dishesByTypeCaloricLevel1 = Dish.menu.stream().collect(
			Collectors.groupingBy(dish -> { 
				if(dish.getCalories() <= 400) return CaloricLevel.DIET;
				else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
				else return CaloricLevel.FAT;
			})
		);
		System.out.println("dishesByTypeCaloricLevel1 = " + dishesByTypeCaloricLevel1);
		
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel2 = Dish.menu.stream().collect(
			Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
				if(dish.getCalories() <= 400) return CaloricLevel.DIET;
				else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
				else return CaloricLevel.FAT;
			}))
		);
		System.out.println("dishesByTypeCaloricLevel2 = " + dishesByTypeCaloricLevel2);
		
		Map<Dish.Type, Dish> mostCaloricByType = Dish.menu.stream()
				.collect(Collectors.groupingBy((Dish::getType), Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println("mostCaloricByType = " + mostCaloricByType);
		
		Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType1 = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
					if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
					else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
					else return Dish.CaloricLevel.FAT;
				}, Collectors.toSet())
		));
		System.out.println("caloricLevelsByType1 = " + caloricLevelsByType1);
		
		Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType2 = Dish.menu.stream()
				.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
					if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
					else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
					else return Dish.CaloricLevel.FAT;
				}, Collectors.toCollection(HashSet::new))
		));
		System.out.println("caloricLevelsByType2 = " + caloricLevelsByType2);
	}
}