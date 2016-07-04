package com.company.model;

public class Product {

	private int productId;
	private String proName;
	private String proDescription;
	private int proPrice;
	private int proQuantity;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDescription() {
		return proDescription;
	}
	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProQuantity() {
		return proQuantity;
	}
	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}
}
