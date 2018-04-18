package com.revature.service;

import com.revature.model.AccountHolder;
import com.revature.dao.TemplateDao;

import java.util.List;

import com.revature.dao.AccountHolderDao;

public class AccountHolderService {
	
	private static TemplateDao<AccountHolder, Integer> dao = new AccountHolderDao();
	
	private AccountHolderService() {}
	
	public static boolean insertAH(AccountHolder ah) {
		
		return dao.insert(ah);
		
	}
	
	public static AccountHolder getAH(int id) {
		
		return dao.get(id);

	}
	
	public static boolean updateAH(AccountHolder ah) {
		
		return dao.update(ah);
		
	}
	
	public static List<AccountHolder> getAllAH() {
		
		return dao.getAll();
		
	}
	
	public static AccountHolder login(int key, String pass) {
		
		return dao.login(key, pass);
		
	}
	
	public static boolean updateStatus(int key) {
		
		return dao.updateStatus(key);
		
	}

}
