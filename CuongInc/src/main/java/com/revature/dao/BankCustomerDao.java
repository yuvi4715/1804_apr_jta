package com.revature.dao;

import java.util.List;

import com.revature.model.BankCustomer;

public interface BankCustomerDao {

	public boolean insertBankCustomer(BankCustomer inputCustomer);
	public BankCustomer getBankCustomer(String username);
	public List<BankCustomer> getAllBankCustomer();
	public boolean updateBankCustomer(BankCustomer inputCustomer);
	public boolean approveBankCustomer(BankCustomer inputCustomer);
	public boolean deleteBankCustomer(String username);
}
