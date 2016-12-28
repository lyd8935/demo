package com.showcase.server.framework.spi;

import java.util.List;

public class FileSearch implements Search {

	@Override
	public List<String> searchDoc(String keyword) {
		System.out.println("文档搜索" + keyword);
		return null;
	}
}
