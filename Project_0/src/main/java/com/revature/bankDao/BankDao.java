package com.revature.bankDao;

import java.math.BigDecimal;
import java.util.Scanner;

import com.revature.bankModel.Account;
import com.revature.bankModel.Admin;
import com.revature.bankModel.Customer;

public interface BankDao {

	public boolean createCustomer(Customer customer);
	public Customer loginCustomer(String userName, String passWord);
	public boolean getAllCustomers();
	public boolean deleteAccount(Account account);
	public boolean checkVerified(Customer customer);
	public boolean createAdmin(Admin admin);
	public Admin loginAdmin(String userName, String passWord);
	public boolean getAdmin(String admin_user_name);
	
	public boolean checkAccountBalance(Customer customer);
	public boolean createAccount(Customer customer, Scanner userInput);
	public boolean deleteAccount(Customer customer, Scanner userInput);
	public boolean addTransaction(int accountNumber, BigDecimal amount);
	public boolean viewTransactions(String userName);
	public boolean enforceAccount(Customer customer, int accountId);
	public boolean checkBalance(int accountId, BigDecimal amount);
	public boolean approveCustomer(Scanner userInput);
	public boolean viewAccountTransactions(int acctNumber);
	
}
