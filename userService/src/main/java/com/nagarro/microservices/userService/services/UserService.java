package com.nagarro.microservices.userService.services;

import java.io.IOException;

import com.nagarro.microservices.userService.models.User;

public interface UserService {

	User getUserDetails(String id) throws IOException;
	
	User addUser(User user);
}
