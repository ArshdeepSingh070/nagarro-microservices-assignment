package com.nagarro.microservices.userService.dao;

import java.io.IOException;

import com.nagarro.microservices.userService.models.User;

public interface UserDao {

	User findUser(String id) throws IOException;
	
	User addUser(User user);
}
