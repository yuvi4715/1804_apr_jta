package com.revature.dao;

public interface BankDAO {
	
	void showAllAccounts();
	void approveAccounts();
	void showAllTransactions();
	double getBalance(String username);
	void withdraw(String username);
	void deposit(String username);
}
