package com.nathan.crud.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nathan.crud.models.Item;
import com.nathan.crud.services.ItemService;

@Controller
public class ItemController {
	private final ItemService itemService;
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	@RequestMapping("/")
	public String allItems(Model model) {
		List<Item> items = itemService.allItems();
		model.addAttribute("items",items);
		return "allItems.jsp";
	}
	@RequestMapping("/form")
	public String form(@ModelAttribute("item") Item item) {
		return "form.jsp";
	}
	
	@RequestMapping(value="/item",method=RequestMethod.POST)
	public String createItem(@Valid @ModelAttribute("item") Item item, BindingResult result) {
		if(result.hasErrors()) {
			return"form.jsp";
		} else {
			itemService.createItem(item);
			return "redirect:/";
		}
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Item item = itemService.findItem(id);
		model.addAttribute("item",item);
		return "form2.jsp";
	}
	@RequestMapping(value="/item/{id}",method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("item") Item item, @PathVariable("id") Long id, BindingResult result) {
		if(result.hasErrors()) {
			return"form2.jsp";
		} else {
			itemService.updateItem(item,id);
			return "redirect:/";
		}
	}
	
	
	
//	@RequestMapping(value="/item",method=RequestMethod.POST)
//	public String createItem(
//			@RequestParam(value="name") String name,
//			@RequestParam(value="description") String description,
//			@RequestParam(value="price") Double price
//			) {
//		Item item = new Item(name,description,price);
//		itemService.createItem(item);
//		return "redirect:/";
//	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		itemService.deleteItem(id);
		return "redirect:/";
	}

}
