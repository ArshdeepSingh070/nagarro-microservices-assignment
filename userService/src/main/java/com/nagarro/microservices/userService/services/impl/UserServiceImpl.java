package com.nagarro.microservices.userService.services.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nagarro.microservices.userService.dao.UserDao;
import com.nagarro.microservices.userService.models.User;
import com.nagarro.microservices.userService.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	UserDao userDao;
	
	@Override
	public User getUserDetails(String id) throws IOException {

		return userDao.findUser(id);

	}

	@Override
	public User addUser(User user) {
		
		return userDao.addUser(user);
	}

	
}
