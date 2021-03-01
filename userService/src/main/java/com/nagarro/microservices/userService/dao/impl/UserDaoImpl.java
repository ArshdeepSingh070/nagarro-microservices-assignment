package com.nagarro.microservices.userService.dao.impl;

import java.io.IOException;
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
	public User findUser(String id) throws IOException {
		allStoredUser();
		User requiredUser = users.get(id);
		if(requiredUser == null) {
			throw new IOException("User Not found");
		}
		return requiredUser;
	}
	
	@Override
	public User addUser(User user) {
		users.put(user.getId(), user);
		return users.get(user.getId());
	}

	
	// pseudo user for demo purpose only
	protected Map<String, User> allStoredUser() {

		User user = new User("101", "Arsh", "male", "arsh@123.com","7536578799");

		users.put(user.getId(), user);

		return users;

	}

	

}
