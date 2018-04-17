package com.revature.service;

import java.util.List;

import com.revature.dao.BankAccountDao;
import com.revature.implementation.BankAccountDaoImple;
import com.revature.model.user;

public class BankAccountService {
	
	static BankAccountDao caller = new BankAccountDaoImple();
	
	public static List<user> getAllUnactivatedUsers(){
		return caller.getAllUnactivatedUsers();
	}

};
