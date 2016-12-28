package com.demo.showcase.server.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.showcase.commons.entity.User;
import com.demo.showcase.commons.option.UserQueryOption;
import com.demo.showcase.commons.page.DataPage;
import com.demo.showcase.server.dao.UserDao;
import com.demo.showcase.server.manager.UserManager;

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
