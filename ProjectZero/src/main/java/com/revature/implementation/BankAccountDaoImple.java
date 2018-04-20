package com.revature.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.BankAccountDao;
import com.revature.model.accounts;
import com.revature.model.user;
import com.revature.util.ConnectionsWithPropertiesUtil;

import java.sql.CallableStatement;
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
						resultset.getBoolean("isAdmin"), resultset.getDouble("balance")));
				
			}
			return result;
		} catch(SQLException e) {
			
		}
		return null;
	}
	
	
	@Override
	public boolean updateAccount(user updateAccount) {
		PreparedStatement stmt = null;
		int selectTransaction = 0;
		double deposit = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to make a (1) Deposit or (2) Withdrawal");
		selectTransaction = Integer.parseInt(scanner.nextLine());
		
		if(selectTransaction == 1) {
			System.out.println("How much would you like to deposit?");
			deposit = scanner.nextDouble(); 
				
			}
			else if (selectTransaction == 2) {
				System.out.println("How much would you like to withdraw?");
				deposit = scanner.nextDouble();	
				deposit = (deposit * -1);
			}
		
		try {
			stmt = conn.prepareStatement("UPDATE bankuser SET balance = balance + ? WHERE username = ?");
			stmt.setDouble(1, deposit);
			stmt.setString(2, updateAccount.getUsername());
		
			return stmt.executeUpdate() > 0;
		} catch(SQLException e) {
//			System.err.println(e.getMessage());
//			System.err.println("SQL State: " + e.getSQLState());
//			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return false;
	}
	
	

	@Override
	public boolean createUser(user c) {
		try(Connection connection = ConnectionsWithPropertiesUtil.getConnection()) {
			
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO bankuser VALUES(?, ?, ?, ?, "
				+ "?, ?, 0, 0, ?)");
		stmt.setString(1, c.getUsername());
		stmt.setString(2, c.getPassword());
		stmt.setString(3, c.getFirstname());
		stmt.setString(4, c.getLastname());
		stmt.setString(5, c.getEmail());
		stmt.setString(6, c.getAddress());
		stmt.setDouble(7, c.getBalance());


		return stmt.executeUpdate() > 0;
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		
		}
		return false;

	}
	
	@Override
	public boolean createAdmin(user c) {
		try(Connection connection = ConnectionsWithPropertiesUtil.getConnection()) {
			
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO bankuser VALUES(?, ?, ?, ?, "
				+ "?, ?, 1, 0, ?)");
		stmt.setString(1, c.getUsername());
		stmt.setString(2, c.getPassword());
		stmt.setString(3, c.getFirstname());
		stmt.setString(4, c.getLastname());
		stmt.setString(5, c.getEmail());
		stmt.setString(6, c.getAddress());
		stmt.setDouble(7, c.getBalance());

		return stmt.executeUpdate() > 0;
			
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		
		}
		return false;

	}
	
	
	

	@Override
	public user get(String username) {
		
		return null;
	}

	@Override
	public boolean updateUser(user c) {
		
		try(Connection connection = ConnectionsWithPropertiesUtil.getConnection()) {
			
			CallableStatement stmt = connection.prepareCall("{CALL update_user(?)}");
			stmt.setString(1, c.getUsername());

			return stmt.executeUpdate() > 0;
				
			}catch(SQLException e){
				System.err.println(e.getMessage());
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
			
			}
		
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
		try(Connection connection = ConnectionsWithPropertiesUtil.getConnection()) {
			
		}catch(SQLException e) {
			
		}
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
	@Override
	public user userVerification(String username, String password) {
		user verification = null;
		try(Connection connection = ConnectionsWithPropertiesUtil.getConnection()) {
			ConnectionsWithPropertiesUtil.getConnection();
			System.out.println(ConnectionsWithPropertiesUtil.getConnection());

			System.out.println(username+password);
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM bankuser WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet resultset = stmt.executeQuery();
			boolean flag = false;
			boolean flag2 = false;
			
			
			if(resultset.next()) {
				

				if(resultset.getInt("IsAdmin") == 1) {
					flag = true;

				}

				if(resultset.getInt("IsActive") == 1) {
					flag2 = true;
					
					verification = new user(resultset.getString("username"), resultset.getString("firstname"), resultset.getString("lastname"), resultset.getString("email"),
					resultset.getString("address"), flag, flag2, resultset.getDouble("balance"));	
				}
				else if (resultset.getInt("isActive") == 0) {
					return null;
				}
				
			}
			return verification;
			
			
			
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return verification;
	}

}
