package com.nathan.crud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nathan.crud.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findAll();
//	List<Item> findByDescriptionContaining(String search);
}
