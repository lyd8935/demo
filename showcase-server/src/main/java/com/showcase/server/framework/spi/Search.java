package com.showcase.server.framework.spi;

import java.util.List;

public interface Search {
	
	public List<String> searchDoc(String keyword);
}
