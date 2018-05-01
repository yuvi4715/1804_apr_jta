package com.system.dao;

import java.util.List;

import com.system.model.User;

public interface UserInterface {

	public User getUser(String username, String role, int id);
	public List<User> getAllUser();
	public boolean updateUser(User user);
	
}
