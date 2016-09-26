package com.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.Arrays;

import com.pojo.Cart;
import com.pojo.Order;
import com.pojo.Product;
import com.pojo.Store;

public class DataManagementUtility {

	public void addProduct(HttpServletRequest request, Product product){
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("storeObject");
		HashMap<String, List<Product>> productsMap = store.getProductMap();
		List<Product> productList = productsMap.get(product.getCategoryId());
		if(productList !=null){
			productList.add(product);
			productsMap.replace(product.getCategoryId(), productList);
		}
		else{
			productList = new ArrayList<Product>();
			productList.add(product);
			productsMap.put(product.getCategoryId(), productList);
		}
		store.setProductMap(productsMap);
		session.setAttribute("storeObject", store);
	}

	public void deleteProduct(HttpServletRequest request,Product product){
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("storeObject");
		HashMap<String, List<Product>> productsMap = store.getProductMap();
		List<Product> productList = productsMap.get(product.getCategoryId());
		if(productList !=null){
			for(int i=0;i<productList.size();i++){
				Product product2 = productList.get(i);
				if(product2.getProductId().equals(product.getProductId())){
					productList.remove(i);
				}
			}
			productsMap.replace(product.getCategoryId(), productList);
		}
		store.setProductMap(productsMap);
		session.setAttribute("storeObject", store);
	}

	public void removeProductFromCart(HttpServletRequest request,Product product){
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("storeObject");
		String userId = (String)session.getAttribute("userId");
		HashMap<String,Cart> cartMap = store.getCartMap();
		Cart cart = cartMap.get(userId);
		if(cart != null){
			List<Product> cartProductList = cart.getProductCartList();
			if(cartProductList !=null){
				for(int i=0;i<cartProductList.size();i++){
					Product product2 = cartProductList.get(i);
					if(product2.getProductId().equals(product.getProductId())){
						cartProductList.remove(i);
					}
				}
				cart.setProductCartList(cartProductList);
				cartMap.replace(userId, cart);
			}
		}
		store.setCartMap(cartMap);
		session.setAttribute("storeObject", store);
	}

	public void addToCart(HttpServletRequest request,Product product){
		System.out.println("add to cart started");
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("storeObject");
		String userId = (String) session.getAttribute("userId");
		HashMap<String, List<Product>> productsMap = store.getProductMap();
		List<Product> productList = productsMap.get(product.getCategoryId());
		boolean isCartNew = false;
		HashMap<String,Cart> cartMap = store.getCartMap();
		Cart cart = cartMap.get(userId);
		if(cart == null){
			cart = new Cart();
			isCartNew = true;
		}
		List<Product> productCartList = cart.getProductCartList();
		if(productCartList == null ){
			productCartList = new ArrayList<Product>();
		}

		if(productList !=null){
			for(int i=0;i<productList.size();i++){
				Product product2 = productList.get(i);
				if(product2.getProductId().equals(product.getProductId())){
					productCartList.add(product2);
				}
			}
		}
		cart.setProductCartList(productCartList);
		if(isCartNew){
			cartMap.put(userId, cart);
		}
		else{
			cartMap.replace(userId, cart);
		}
		System.out.println("cart"+ cart);
		store.setCartMap(cartMap);
		System.out.println("new store" + store);
		session.setAttribute("storeObject", store);
	}

	public void generateBill(HttpServletRequest request){
		System.out.println("generate bill started");
		HttpSession session = request.getSession();
		Store store = (Store)session.getAttribute("storeObject");
		String userId = (String) session.getAttribute("userId");

		HashMap<String,Cart> cartMap = store.getCartMap();
		Cart cart = cartMap.get(userId);
		List<Product> productCartList = cart.getProductCartList();

		HashMap<String,List<Order>> orderMap = store.getOrderMap();
		List<Order> orderList = orderMap.get(userId);
		if(orderList == null){
			orderList = new ArrayList<Order>();
		}
		Order order = new Order();
		int orderId = orderList.size() + 1;
		order.setOrderId(orderId + "");
		order.setProductList(productCartList);
		double total = 0d;
		for(int i=0; i<productCartList.size();i++){
			total = total + productCartList.get(i).getPrice();
			if(productCartList.get(i).isWarrenty()){
				total = total + 10;
			}
		}
		order.setTotal(total);
		orderList.add(order);
		orderMap.put(userId,orderList);
		cartMap.remove(userId);
		store.setCartMap(cartMap);
		store.setOrderMap(orderMap);
		session.setAttribute("storeObject", store);
		System.out.println("gen store" + store);
	}

}
