package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.user.User;

public class BankService {

	private static UserDao dao = new UserDaoImpl();
	private static Logger log = Logger.getLogger(BankService.class);
	
	public static boolean insertUser(User user) {
		try {
			dao.insertUser(user);
			log.info("=====>> User " + user.getEmail() + " successfully inserted");
			return true;
		} catch (Exception e) {
			log.info("=====>>Caught Exception in Bank Service: " + e.getMessage());
			return false;
		}
	}
	
	public static User getUser(String email) {
		return dao.getUser(email);
	}
	
	public static boolean deleteUser(User user) {
		return dao.deleteUser(user);
	}
	
	public static boolean updateUserCheckingAccountBalance(User user, double ammountAdded) {
		try {
			dao.updateUserCheckingAccountBalance(user, ammountAdded);
			log.info("=====>>Updated user balance");
			return true;
		}
		catch (Exception e) {
			log.info("=====>>Caught exception in updating bank account " + e.getMessage());
			return false;
		}
	}
	
	public static boolean updateIsAdmin(String email, boolean status) {
		return dao.updateIsAdmin(email, status);
	}
	
	public static boolean updateNotCustomer(String email, boolean status) {
		return dao.updateNotCustomer(email, status);
	}
	
	public static boolean updateBankUser(User user) {
		return dao.updateBankUser(user);
	}
	
	public static List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	
	public static List<String> getAllUserEmails() {
		return dao.getAllUserEmails();
	}
	
	public static String checkPassword(String email) {
		return dao.checkPassword(email);
	}
	
	public static boolean checkIfAdmin(String email) {
		return dao.checkIfAdmin(email);
	}
	
	public static boolean checkIfNotCustomer(String email) {
		return dao.checkIfNotCustomer(email);
	}
	
	public static List<String> findUnverifiedUser() {
		return dao.findUnvarifiedUser();
	}
	
	public static List<String> findNonAdminUsers() {
		return dao.findNonAdminUsers();
	}
}
