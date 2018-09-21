package com.tech.web.model;

public class Item {
	private String id,itemName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private double price;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
