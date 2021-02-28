package com.nagarro.microservices.userService.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nagarro.microservices.userService.dao.UserDao;
import com.nagarro.microservices.userService.models.User;

@Component
public class UserDaoImpl implements UserDao {

	private Map<String, User> users = new HashMap<>();
	
	@Override
	public User findUser(String id) {
		allStoredUser();
		User requiredUser = users.get(id);
		return requiredUser;
	}
	
	@Override
	public String addUser(User user) {
		if(user.getId() == null) {
			return "User id can not be null";
		}
		users.put(user.getId(), user);
		return "USER" + user.getId() + "ADDED SUCCESSFULLY";
	}

	
	// pseudo user for demo purpose
	protected Map<String, User> allStoredUser() {

		User user = new User("101", "Arsh", "male", "arsh@123.com","7536578799");

		users.put(user.getId(), user);

		return users;

	}

	

}
