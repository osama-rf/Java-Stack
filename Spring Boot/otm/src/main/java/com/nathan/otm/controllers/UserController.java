package com.nathan.otm.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nathan.otm.models.User;
import com.nathan.otm.services.UserService;

@Controller
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		return "userForm.jsp";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors()) {
			return "userForm.jsp";
		} else {
			userService.createUser(user);
			return "redirect:/";
		}
	}
}
