package com.showcase.server.dao;

import java.util.List;

import com.showcase.commons.entity.User;
import com.showcase.commons.option.UserQueryOption;
import com.showcase.commons.page.DataPage;
import com.showcase.server.framework.mybatis.MyBatisMapper;

@MyBatisMapper
public interface UserDao {
	
	public User queryById(Long id);
	
	public List<User> queryList(UserQueryOption queryOption, DataPage<User> dataPage);
}
