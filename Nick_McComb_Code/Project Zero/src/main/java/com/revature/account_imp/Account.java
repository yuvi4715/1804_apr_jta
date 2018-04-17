package com.revature.account_imp;

import com.revature.model.User;

public interface Account {

	public double checkBalance(int id);
	public boolean deposit(int id, double amount);
	public boolean withdrawal(int id, double amount);
	public boolean transfer(int id1, int id2, double amount);
	public boolean passwordChange(int id, String new_pw);
	public boolean firstNameChange(int id, String new_f_name);
	public boolean lastNameChange(int id, String new_l_name);
	public boolean usernameChange(int id, String new_un);
	public User getUserInfo(String un);
	public boolean closeAccount(int id);
	public boolean openAccount(int balance, String firstname, String lastname, 
								String username, String password, int verified, int admin);
	public boolean checkName(String check);
}
