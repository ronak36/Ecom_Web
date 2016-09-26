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

import com.pojo.Product;
import com.pojo.Store;

/**
 * Servlet implementation class DisplayProductServlet
 */
public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("category");
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("storeObject");
		HashMap<String, List<Product>> productMap = store.getProductMap();
		request.setAttribute("productList", productMap.get(category));
		System.out.println(productMap.get(category).toString());
		 RequestDispatcher rd = getServletContext()
                 .getRequestDispatcher("/E_Com_Web/docs/ECom_WebContent/html/displayProduct.jsp");
rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
