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
		List<User> users = allStoredUser();
		Optional<User> reuiredUser = users.stream().filter(user -> id.equals(user.getId())).findFirst();
		return reuiredUser.get();
	}
	
	@Override
	public String addUser(User user) {
		users.put(user.getId(), user);
		return "USER" + user.getId() + "ADDED SUCCESSFULLY";
	}

	protected List<User> allStoredUser() {

		List<User> usersList = new ArrayList<>();

		usersList.add(new User("001", "Arsh", "male", "arsh@123.com","7536578799"));

		return usersList;

	}

	

}
