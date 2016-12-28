package java8.chap4;


import java.util.stream.Collectors;

public class StreamBasic {
	
	public static void main(String[] args) {
		Dish.menu.stream().filter(d ->  d.getCalories() > 300)
						.map(Dish::getName)
						.collect(Collectors.toList());
		
//		Dish.menu.stream().forEach(System.out::println);
		
		long count = Dish.menu.stream().filter(d -> d.getCalories() > 300)
									.distinct()
									.limit(3)
									.count();
//		System.out.println(count);
		
		Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		
	}
}
