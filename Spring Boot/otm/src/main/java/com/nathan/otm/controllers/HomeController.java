package com.nathan.otm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nathan.otm.models.Item;
import com.nathan.otm.models.User;
import com.nathan.otm.services.ItemService;
import com.nathan.otm.services.UserService;

@Controller
public class HomeController {
	private final ItemService itemService;
	private final UserService userService;
	public HomeController(ItemService itemService, UserService userService) {
		this.itemService = itemService;
		this.userService = userService;
	}
	@RequestMapping("/")
	public String index(Model model) {
		List<User> users = userService.allUsers();
		model.addAttribute("users",users);
		List<Item> items = itemService.allItems();
		model.addAttribute("items",items);
		return "index.jsp";
	}

}
