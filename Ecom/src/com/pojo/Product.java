package com.pojo;

import java.util.List;

/**
 * @author Ronak
 *
 */
public class Product {

	private String categoryId;
	private String productId;
	private String productName;
	private Double price;
	private boolean isWarrenty;
	private List<Accesory> accesoryList;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isWarrenty() {
		return isWarrenty;
	}
	public void setWarrenty(boolean isWarrenty) {
		this.isWarrenty = isWarrenty;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<Accesory> getAccesoryList() {
		return accesoryList;
	}
	public void setAccesoryList(List<Accesory> accesoryList) {
		this.accesoryList = accesoryList;
	}
	@Override
	public String toString() {
		return "Product [categoryId=" + categoryId + ", productId=" + productId + ", productName=" + productName
				+ ", price=" + price + ", accesoryList=" + accesoryList + "]";
	}
	
	
}
