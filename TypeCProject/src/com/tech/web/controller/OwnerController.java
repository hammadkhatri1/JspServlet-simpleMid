package com.tech.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.web.dao.ownerDAOImplementation;
import com.tech.web.model.Item;

/**
 * Servlet implementation class OwnerController
 */
@WebServlet("/owner")
public class OwnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ownerDAOImplementation dao;
	 
    public OwnerController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new ownerDAOImplementation();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("item", dao.getList());
		getServletContext().getRequestDispatcher("/owner.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");

    	if(action.equals("insertItem")) {
			
			Item item =new Item();
			
			String name=request.getParameter("itemName");
			String price=request.getParameter("price");
			
			item.setItemName(name);
			item.setPrice(Double.parseDouble(price));
			
			dao.addItem(item);	
		
		}else if (action.equals("deleteItem")) {
			
			String id=request.getParameter("id");
			dao.deleteItem(Integer.parseInt(id));	
			
		}
		else if(action.equals("updateItem")) {
			
			Item item =new Item();
			
			String id=request.getParameter("itemId");
			String name=request.getParameter("itemNamee");
			String price=request.getParameter("price");
			
			
			item.setId(id);
			item.setItemName(name);
			item.setPrice(Double.parseDouble(price));
			
			dao.editItem(item);	
		}
		
	}

}
