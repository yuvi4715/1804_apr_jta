package com.system.service;

import java.util.List;


import com.system.dao.UserImpl;
import com.system.dao.UserInterface;
import com.system.model.User;

public class UserService {
	
	
	private static UserInterface dao = UserImpl.getInstance();

	
	public static User getUser(String username, String role, int id) {
		// TODO Auto-generated method stub
		return dao.getUser(username, role, id);
	}

	public static List<User> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}
}
