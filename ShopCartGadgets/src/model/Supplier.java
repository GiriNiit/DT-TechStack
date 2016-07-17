package com.company.model;

public class Supplier {

	private int supplierId;
	private String supplierName;
	private String supplierAddress;
	private int supplierContact;
	private int productId;
	private int categoryId;
	private String categoryName;
	

	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public int getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(int supplierContact) {
		this.supplierContact = supplierContact;
	}
	
	
	
		public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
		
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName
				+ ", supplierAddress=" + supplierAddress + ", supplierContact=" + supplierContact + ", productId="
				+ productId + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + "]";
	}

}
