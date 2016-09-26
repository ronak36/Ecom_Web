package com.pojo;

import java.util.HashMap;
import java.util.List;

import com.pojo.Cart;
import com.pojo.Customer;
import com.pojo.Order;
import com.pojo.Product;

/**
 * @author Ronak
 *
 */
public class Store {

	HashMap<String,List<Product>> productMap;
	HashMap<String,Customer> customerMap;
	HashMap<String,List<Order>> orderMap;
	HashMap<String,Cart> cartMap;
	
	public HashMap<String, Customer> getCustomerMap() {
		return customerMap;
	}
	public void setCustomerMap(HashMap<String, Customer> customerMap) {
		this.customerMap = customerMap;
	}
	public HashMap<String, List<Product>> getProductMap() {
		return productMap;
	}
	public void setProductMap(HashMap<String, List<Product>> productMap) {
		this.productMap = productMap;
	}
	public HashMap<String, List<Order>> getOrderMap() {
		return orderMap;
	}
	public void setOrderMap(HashMap<String, List<Order>> orderMap) {
		this.orderMap = orderMap;
	}
	public HashMap<String, Cart> getCartMap() {
		return cartMap;
	}
	public void setCartMap(HashMap<String, Cart> cartMap) {
		this.cartMap = cartMap;
	}
	@Override
	public String toString() {
		return "Store [productMap=" + productMap + ", customerMap=" + customerMap + ", orderMap=" + orderMap
				+ ", cartMap=" + cartMap + "]";
	}
	
	

}
