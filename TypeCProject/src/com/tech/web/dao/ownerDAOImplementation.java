package com.tech.web.dao;


import com.tech.web.model.Item;
import com.tech.web.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ownerDAOImplementation implements ownerDAO {
	

	private Connection conn;

	public ownerDAOImplementation() {
		conn = DBUtil.getConnection();
	}




	@Override
	public void addItem(Item item) {
		try {
			String query = "insert into item (item_Name,price) values (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, item.getItemName());
			preparedStatement.setDouble( 2, item.getPrice());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}


	}
			
	
			@Override
			public List<Item> getList() {
				List<Item> itemsArraylist = new ArrayList<Item>();
					
			    try {
			        Statement statement = conn.createStatement();
			        ResultSet rs = statement.executeQuery("select * from item");
			        while(rs.next())
			        {
			            Item itm = new Item();

			            itm.setId(rs.getString(1));
			            itm.setItemName(rs.getString(2));
			            itm.setPrice(rs.getDouble(3));
			            
			            itemsArraylist.add(itm);

			        }
			    }catch (SQLException e) {

			        e.printStackTrace();
			    }
			    return itemsArraylist;
			}


		

	@Override
	public void deleteItem(int i) 
	{	
		try {
				String query="Delete from item where item_Id=?";
				PreparedStatement prepStat=conn.prepareStatement(query);
				prepStat.setInt(1,i);
				prepStat.executeUpdate();
				prepStat.close();
		
			}catch(Exception g) {
				g.printStackTrace();
			}
	}
		
	

	@Override
	public void editItem(Item item) {	try 
	
	{
		PreparedStatement ps = conn.prepareStatement("update item set item_Name=?,price=? where item_Id=?");
		
		ps.setString(1, item.getItemName());
		ps.setDouble(2, item.getPrice());
		ps.setString(3, item.getId());
		
		ps.execute();
		ps.close();
	}catch(Exception h) {
		h.printStackTrace();

	}
		
	}
	@Override
	public List<Item> Search(String text) {
		
		List<Item> itemsArraylist = new ArrayList<Item>();
		
	    try {
	    	String query="select * from item where item_Name like ?";
	       PreparedStatement prepStat=conn.prepareStatement(query);
	    	prepStat.setString(1,text + "%");
	    	 ResultSet rs = prepStat.executeQuery();
		    	
	    	 while(rs.next())
	    	 {
	            Item itm = new Item();

	            itm.setId(rs.getString(1));
	            itm.setItemName(rs.getString(2));
	            itm.setPrice(Double.parseDouble(rs.getString(3)));
	            
	            
	            itemsArraylist.add(itm);

	        }
	    }catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return itemsArraylist;

	}

}
