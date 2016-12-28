package com.demo.showcase;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml"})
public class BaseTestCase {
	public static void main(String[] args) {
		Integer a = 1000, b = 1000;	
		System.out.println(a == b);
		
		Integer c = 100, d = 100;
		System.out.println(c == d);
	}
}