package com.ecommerce.itemservice.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//to avoid updating all fields of the domain and user can update fields for choice
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ItemUpdateResource {

	private String itemName;
	private String url;
	private String itemCatagory;
	private double itemPrice;

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
