package com.revature.bankService;

import com.revature.bankModel.*;

import java.math.BigDecimal;
import java.util.List;

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
	
	public static List<String> getAllCustomers(){
		return dao.getAllCustomers();
	}
	
	public static boolean addTransaction(String userName, BigDecimal amount) {
		return dao.addTransaction(userName, amount);
	}
	
	public static boolean viewTransactions(String userName) {
		return dao.viewTransactions(userName);
	}
	
	public static long checkAccountBalance(String userName) {
		return dao.checkAccountBalance(userName);
	}
	

}
