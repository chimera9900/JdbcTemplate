package com.developer.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CustomerOrderReport {
	private Long customerId;
	private String name, email;
	private int orderCount;
	
	
	
	@Override
	public String toString() {
		return "CustomerOrderReport [customerId=" + customerId + ", name=" + name + ", email=" + email + ", orderCount="
				+ orderCount + "]";
	}
	public CustomerOrderReport() {
		super();
	}
	public CustomerOrderReport(Long customerId, String name, String email, int orderCount) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.orderCount = orderCount;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
	


}
