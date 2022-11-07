package com.example.DriverService.Model;

import java.util.List;

import com.example.DriverService.Entity.Driver;


public class RequireResponse {
	private Driver driver;
	private List<Customer> customer;
	public RequireResponse(Driver driver, List<Customer> customer) {
		super();
		this.driver = driver;
		this.customer = customer;
	}
	public RequireResponse() {
		super();
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	
}
