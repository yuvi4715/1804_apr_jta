package com.revature.implementation;

import java.util.LinkedList;
import java.util.List;

import com.revature.dao.BankAccountDao;
import com.revature.model.accounts;
import com.revature.model.user;
import com.revature.util.ConnectionsWithPropertiesUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccountDaoImple implements BankAccountDao {

	private Connection conn = ConnectionsWithPropertiesUtil.getConnection();
	
	public static void main(String[] args) {
		BankAccountDaoImple test = new BankAccountDaoImple();

		System.out.println(test.getAllUnactivatedUsers());
//		accounts a = new accounts(100, 43, "Savings" ); TESTING
//		double accountBalance, int accountNumber, String accountType
//		System.out.println(test.updateAccount(a));
	}
	@Override
	public List<user> getAllUnactivatedUsers() {
		List<user> result = new LinkedList<user> ();
		Statement stmt = null;
		ResultSet resultset = null;
		try {
			stmt = conn.createStatement();
			resultset = stmt.executeQuery("SELECT * FROM bankuser where isActive = 0");
			while(resultset.next()) {
				result.add(new user(resultset.getString("username"), resultset.getString("firstname"),
						resultset.getString("lastname"), resultset.getString("email"),
						resultset.getString("address"), resultset.getBoolean("isActive"), 
						resultset.getBoolean("isAdmin")));
				
			}
			return result;
		} catch(SQLException e) {
			
		}
		return null;
	}
	
	
	@Override
	public boolean updateAccount(accounts updateAccount) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE account SET balance = ?, type=? WHERE accountid = ?");
			stmt.setDouble(1, updateAccount.getAccountBalance());
			stmt.setString(2, updateAccount.getAccountType());
			stmt.setInt(3, updateAccount.getAccountNumber());
			return stmt.execute();
		} catch(SQLException e) {
			
		}

		return false;
	}
	
	

	@Override
	public boolean createUser(user c) {
		return false;
	}

	@Override
	public user get(String username) {
		
		return null;
	}

	@Override
	public boolean updateUser(user u) {
		return false;
	}

	@Override
	public boolean deleteUser(user d) {
		return false;
	}

	@Override
	public List<accounts> getAllAccounts() {
		return null;
	}

	@Override
	public boolean createAccount(accounts acc) {
		return false;
	}

	@Override
	public accounts get(int accountNumber) {
		return null;
	}


	@Override
	public boolean deleteAccount(accounts deleteAccount) {
		return false;
	}

}
