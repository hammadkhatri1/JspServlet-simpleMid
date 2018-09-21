package com.tech.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.web.dao.customerDAOImplementation;
import com.tech.web.dao.ownerDAOImplementation;
import com.tech.web.model.customer;

/**
 * Servlet implementation class customer
 */
@WebServlet("/customer")
public class customerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ownerDAOImplementation admindao;
	private customerDAOImplementation customerDao;
	   
    public customerController() {
    	admindao=new ownerDAOImplementation();
    	customerDao =new customerDAOImplementation();
 // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubrequest.setAttribute("item", admindao.getList());
		request.setAttribute("item", admindao.getList());
		getServletContext().getRequestDispatcher("/customer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action.equals("Order")) {
			
			customer ci=new customer();
			ci.setCustomerId(request.getParameter("customerId"));
			
			ci.setCustomerName(request.getParameter("customerFirstName"));
			ci.setAddress(request.getParameter("customeradress"));
			ci.setItemId(request.getParameter("itemId"));
			
			customerDao.OrderItemByCustomer(ci);
			customerDao.OrderItemByCustomer2(ci);
			
			
		}	else if(action.equals("SearchItem")) {
			
			String searchText=request.getParameter("searchText");
			
			request.setAttribute("item", admindao.Search(searchText));
			getServletContext().getRequestDispatcher("/customer.jsp").forward(request, response);
			
		}
	}

}
