package java8.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.reflection.SystemMetaObject;

public class PuttingIntoPractice {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		
		transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList());
		transactions.stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge"))
							.distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList()).forEach(System.out::println);
		
		transactions.stream().map(t -> t.getTrader().getName())
							.distinct()
							.sorted()
							.reduce("", (n1, n2) -> n1 + n2);
		
		transactions.stream().min(Comparator.comparing(Transaction::getValue));
		
	}
}
