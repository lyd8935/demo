package java8.chap6;

import java.util.Optional;
import java.util.stream.Collectors;

import java8.chap4.Dish;

public class Reducing {
	public static void main(String[] args) {
		int totalCalories = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
		System.out.println("totalCalories = " + totalCalories);
		
		Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println("mostCalorieDish = " + mostCalorieDish);
		
		int totalCalories2 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		System.out.println("totalCalories2 = " + totalCalories2);
		
	}
}
