package com.demo.showcase.dao;

import java.util.List;

import com.demo.showcase.commons.entity.User;
import com.demo.showcase.commons.option.UserQueryOption;
import com.demo.showcase.commons.page.DataPage;
import com.demo.showcase.framework.mybatis.MyBatisMapper;

@MyBatisMapper
public interface UserDao {
	
	public User queryById(Long id);
	
	public List<User> queryList(UserQueryOption queryOption, DataPage<User> dataPage);
}
