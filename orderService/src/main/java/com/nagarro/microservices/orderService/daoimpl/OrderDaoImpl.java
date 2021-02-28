package com.nagarro.microservices.orderService.daoimpl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.nagarro.microservices.orderService.dao.OrderDao;
import com.nagarro.microservices.orderService.model.Order;
import com.nagarro.microservices.orderService.model.OrderStatus;

@Component
public class OrderDaoImpl implements OrderDao {

	private  Map<String, Order> orders  = new HashMap<String, Order>();
	
	@Override
	public Order getOrder(String id) {
		List<Order> orderList = createdOrder();
		return orderList.stream().filter(o -> id.equals(o.getOrderId())).findFirst().get();
	}

	@Override
	public void updateOrder(Order order) {
		createdOrder();
		this.orders.put(order.getOrderId(), order);
		
	}
	

	// Pseudo order Details for demo
	List<Order> createdOrder(){
		List<Order> orderList = new ArrayList<>();
		Order order = new Order("001", "101", "201", "301", OrderStatus.PROCESSING, null, 0, 500);
		orderList.add(order);
		return orderList;
	}
}
