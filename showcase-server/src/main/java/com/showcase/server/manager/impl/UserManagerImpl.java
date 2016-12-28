package com.showcase.server.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showcase.commons.entity.User;
import com.showcase.commons.option.UserQueryOption;
import com.showcase.commons.page.DataPage;
import com.showcase.server.dao.UserDao;
import com.showcase.server.manager.UserManager;

@Service
public class UserManagerImpl implements UserManager {
	
	@Autowired
	private UserDao UserDao;
	
	@Override
	public User queryById(Long id){
		return UserDao.queryById(id);
	}

	@Override
	public DataPage<User> queryPage(UserQueryOption queryOption, DataPage<User> dataPage) {
		return null;
	}
}
