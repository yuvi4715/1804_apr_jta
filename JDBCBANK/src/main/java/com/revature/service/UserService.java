package com.revature.service;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImp;
import com.revature.model.User;

public class UserService {
	private static BankDao dao = new BankDaoImp();

	public static boolean insertUser(User user) {
		return dao.insertUser(user);
	}

	public static boolean deleteUser(User user) {
		return dao.deleteUser(user);
	}

	public static boolean deposit(User user, double amount) {
		return dao.deposit(user, amount);

	}

	public static boolean withdraw(User user, double amount) {
		return dao.withdraw(user, amount);
	}

	public static boolean usernameTaken(String username) {
		return dao.usernameTaken(username);

	}

	public static boolean findUser(String username, String password) {
		return dao.findUser(username, password);

	}

	public static User userInfo(User user, String username) {
		return dao.userInfo(user, username);
		
		
	}

	public static User checkBalance(User user) {
		return dao.userBalance(user);
	
		
	}

	public static boolean approveUser(String username) {
		return dao.approveUser(username);
		
	}
	



}
