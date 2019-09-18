package com.developer.jdbc.model;

import java.util.HashSet;
import java.util.Set;



public class CustomerOrderList {
	private Long customerId;
	private String name, email;
	private Set<Order> orders = new HashSet<>();

	
	public CustomerOrderList(Long customerId, String name, String email, Set<Order> orders) {
		
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.orders = orders;
	}
	public CustomerOrderList() {
		// TODO Auto-generated constructor stub
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
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
