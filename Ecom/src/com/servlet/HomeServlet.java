package com.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Cart;
import com.pojo.Customer;
import com.pojo.Order;
import com.pojo.Product;
import com.pojo.Store;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public HomeServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String userType = request.getParameter("usertype");
		String uname = request.getParameter("inputEmail").toString();
		String password = request.getParameter("inputPassword").toString();
		if("abc@gmail.com".equals(uname) && "abc".equals(password)){
			HttpSession session = request.getSession();
			session.setAttribute("userId","abc@gmail.com");
			Store storeCheck = (Store)session.getAttribute("storeObject");
			if(storeCheck == null){
				Store store = new Store();
				HashMap<String,List<Product>> productMap = new HashMap<String, List<Product>>();
				HashMap<String,List<Customer>> customerMap = new HashMap<String, List<Customer>>();
				HashMap<String,List<Order>> orderMap = new HashMap<String, List<Order>>();
				HashMap<String,Cart> cartMap = new HashMap<String,Cart>();
				
				store.setProductMap(productMap);
				store.setCustomerMap(customerMap);
				store.setOrderMap(orderMap);
				store.setCartMap(cartMap);
				
				session.setAttribute("storeObject", store);

				out.println("Log in successful");
				
			}
			if("admin".equals(userType)){
				response.sendRedirect("E_Com_Web/docs/ECom_WebContent/html/dashboard.html");
			}
			else if("user".equals(userType)){
				response.sendRedirect("E_Com_Web/docs/ECom_WebContent/html/dashboard_user.html");	
			}
		}
		else{
			out.println("Log in failed");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
