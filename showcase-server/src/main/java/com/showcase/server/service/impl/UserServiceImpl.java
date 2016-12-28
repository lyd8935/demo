package com.showcase.server.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.showcase.commons.entity.User;
import com.showcase.commons.option.UserQueryOption;
import com.showcase.commons.page.DataPage;
import com.showcase.commons.result.ModelResult;
import com.showcase.commons.result.PageResult;
import com.showcase.commons.service.UserService;
import com.showcase.server.manager.UserManager;

@Component("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserManager userManager;

	@Override
	public ModelResult<User> queryById(Long id) {
		if(null == id){
			return new ModelResult<User>().withError("showcase.user.100", "ID不能为空");
		}
		
		return new ModelResult<User>(userManager.queryById(id));
	}
	
	public PageResult<User> queryPage(UserQueryOption queryOption, DataPage<User> dataPage){
		return null;
	}

	@Override
	public ModelResult<Long> register(User user) {
		
		
		if(null == user.getCreateTime()){
			user.setCreateTime(LocalDateTime.now());
		}
		
		return null;
	}
}