package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Product;
import com.util.DataManagementUtility;


public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String productId = request.getParameter("coProductId");
		String catId = request.getParameter("coCatId");
		String action = request.getParameter("actionType");
		//String warrenty = request.getParameter("warrenty");
		Product productInfo = new Product();
		productInfo.setProductId(productId);
		productInfo.setCategoryId(catId);
		/*
		if("checked".equals(warrenty)){
			productInfo.setWarrenty(true);
		}
		else{
			productInfo.setWarrenty(false);
		}*/
		DataManagementUtility dmUtil = new DataManagementUtility(); 
		dmUtil.addToCart(request,productInfo);
		
		if("checkout".equals(action)){
			response.sendRedirect("/Ecom/E_Com_Web/docs/ECom_WebContent/html/addPayment.html");
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/GenerateBillServlet");
			//rd.forward(request, response);
		}
		else if ("nocheckout".equals(action)){
			response.sendRedirect("/Ecom/E_Com_Web/docs/ECom_WebContent/html/dashboard_user.html");  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
