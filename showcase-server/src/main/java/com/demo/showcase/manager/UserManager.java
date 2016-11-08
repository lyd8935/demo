package com.demo.showcase.manager;

import com.demo.showcase.commons.entity.User;
import com.demo.showcase.commons.option.UserQueryOption;
import com.demo.showcase.commons.page.DataPage;

public interface UserManager {

	public User queryById(Long id);
	
	
	public DataPage<User> queryPage(UserQueryOption queryOption, DataPage<User> dataPage);
}
