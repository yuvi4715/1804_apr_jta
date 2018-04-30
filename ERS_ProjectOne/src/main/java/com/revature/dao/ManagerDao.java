package com.revature.dao;

import com.revature.model.Manager;

public interface ManagerDao {
	public Manager getManager(String username, String password);
}
