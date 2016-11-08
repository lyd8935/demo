package com.demo.showcase.commons.service;

import com.demo.showcase.commons.entity.User;
import com.demo.showcase.commons.result.ModelResult;

public interface UserService {
	
	/**
	 * 查询用户
	 * @param id	主键ID
	 */
	public ModelResult<User> queryById(Long id);
}
