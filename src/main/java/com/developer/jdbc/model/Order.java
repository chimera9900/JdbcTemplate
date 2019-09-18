package com.developer.jdbc.model;

public class Order {
	private long id;
	private String sku;
	
	
	public Order(long id, String sku) {
		super();
		this.id = id;
		this.sku = sku;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
}
