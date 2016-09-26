package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Product;
import com.util.DataManagementUtility;

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();  
		String productId = request.getParameter("productId").toString();
		String productName = request.getParameter("productName").toString();
		String productPrice = request.getParameter("productPrice").toString();
		String category = request.getParameter("category2").toString();
		//all product info is captured.
		
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setPrice(Double.parseDouble(productPrice));
		product.setCategoryId(category);
		
		DataManagementUtility dmUtil = new DataManagementUtility();
		dmUtil.addProduct(request, product);
		
		out.println(" " + productId + " " + productName + " " + productPrice + " " + category);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
