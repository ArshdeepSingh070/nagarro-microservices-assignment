package com.nagarro.microservices.paymentService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@GetMapping("/test")
	String testService() {
		return "Welcome to Payment Service";
	}

}
