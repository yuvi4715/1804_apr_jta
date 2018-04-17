package com.revature.dao;
import java.util.List;

import com.revature.model.accounts;
import com.revature.model.user;

public interface BankAccountDao {

	public List<user> getAllUnactivatedUsers();
    public boolean createUser(user c);        //Create
    public user get(String username);         //Read
    public boolean updateUser(user u);        //Update
    public boolean deleteUser(user d);        //Delete
	
	public List<accounts> getAllAccounts();
	public boolean createAccount(accounts acc);
	public accounts get(int accountNumber);
	public boolean updateAccount(accounts updateAccount);        
    public boolean deleteAccount(accounts deleteAccount);
    
	
	
}
