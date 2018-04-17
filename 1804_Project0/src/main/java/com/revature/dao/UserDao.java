package com.revature.dao;

import com.revature.model.User;

public interface UserDao {
	public boolean activate(String username);
	public boolean deactivate(String username);
	public boolean promoteAdmin(String username);
	public boolean revokeAdmin(String username);
	public User deposit(User user, double amount);
	public User withdraw(User user, double amount);
}
