package com.nagarro.microservices.orderService.model;

import java.time.Instant;

public class Order {

	private String orderId;
	private String userId;
	private String serviceId;
	private String providerId;
	private OrderStatus orderStatus;
	private Instant creationTime;
	private double transactionId;
	private double amount;
	
	public Order() {
		
	}
	
	public Order(String orderId, String userId, String serviceId, String providerId, OrderStatus orderStatus,
			Instant creationTime, double transactionId, double amount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.serviceId = serviceId;
		this.providerId = providerId;
		this.orderStatus = orderStatus;
		this.creationTime = creationTime;
		this.transactionId = transactionId;
		this.amount = amount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Instant getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Instant creationTime) {
		this.creationTime = creationTime;
	}

	public double getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
