package com.showcase.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.showcase.commons.entity.User;
import com.showcase.commons.service.UserService;

/**
 * 用户注册的Controller.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(){
		return "user/user-index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(User user, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("username", user.getLoginName());
		return "redirect:/login";
	}
}
