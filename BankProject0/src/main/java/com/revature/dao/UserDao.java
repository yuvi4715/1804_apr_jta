package com.revature.dao;

import java.util.List;

import com.revature.user.User;

public interface UserDao {
	public boolean insertUser(User user);
	public User getUser(String email);
	public boolean updateUserCheckingAccountBalance(User user, double ammountAdded);
	public boolean updateIsAdmin(String email, boolean status);
	public boolean updateNotCustomer(String email, boolean status);
	public boolean updateBankUser(User user);
	public List<User> getAllUsers();
	public List<String> getAllUserEmails();
	public boolean deleteUser(User user);
	public String checkPassword(String email);
	public boolean checkIfAdmin(String email);
	public boolean checkIfNotCustomer(String email);
	public List<String> findUnvarifiedUser();
	public List<String> findNonAdminUsers();
}
