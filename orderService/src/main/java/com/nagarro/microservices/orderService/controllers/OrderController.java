package com.nagarro.microservices.orderService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping("/test")
	String testOrder() {
		return "welcome to order service";
	}

}
