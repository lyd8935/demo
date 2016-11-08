package com.demo.showcase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.showcase.commons.entity.User;
import com.demo.showcase.commons.option.UserQueryOption;
import com.demo.showcase.commons.page.DataPage;
import com.demo.showcase.commons.result.ModelResult;
import com.demo.showcase.commons.result.PageResult;
import com.demo.showcase.commons.service.UserService;
import com.demo.showcase.manager.UserManager;

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
}