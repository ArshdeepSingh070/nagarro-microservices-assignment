package com.nagarro.microservices.price.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.price.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Resource
	PriceService priceService;
	
	@GetMapping(value = "/get/{id}")
	double getPrice(@PathVariable(name = "id") String id) {
		return priceService.getPrice(id);
	}

}
