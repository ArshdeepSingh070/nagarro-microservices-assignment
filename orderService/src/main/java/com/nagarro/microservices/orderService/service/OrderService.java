package com.nagarro.microservices.orderService.service;

import com.nagarro.microservices.orderService.model.Order;

public interface OrderService {

	Order getOrderDetails(String id);

	String doPayment(String id);

	Order createOrder(Order order);

	void orderReady(String orderId);

	void orderUnconfirmed(String orderId);
}
