package com.nathan.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nathan.crud.models.Item;
import com.nathan.crud.repositories.ItemRepository;

@Service
public class ItemService {
	private final ItemRepository itemRepository;
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> allItems(){
		return itemRepository.findAll();
	}
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}
	public Item findItem(Long id) {
		Optional<Item> optionalItem = itemRepository.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else {
			return null;
		}
	}
	public Item updateItem(Item item, Long id) {
		Item i = itemRepository.findById(id).get();
		i.setName(item.getName());
		i.setDescription(item.getDescription());
		i.setPrice(item.getPrice());
		return itemRepository.save(i);
	}

}
