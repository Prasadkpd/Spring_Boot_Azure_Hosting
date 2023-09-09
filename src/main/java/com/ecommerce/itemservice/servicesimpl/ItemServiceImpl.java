package com.ecommerce.itemservice.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.itemservice.model.Item;
import com.ecommerce.itemservice.repository.ItemRepository;
import com.ecommerce.itemservice.resource.ItemUpdateResource;
import com.ecommerce.itemservice.service.ItemService;

@Component
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemrepository;

	@Override
	public List<Item> findAll() {

		return itemrepository.findAll();
	}

	@Override
	public Optional<Item> findById(int id) {

		return itemrepository.findById(id);
	}

	@Override
	public Item addItem(Item item) {

		itemrepository.save(item);
		return item;
	}

	@Override
	public String deleteById(int id) {

		Item item = new Item();
		int itemId = item.getItemId();
		if(itemId != id) {
			itemrepository.deleteById(id);
			return "Item Id "+ id +" Deleted Successfully";
		}else {
			
			return "Item id is Invalid";
		}
	}

	@Override
	public Item updateItem(int id, ItemUpdateResource itemUpdateResource) {
		Optional<Item> itemOptional = itemrepository.findById(id);
		if (itemOptional.isPresent()) {
			Item item = itemOptional.get();// optional covert to an object
			if (itemUpdateResource.getItemName() != null && (!itemUpdateResource.getItemName().isEmpty())) {
				item.setItemName(itemUpdateResource.getItemName());
			}
			if (itemUpdateResource.getUrl() != null && (!itemUpdateResource.getUrl().isEmpty())) {
				item.setUrl(itemUpdateResource.getUrl());
			}
			if (itemUpdateResource.getItemCatagory() != null && (!itemUpdateResource.getItemCatagory().isEmpty())) {
				item.setItemCatagory(itemUpdateResource.getItemCatagory());
			}
			if (itemUpdateResource.getItemPrice() != 0.0) {
				item.setItemPrice(itemUpdateResource.getItemPrice());
			}
			itemrepository.save(item);
			return item;

		} else {

			return null;
		}

	}

	@Override
	public List<Item> findByName(String name) {

		return itemrepository.findByItemNameContaining(name);
	}

	@Override
	public List<Item> findByCatagory(String catagory) {
		return itemrepository.findByItemCatagory(catagory);
		
	}

}
