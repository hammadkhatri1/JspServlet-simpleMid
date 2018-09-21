package com.tech.web.dao;

import java.util.List;

import com.tech.web.model.Item;

public interface ownerDAO {

	public void addItem(Item item);
	public void editItem(Item item);
	public List<Item> getList();
	void deleteItem(int i);
	List<Item> Search(String text);
}
