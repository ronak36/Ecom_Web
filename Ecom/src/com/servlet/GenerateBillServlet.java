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

import com.pojo.Order;
import com.pojo.Product;
import com.pojo.Store;
import com.util.DataManagementUtility;

/**
 * Servlet implementation class GenerateBillServlet
 */
public class GenerateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DataManagementUtility dmUtil = new DataManagementUtility();
		dmUtil.generateBill(request);
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("storeObject");
		String userId = (String)session.getAttribute("userId");
		HashMap<String, List<Order>> orderMap = store.getOrderMap();
		List<Order> orderList = orderMap.get(userId);
		int currentOrder = orderList.size() - 1;
		Order order = orderList.get(currentOrder);
		request.setAttribute("orderProductList",order.getProductList());
		request.setAttribute("orderId", order.getOrderId());
		request.setAttribute("orderPrice", order.getTotal());
		RequestDispatcher rd = getServletContext()
				.getRequestDispatcher("/E_Com_Web/docs/ECom_WebContent/html/displayProductUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
