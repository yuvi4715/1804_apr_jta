package com.revature.bankDao;

import java.math.BigDecimal;
import java.util.List;

import com.revature.bankModel.Admin;
import com.revature.bankModel.Customer;

public interface BankDao {

	public boolean createCustomer(Customer customer);
	public Customer loginCustomer(String userName, String passWord);
	public List<String> getAllCustomers();
	public boolean deleteCustomer(Customer customer);
	
	public boolean createAdmin(Admin admin);
	public Admin loginAdmin(String userName, String passWord);
	public boolean getAdmin(String admin_user_name);
	
	public long checkAccountBalance(String userName);
	
	public boolean addTransaction(String userName, BigDecimal amount);
	public boolean viewTransactions(String userName);

	
}
