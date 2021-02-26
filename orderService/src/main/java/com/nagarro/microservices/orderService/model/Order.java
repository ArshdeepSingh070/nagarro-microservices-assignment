package com.nagarro.microservices.orderService.model;

import java.time.Instant;

public class Order {

	private String orderId;
	private String userId;
	private OrderStatus orderStatus;
	private Instant creationTime;
	private double transactionId;
	private double amount;
	
	
	public Order(String orderId, String userId, OrderStatus orderStatus, Instant creationTime, double transactionId,
			double amount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
}
