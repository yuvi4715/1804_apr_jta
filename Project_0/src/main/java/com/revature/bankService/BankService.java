package com.revature.bankService;

import com.revature.bankModel.*;

import java.math.BigDecimal;
import java.util.Scanner;

import com.revature.bankDao.*;

public class BankService {

	private static BankDao dao = new BankDaoImp();

	public static boolean createCustomer(Customer customer) {
		return dao.createCustomer(customer);
	}
	
	public static Customer loginCustomer(String userName, String passWord) {
		return dao.loginCustomer(userName, passWord);
	}
	
	public static Admin loginAdmin(String userName, String passWord) {
		return dao.loginAdmin(userName, passWord);
	}
	
	public static boolean getAllCustomers(){
		return dao.getAllCustomers();
	}
	
	public static boolean addTransaction(int accountNumber, BigDecimal amount) {
		return dao.addTransaction(accountNumber, amount);
	}
	
	public static boolean viewTransactions(String userName) {
		return dao.viewTransactions(userName);
	}
	
	public static boolean checkAccountBalance(Customer customer) {
		return dao.checkAccountBalance(customer);
	}
	
	public static boolean deleteAccount(Account account) {
		return dao.deleteAccount(account);
	}
	
	public static boolean createAdmin(Admin admin) {
		return dao.createAdmin(admin);
	}

	public static boolean checkVerified(Customer customer) {
		return dao.checkVerified(customer);
	}
	
	public static boolean createAccount(Customer customer, Scanner userInput) {
		return dao.createAccount(customer, userInput);
	}
	
	public static boolean deleteAccount(Customer customer, Scanner userInput) {
		return dao.deleteAccount(customer, userInput);
	}
	
	public static boolean enforceAccount(Customer customer, int accountId) {
		return dao.enforceAccount(customer, accountId);
	}
	
	public static boolean checkBalance(int accountId, BigDecimal amount) {
		return dao.checkBalance(accountId, amount);
	}
	
	public static boolean approveUser(Scanner userInput) {
		return dao.approveCustomer(userInput);
	}
	
	public static boolean viewAccountTransactions(int acctNumber) {
		return dao.viewAccountTransactions(acctNumber);
	}
}
