package com.nagarro.microservices.userService.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.userService.models.User;
import com.nagarro.microservices.userService.services.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	private EurekaClient eurekaClient;

	@Resource
	UserService userService;

	@Resource(name = "restTemplate")
	private RestTemplate restTemplate;

	@GetMapping(value = "/{id}")
	User getUserDetailsByid(@PathVariable(name = "id") String id) {

		System.out.println("Inside User Controller");
		return userService.getUserDetails(id);

	}

	@GetMapping("/allServices")
	List<String> findAllServices() {

		/*
		 * Map<String, String> services = new HashMap<>(); services.put("001",
		 * "electrician"); services.put("002", "mechanic"); services.put("003",
		 * "hair dresser"); return services;
		 */

		List<String> serviceList = new ArrayList<>();
		String url = "/provider/allServices";

		InstanceInfo instance = eurekaClient.getNextServerFromEureka("providers", false);
		serviceList = restTemplate.getForObject(instance.getHomePageUrl() + url, null);

		return serviceList;

	}

	@GetMapping(value = "/service/{id}")
	String checkServiceStatus(@PathVariable(name = "id") String id) {
		return id + "service is available";
	}

	@GetMapping("/test")
	String testService() {
		return "welcome to user service";
	}
	
	// ADD USER POST METHOD IS TO IMPLEMENT

}
