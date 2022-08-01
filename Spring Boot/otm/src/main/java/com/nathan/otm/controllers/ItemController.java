package com.nathan.otm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nathan.otm.models.Item;
import com.nathan.otm.models.User;
import com.nathan.otm.services.ItemService;
import com.nathan.otm.services.UserService;

@Controller
public class ItemController {
	private final ItemService itemService;
	private final UserService userService;
	public ItemController(ItemService itemService, UserService userService) {
		this.itemService = itemService;
		this.userService = userService;
	}
	@RequestMapping("/addItem")
	public String addItem(@ModelAttribute("item") Item item, Model model) {
		List<User> users = userService.allUsers();
		model.addAttribute("users",users);
		return "itemForm.jsp";
	}
	
	@RequestMapping(value="/item",method=RequestMethod.POST)
	public String createItem(@Valid @ModelAttribute("item") Item item, BindingResult result) {
		if(result.hasErrors()) {
			return"itemForm.jsp";
		} else {
			itemService.createItem(item);
			return "redirect:/";
		}
	}
	

}
