package com.pojo;

import java.util.List;

/**
 * @author Ronak
 *
 */
public class Order {

	private String orderId;
	private List<Product> productList;
	private Customer customer;
	private double total;
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productList=" + productList + ", customer=" + customer + ", total="
				+ total + "]";
	}
	
	
}
