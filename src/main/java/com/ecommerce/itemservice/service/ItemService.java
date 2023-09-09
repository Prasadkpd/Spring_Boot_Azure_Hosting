package com.ecommerce.itemservice.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.itemservice.model.Item;
import com.ecommerce.itemservice.resource.ItemUpdateResource;

public interface ItemService {

	public List<Item> findAll();

	public Optional<Item> findById(int id);

	public Item addItem(Item item);

	public String deleteById(int id);

	public List<Item> findByName(String name);
	
	public List<Item> findByCatagory(String catagory);

	public Item updateItem(int id, ItemUpdateResource itemUpdateResource);

}
