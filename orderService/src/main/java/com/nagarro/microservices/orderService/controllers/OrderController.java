package com.nagarro.microservices.orderService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("/test1")
	String test1Order() {
		return "welcome to order service";
	}
	
	@GetMapping("/test2")
	String test2Order(@RequestParam (name = "id") String id) {
		return "welcome to order service:" + id;
	}


}
