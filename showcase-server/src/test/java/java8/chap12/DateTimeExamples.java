package java8.chap12;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import javax.print.attribute.standard.PresentationDirection;

public class DateTimeExamples {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
//		LocalTime time = LocalTime.of(13, 45, 20);
		
		LocalDate date = LocalDate.parse("2014-03-18");
		LocalTime time = LocalTime.parse("13:45:20");
		
		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		System.out.println("dt1 = " + dt1);
		
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		System.out.println("dt2 = " + dt2);
		
		LocalDateTime dt3 = date.atTime(time);
		System.out.println("dt3 = " + dt3);
		
		LocalDateTime dt4 = date.atTime(13, 45, 20);
		System.out.println("dt4 = " + dt4);
		
		LocalDateTime dt5 = time.atDate(date);
		System.out.println("dt5 = " + dt5);
		
		System.out.println("Instant.ofEpochSecond(3) = " + Instant.ofEpochSecond(3));
			
		Duration d1 = Duration.between(LocalTime.of(13, 45, 10), time);
		System.out.println("d1.getSeconds() = " + d1.getSeconds());
		
		Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
		System.out.println("tenDays.getDays() = " + tenDays.getDays());
		
		LocalDate date1 = LocalDate.of(2014, 3, 18);
		System.out.println("date1 = " + date1);
		LocalDate date2 = date1.plusWeeks(1);
		System.out.println("date2 = " + date2);
		LocalDate date3 = date2.minusYears(3);
		System.out.println("date3 = " + date3);
		LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS);
		System.out.println("date4 = " + date4);
	}
}
