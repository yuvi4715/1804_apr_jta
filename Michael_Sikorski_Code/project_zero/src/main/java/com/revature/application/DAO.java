package com.revature.application;

public interface DAO {
	
	void showAllAccounts();
	void approveAccounts();
	void showAllTransactions();
	double getBalance(String username);
	void withdraw(String username);
	void deposit(String username);
}
