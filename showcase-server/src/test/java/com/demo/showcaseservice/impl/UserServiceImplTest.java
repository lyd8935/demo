package com.demo.showcaseservice.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.showcase.BaseTestCase;
import com.demo.showcase.commons.entity.User;
import com.demo.showcase.commons.result.ModelResult;
import com.demo.showcase.commons.service.UserService;

public class UserServiceImplTest extends BaseTestCase{

	@Autowired
	private UserService userService;
	
	@Test
	public void queryById(){
		Long id = 1L;
		ModelResult<User> modelResult = userService.queryById(id);
		
	}
	
	public static void main(String[] args) {
		String id = "27281272812728127281272812728127281272812728127281272812728127281272812728127281272812728127281272812728127281";
		System.out.println(id.hashCode());
	}
}
