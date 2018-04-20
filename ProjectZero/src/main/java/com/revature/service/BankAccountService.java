package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.bankapp.UserInterface;
import com.revature.dao.BankAccountDao;
import com.revature.implementation.BankAccountDaoImple;
import com.revature.model.user;

public class BankAccountService {
	final static Logger log = Logger.getLogger(UserInterface.class);

	
	static BankAccountDao caller = new BankAccountDaoImple();
	
	public static List<user> getAllUnactivatedUsers(){
		return caller.getAllUnactivatedUsers();
	}

	public static boolean createUser(user NewUser) {
		return caller.createUser(NewUser);
	}

	public static boolean createAdmin(user newuser) {
		return caller.createAdmin(newuser);
	}
	
	public static boolean updateUser(user activated) {
		return caller.updateUser(activated);
	}
	
	public static boolean updateAccount(user updateUser) {
		return caller.updateAccount(updateUser);
	}
	
	public static user userVerification(String username, String password) {
		return caller.userVerification(username, password);
	}
}