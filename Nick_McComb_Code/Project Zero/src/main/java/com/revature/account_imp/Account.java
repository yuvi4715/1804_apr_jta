package com.revature.account_imp;

public interface Account {

	public void checkBalance(int id);
	public void deposit(int id);
	public void withdrawal(int id);
	public void transfer(int id1, int id2);
	public void passwordChange();
	public void firstNameChange();
	public void lastNameChange();
	public void usernameChange();
}
