package com.demo.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.showcase.commons.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "")
	public String index(){
		return "user/user-index";
	}
}
