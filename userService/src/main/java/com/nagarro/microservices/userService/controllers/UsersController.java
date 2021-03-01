package com.nagarro.microservices.userService.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.nagarro.microservices.userService.models.Service;
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
	User getUserDetailsByid(@PathVariable(name = "id") String id) throws IOException {

		Optional.ofNullable(id).orElse("User ID can not be empty");
		try {
			return userService.getUserDetails(id);
		} catch (IOException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
		}

	}

	@PostMapping("/add")
	public User adduser(@RequestBody User user) {

		return userService.addUser(user);
	}

	/*
	 * User search for the service 
	 * return service information along with its availability
	 */
	// @HystrixCommand(fallbackMethod = "serviceProvider_Fallback")
	@GetMapping("/searchService/{code}")
	Service serachService(@PathVariable(name = "code") String code) {

		Service service;
		String url = "/service/getService/" + code;
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("provider", false);
		service = restTemplate.getForObject(instance.getHomePageUrl() + url, Service.class);
		return service;
	}

	@SuppressWarnings("unused")
	private String serviceProvider_Fallback(String id) {
		System.out.println("serviceProvider Service is down!!! fallback route enabled...");
		return "Service taking long at this moment or is down. pls try after some time - " + new Date();
	}

}
