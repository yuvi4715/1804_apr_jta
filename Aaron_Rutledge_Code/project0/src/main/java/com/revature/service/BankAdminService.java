package com.revature.service;

import com.revature.dao.BankAdminDao;
import com.revature.dao.TemplateDao;
import com.revature.model.BankAdmin;

public class BankAdminService {
	
	private static TemplateDao<BankAdmin, Integer> dao = new BankAdminDao();
	
	private BankAdminService() {}

	public static BankAdmin login(int key, String pass) {
		
		
		return dao.login(key, pass);
		
	}
	
}
