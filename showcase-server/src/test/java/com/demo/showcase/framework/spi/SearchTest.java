package com.demo.showcase.framework.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.demo.showcase.server.framework.spi.Search;

public class SearchTest {
	public static void main(String[] args) {
		ServiceLoader<Search> loader = ServiceLoader.load(Search.class);
		Iterator<Search> iterator = loader.iterator();
		while(iterator.hasNext()){
			Search search = iterator.next();
			search.searchDoc("Hello World");
		}
	}
}
