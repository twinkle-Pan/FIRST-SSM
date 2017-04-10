package com.first.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.demo.dao.UserMapper;
import com.first.demo.pojo.system.User;
import com.first.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
	@Override
	public String findUser(User user) {
	 List<User>	list=userMapper.find(user);
	 System.out.println("112");
	 	return "success";
	}
	@Override
	public User findByUsername(String username) {
		User user=userMapper.findByUsername(username);
		return user;
	}

}
