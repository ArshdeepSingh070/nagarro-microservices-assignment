package com.nagarro.microservices.userService.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.userService.models.User;
import com.nagarro.microservices.userService.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

	@Resource
	UserService userService;

	@GetMapping(value = "/{id}")
	User getUserDetailsByid(@PathVariable(name = "id") String id) {

		System.out.println("Inside User Controller");
		return userService.getUserDetails(id);

	}

}
