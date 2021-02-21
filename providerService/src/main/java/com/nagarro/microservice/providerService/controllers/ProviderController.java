package com.nagarro.microservice.providerService.controllers;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservice.providerService.models.Provider;
import com.nagarro.microservice.providerService.models.ServiceInfo;
import com.nagarro.microservice.providerService.services.ProviderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

	@Autowired
	private EurekaClient eurekaClient;

	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;

	@Resource
	ProviderService providerService;

	@GetMapping(value = "/{id}")
	Provider getProviderDetails(@PathVariable(name = "id") String id) {

		System.out.println("Inside provider Controller");
		return providerService.getProviderDetails(id);

	}

	@GetMapping("/allServices")
	Map<String, String> findAllServices() {

		return providerService.getAllServices();
	}

	@GetMapping(value = "/price/{id}")
	double getPriceForService(@PathVariable(name = "id") String id) {
		ServiceInfo service = providerService.getServiceDetails(id);
		String url = "/price?serviceId" + service.getId();
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("prices", false);
		double price = restTemplate.getForObject(instance.getHomePageUrl() + url, double.class);
		return price;
	}

	@GetMapping(value = "test")
	String gettest() {

		System.out.println("Inside provider Controller");
		return "Welcome to provider server";

	}
}
