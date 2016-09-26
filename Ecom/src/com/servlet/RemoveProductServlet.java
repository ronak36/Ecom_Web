package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Cart;
import com.pojo.Product;
import com.pojo.Store;
import com.util.DataManagementUtility;

/**
 * Servlet implementation class RemoveProductServlet
 */
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String productId = request.getParameter("rmProductId");
		String categoryId = request.getParameter("rmCatId");
		Product product = new Product();
		product.setProductId(productId);
		product.setCategoryId(categoryId);
		DataManagementUtility dmUtil = new DataManagementUtility();
		dmUtil.removeProductFromCart(request,product);
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("storeObject");
		String userId = (String)session.getAttribute("userId");
		HashMap<String, Cart> cartMap = store.getCartMap();
		Cart cart = cartMap.get(userId);
		session.setAttribute("cartProductList",cart.getProductCartList());
	    //RequestDispatcher rd = getServletContext().getRequestDispatcher("/E_Com_Web/docs/ECom_WebContent/html/viewCart.jsp");
	    //rd.forward(request, response);
		response.sendRedirect("/Ecom/E_Com_Web/docs/ECom_WebContent/html/viewCart.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
