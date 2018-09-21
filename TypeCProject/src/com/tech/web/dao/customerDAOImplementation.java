package com.tech.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.tech.web.model.Item;
import com.tech.web.model.customer;
import com.tech.web.utils.DBUtil;

public class customerDAOImplementation implements customerDAO{
	
	private Connection conn;

	public customerDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void OrderItemByCustomer(customer item) {
		// TODO Auto-generated metho
		try {
				String query = "insert into customer (customer_id,customer_name,customer_address) values (?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement( query );

				preparedStatement.setString( 1, item.getCustomerId());
				
				preparedStatement.setString( 2, item.getCustomerName());
				preparedStatement.setString( 3, item.getAddress());
				
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}

		}
	
	@Override
	public void OrderItemByCustomer2(customer item) {
		// TODO Auto-generated metho
		try {
				String query = "insert into customer_item (customer_id,item_id) values (?,?)";
				PreparedStatement preparedStatement = conn.prepareStatement( query );
				preparedStatement.setString( 1, item.getCustomerId());
				preparedStatement.setString( 2, item.getItemId());
				
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}

		}

	@Override
	public List<Item> Search(String text) {
		// TODO Auto-generated method stub
		return null;
	}


}
