package com.nagaro.microservices.priceService.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.priceService.services.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Resource
	PriceService priceService;

	@GetMapping("/test")
	String testPrice() {
		return "Welcome to price Service";
	}

	@GetMapping
	double getPriceForService(@RequestParam(name = "serviceId") String id) {

		return priceService.getPrice(id);
	}

}
