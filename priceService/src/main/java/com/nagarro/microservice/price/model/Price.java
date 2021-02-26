package com.nagarro.microservice.price.model;

public class Price {

	private double amount;
	private String serviceId;

	public Price(double amount, String serviceId) {
		super();
		this.amount = amount;
		this.serviceId = serviceId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	

}
