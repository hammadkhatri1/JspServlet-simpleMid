package com.tech.web.dao;

import java.util.List;

import com.tech.web.model.Item;
import com.tech.web.model.customer;

public interface customerDAO {

	public void  OrderItemByCustomer(customer item);

	public List<Item> Search(String text);

	void OrderItemByCustomer2(customer item);
}
