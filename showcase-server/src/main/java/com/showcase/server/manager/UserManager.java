package com.showcase.server.manager;

import com.showcase.commons.entity.User;
import com.showcase.commons.option.UserQueryOption;
import com.showcase.commons.page.DataPage;

public interface UserManager {

	public User queryById(Long id);
	
	public DataPage<User> queryPage(UserQueryOption queryOption, DataPage<User> dataPage);
}
