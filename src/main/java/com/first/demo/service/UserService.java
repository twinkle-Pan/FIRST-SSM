package com.first.demo.service;

import com.first.demo.pojo.system.User;

public interface UserService {

	public String findUser(User user);

	public User findByUsername(String username);

}