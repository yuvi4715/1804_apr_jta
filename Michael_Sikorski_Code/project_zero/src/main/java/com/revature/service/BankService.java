package com.revature.service;

import com.revature.dao.*;

public class BankService {
	
	private BankService() {}

	private static BankDAO dao = new BankDAOImplementation();
	
	public void showAllAccounts() {
		dao.showAllAccounts();
	}
	
	public void approveAccounts() {
		dao.approveAccounts();
	}
	
	public void showAllTransactions() {
		dao.showAllAccounts();
	}
	
	public double getBalance(String username) {
		return dao.getBalance(username);
	}
	
	public void withdraw(String username) {
		dao.withdraw(username);
	}
	
	public void deposit(String username) {
		dao.deposit(username);
	}
	
}
