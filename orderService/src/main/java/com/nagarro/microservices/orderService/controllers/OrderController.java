package com.nagarro.microservices.orderService.controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.orderService.model.Order;
import com.nagarro.microservices.orderService.service.OrderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Resource
	OrderService orderService;
	
	@GetMapping("/{orderId}")
	Order getOrderDetails(@PathVariable(name = "orderId") String id) {
		return orderService.getOrderDetails(id);
	}
	
	@PostMapping("/createOrder")
	public Order creatOrder(Order order) {
		return orderService.createOrder(order);	
	}
	
	/*
	 * After successful oder creation customer
	 * will do the required payment
	 */
	@GetMapping("/doPayment/{orderId}")
	String doPayment(@PathVariable(name = "orderId") String orderId) {
		String paymentStatus = orderService.doPayment(orderId);
		return paymentStatus;
	}
	
	@GetMapping("/test1")
	String test1Order() {
		return "welcome to order service";
	}
	
	@GetMapping("/test2")
	String test2Order(@RequestParam (name = "id") String id) {
		return "welcome to order service:" + id;
	}


}
