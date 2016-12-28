package java8.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
	
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));
		filterApples(inventory, FilteringApples::isGreenApple);
		
		//lambda表达式
		filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
		filterApples(inventory, (Apple a) -> 150 < a.getWeight());
		filterApples(inventory, (Apple a) -> 80 > a.getWeight() || "brown".equals(a.getColor()));
		
		
	}
}
