package com.nagarro.microservice.providerService.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservice.providerService.models.Provider;
import com.nagarro.microservice.providerService.services.ProviderService;

@RestController
@RequestMapping(value = "/")
public class ProviderController {

	@Resource
	ProviderService providerService;

	@GetMapping(value = "/{id}")
	Provider getProviderDetails(@PathVariable(name = "id") String id) {

		System.out.println("Inside provider Controller");
		return providerService.getProviderDetails(id);

	}

	@GetMapping(value = "test")
	String gettest() {

		System.out.println("Inside provider Controller");
		return "Welcome to test server";

	}
}
