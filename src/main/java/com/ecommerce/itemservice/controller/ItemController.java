package com.ecommerce.itemservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.itemservice.model.Item;
import com.ecommerce.itemservice.resource.ItemUpdateResource;
import com.ecommerce.itemservice.service.ItemService;

@RestController
@RequestMapping(value = "api/item")
@CrossOrigin(origins = "*") // this annotation used connect different port numbers
public class ItemController {

	@Autowired
	ItemService itemService;


	@GetMapping(value = "/check")
	public String check(){
		return "Server is Running At Port 8080";
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		try {
			Item itemAdded = itemService.addItem(item);
			return new ResponseEntity<>(itemAdded, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllItems() {
		try {
			List<Item> items = itemService.findAll();
			if (!items.isEmpty()) {
				return new ResponseEntity<>(items, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getItemById(@PathVariable(value = "id", required = true) int id) {
		try {
			Optional<Item> item = itemService.findById(id);
			if (item != null) {
				return new ResponseEntity<>(item, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteById(@PathVariable(value = "id", required = true) int id) {
		String msg = itemService.deleteById(id);
		return msg;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable(value = "id", required = true) int id,
			@RequestBody ItemUpdateResource itemUpdateResource) {
		try {

			Item itemUpdated = itemService.updateItem(id, itemUpdateResource);
			return new ResponseEntity<>(itemUpdated, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/search/{name}")
	public ResponseEntity<Object> findByItemName(@PathVariable(value = "name", required = true) String name) {
		try {
			List<Item> item = itemService.findByName(name);
			if (item != null) {
				return new ResponseEntity<>(item, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/category/{catagory}")
	public ResponseEntity<Object> findByItemCatagory(@PathVariable(value = "catagory", required = true) String catagory) {
		try {
			List<Item> item = itemService.findByCatagory(catagory);
			if (item != null) {
				return new ResponseEntity<>(item, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
