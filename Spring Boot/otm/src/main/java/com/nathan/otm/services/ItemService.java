package com.nathan.otm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nathan.otm.models.Item;
import com.nathan.otm.repositories.ItemRepo;

@Service
public class ItemService {
	private final ItemRepo itemRepo;
	public ItemService(ItemRepo itemRepo) {
		this.itemRepo = itemRepo;
	}
	public List<Item> allItems(){
		return itemRepo.findAll();
	}
	public Item createItem(Item item) {
		return itemRepo.save(item);
	}

}
