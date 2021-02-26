package com.nagarro.microservice.price.model;

public class Price {

	private double amount;
	private String professionId;

	public Price(double amount, String professionId) {
		super();
		this.amount = amount;
		this.professionId = professionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getProfessionId() {
		return professionId;
	}

	public void setProfessionId(String professionId) {
		this.professionId = professionId;
	}

}
