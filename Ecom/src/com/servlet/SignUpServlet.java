package com.servlet;

import java.io.IOException;
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
import com.util.DataManagementUtility;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String contactNum = request.getParameter("contNumber");
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmailId(emailId);
		customer.setContactNo(contactNum);
		customer.setPassword(password);
		HttpSession session = request.getSession();
		Store storeCheck = (Store)session.getAttribute("storeObject");
		if(storeCheck == null){
			Store store = new Store();
			HashMap<String,List<Product>> productMap = new HashMap<String, List<Product>>();
			HashMap<String,Customer> customerMap = new HashMap<String,Customer>();
			HashMap<String,List<Order>> orderMap = new HashMap<String, List<Order>>();
			HashMap<String,Cart> cartMap = new HashMap<String,Cart>();

			store.setProductMap(productMap);
			store.setCustomerMap(customerMap);
			store.setOrderMap(orderMap);
			store.setCartMap(cartMap);

			session.setAttribute("storeObject", store);

		}
		DataManagementUtility dmUtil = new DataManagementUtility();
		dmUtil.addCustomer(request,customer);
		response.sendRedirect("/Ecom/E_Com_Web/docs/ECom_WebContent/html/index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
