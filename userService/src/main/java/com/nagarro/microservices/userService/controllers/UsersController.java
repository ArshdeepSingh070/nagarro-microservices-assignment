package com.nagarro.microservices.userService.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.userService.models.User;
import com.nagarro.microservices.userService.services.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/user")
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
		serviceList = restTemplate.getForObject(instance.getHomePageUrl() + url, ArrayList.class);

		return serviceList;

	}
	
	
	@PostMapping("/add")
	public String adduser(User user) {
		
		return userService.addUser(user);
	}

	// Check inter service connections
	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	@GetMapping("/testOrder/{id}")
	String testOrder(@PathVariable(name = "id") String id) {

		String url = "/order/test2?id=" + id;

		InstanceInfo instance = eurekaClient.getNextServerFromEureka("order", false);
		String orderStatus = restTemplate.getForObject(instance.getHomePageUrl() + url, String.class);

		return orderStatus;

	}
	
	@SuppressWarnings("unused")
	private String callStudentServiceAndGetData_Fallback(String id) {
		System.out.println("Student Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Student Service at this moment. Service will be back shortly - " + new Date();
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
