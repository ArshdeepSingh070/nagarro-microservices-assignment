package com.nagarro.microservices.userService.dao;

import com.nagarro.microservices.userService.models.User;

public interface UserDao {

	User findUser(String id);
}
