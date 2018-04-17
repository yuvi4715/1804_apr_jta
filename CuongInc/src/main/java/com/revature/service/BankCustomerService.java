package com.revature.service;

import java.util.List;

import com.revature.dao.BankCustomerDao;
import com.revature.dao.BankCustomerDaoImpl;
import com.revature.model.BankCustomer;

public class BankCustomerService {

	private static BankCustomerDao dao = new BankCustomerDaoImpl();

	public static boolean insertBankCustomer(BankCustomer inputCustomer) {
		return dao.insertBankCustomer(inputCustomer);
	}

	public static BankCustomer getBankCustomer(String username) {
		return dao.getBankCustomer(username);
	}

	public static List<BankCustomer> getAllBankCustomer() {
		return dao.getAllBankCustomer();
	}

	public static boolean updateBankCustomer(BankCustomer inputCustomer) {
		return dao.updateBankCustomer(inputCustomer);
	}
	
	public static boolean approveBankCustomer(BankCustomer inputCustomer) {
		return dao.approveBankCustomer(inputCustomer);
	}

	public static boolean deleteBankCustomer(String username) {
		return dao.deleteBankCustomer(username);
	}

}
