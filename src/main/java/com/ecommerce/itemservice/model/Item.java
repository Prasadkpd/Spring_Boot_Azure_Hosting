package com.ecommerce.itemservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Items")
public class Item {
	@Id
	private int itemId;
	private String itemName;
	private String url;
	private String itemCatagory;
	private double itemPrice;

	public Item(int itemId, String itemName,String url,String itemCatagory, double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.url = url;
		this.itemCatagory = itemCatagory;
		this.itemPrice = itemPrice;
	}

	public Item() {

	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getItemCatagory() {
		return itemCatagory;
	}

	public void setItemCatagory(String itemCatagory) {
		this.itemCatagory = itemCatagory;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
