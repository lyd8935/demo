package com.showcase.commons.service;

import com.showcase.commons.entity.User;
import com.showcase.commons.result.ModelResult;

public interface UserService {
	
	/**
	 * 查询用户
	 * @param id	主键ID
	 */
	public ModelResult<User> queryById(Long id);
	
	public ModelResult<Long> register(User user);
	
}
