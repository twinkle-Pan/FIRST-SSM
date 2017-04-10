package com.first.demo.dao;

import java.util.List;

import com.first.demo.pojo.system.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

	public List<User>  find(User user);

	User findByUsername(String username);
    
    
}