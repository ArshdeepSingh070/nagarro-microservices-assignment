package com.nagarro.microservices.orderService.dao;

import com.nagarro.microservices.orderService.model.Order;

public interface OrderDao {

	Order getOrder(String id);
	
	void updateOrder(Order order);
}
