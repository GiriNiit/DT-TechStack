package com.company.model;

public class Product {

	private int productId;
	private String productName;
	private String productDescription;
	private int categoryId;
	private int productQuantity;
	private int productPrice;

	
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
		
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", categoryId=" + categoryId  + ", "
						+ "productQuantity=" + productQuantity + ", productPrice=" + productPrice  + "]";
	}

}
