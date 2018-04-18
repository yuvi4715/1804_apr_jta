package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface BankDao {
	//CRUD interface
	public boolean insertUser(User user); //create
	public User getUser(String username); //read
	public boolean updateUser(User user); //update
	public boolean deleteUser(User user); //delete
	public List<User> getAllUsers();
	public boolean deposit(User user, double amount);
	public boolean withdraw(User user, double amount);
	public boolean approveUser(String username);
	public boolean findUser(String username, String password);
	public boolean usernameTaken(String username);
	public User userInfo(User user, String username);
	public User userBalance(User user);

	

	
	
}
