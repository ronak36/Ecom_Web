package com.pojo;

import java.util.List;

public class Cart {

	List<Product> productCartList;

	public List<Product> getProductCartList() {
		return productCartList;
	}

	public void setProductCartList(List<Product> productCartList) {
		this.productCartList = productCartList;
	}

	@Override
	public String toString() {
		return "Cart [productCartList=" + productCartList + "]";
	}
	
	
	
}
