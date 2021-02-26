package com.nagarro.microservices.paymentService.controllers;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	Random rand = new Random(); 
	
	@GetMapping("/test")
	String testService() {
		return "Welcome to Payment Service";
	}
	
	@GetMapping()
	double doPayment(@RequestParam (name = "price") double price) {
		
		System.out.println("Doing the pesudo payment and generating and returing transaction id to order service");
		return rand.nextDouble();
	}

}
