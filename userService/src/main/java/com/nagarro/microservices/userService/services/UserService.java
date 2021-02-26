package com.nagarro.microservices.userService.services;

import com.nagarro.microservices.userService.models.User;

public interface UserService {

	User getUserDetails(String id);
	
	String addUser(User user);
}
