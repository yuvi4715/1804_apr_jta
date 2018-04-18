package com.revature.service;

import java.util.List;

import com.revature.dao.BankAccountDao;
import com.revature.dao.TemplateDao;
import com.revature.model.BankAccount;

public class BankAccountService {
	
	private static TemplateDao<BankAccount, Integer> dao = new BankAccountDao();
	
	private BankAccountService() {}
	
	public static boolean insertBA(BankAccount ba) {
		
		return dao.insert(ba);
		
	}
	
	public static BankAccount getBA(int id) {
		
		return dao.get(id);

	} 
	
	public static boolean updateBA(BankAccount ba) {
		
		return dao.update(ba);
		
	}
	
	public static List<BankAccount> getAllBA() {
		
		return dao.getAll();
		
	}
	
	
	

}
