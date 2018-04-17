package com.revature.bankDao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankModel.Account;
import com.revature.bankModel.Admin;
import com.revature.bankModel.Customer;
import com.revature.bankUtil.establishConnection;

public class BankDaoImp implements BankDao{

	@Override
	public boolean createCustomer(Customer customer) {
		int index = 0;
		try (Connection conn = establishConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL insert_Customer(?,?,?,?)}");
			stmt.setString(++index, customer.getFirstName());
			stmt.setString(++index, customer.getLastName());
			stmt.setString(++index, customer.getUserName());
			stmt.setString(++index, customer.getPassWord());
			return stmt.executeUpdate() > 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	@Override
	public Customer loginCustomer(String userName, String passWord) {
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = 
						conn.prepareStatement("SELECT * FROM User_Customer WHERE User_Name = ? AND User_Password = ?");
			stmt.setString(1, userName);
			stmt.setString(2, passWord);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Customer customer = new Customer(rs.getString("User_Name"), rs.getString("User_Password"), 
						rs.getString("First_Name"), rs.getString("Last_Name"));
				return customer;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public Admin loginAdmin(String userName, String passWord) {
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = 
					conn.prepareStatement("SELECT * FROM User_Admin WHERE User_Name = ? AND Admin_Password = ?");
			stmt.setString(1, userName);
			stmt.setString(2, passWord);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Admin admin = new Admin(rs.getString("User_Name"), rs.getString("Admin_Password"), 
						rs.getString("First_Name"), rs.getString("Last_Name"));
				return admin;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
	
	
	@Override
	public boolean getAllCustomers() { ///Broken FIX LATER
		try (Connection conn = establishConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User_Customer");
			ResultSet rs = stmt.executeQuery();
			System.out.format("|%8s|","ID");
			System.out.format("|%15s|","User Name");
			System.out.format("|%15s|","First Name");
			System.out.format("|%15s|","Last Name");
			System.out.format("|%15s|","Approval");
			System.out.println("");
			while(rs.next()) {
				System.out.format("|%8s|", rs.getInt("Customer_Id"));
				System.out.format("|%15s|", rs.getString("User_Name"));
				System.out.format("|%15s|", rs.getString("First_Name"));
				System.out.format("|%15s|", rs.getString("Last_Name"));
				System.out.format("|%15s|", rs.getInt("Approval"));

				System.out.println("");
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return true;
	}

	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean createAdmin(Admin admin) {
		int index = 0;
		try (Connection conn = establishConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL insert_Admin(?,?,?,?)}");
			stmt.setString(++index, admin.getFirstName());
			stmt.setString(++index, admin.getLastName());
			stmt.setString(++index, admin.getUserName());
			stmt.setString(++index, admin.getPassWord());
			return stmt.executeUpdate() > 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}


	@Override
	public boolean getAdmin(String admin_user_name) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addTransaction(int accountNumber, BigDecimal amount) {

		try (Connection conn = establishConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL insert_Transaction(?,?)}");
			stmt.setInt(1, accountNumber);
			stmt.setBigDecimal(2, amount);
			return stmt.executeUpdate() > 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	@Override
	public boolean viewTransactions(String userName) {
		
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USER_TRANSACTION WHERE User_Name = ?");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			System.out.format("|%20s|","Transaction Amount");
			System.out.format("|%15s|","Date");
			System.out.println("");
			while(rs.next()) {
				System.out.format("|%20s|",rs.getLong("Transaction_Amount"));
				System.out.format("|%15s|",rs.getDate("Transaction_Date_Time"));
				System.out.println("");
			}
			return stmt.executeUpdate() > 0;		   
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean checkAccountBalance(Customer customer) {
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = 
			conn.prepareStatement("SELECT * FROM User_Account WHERE User_Name = ?");
			stmt.setString(1, customer.getUserName());
			ResultSet rs = stmt.executeQuery();
			System.out.format("|%15s|","Account Id");
			System.out.format("|%15s|","Account Name");
			System.out.format("|%15s|","Balance");
			System.out.println("");
			while(rs.next()) {
				System.out.format("|%15s|",rs.getInt("Account_Id"));
				System.out.format("|%15s|",rs.getString("Account_Name"));
				System.out.format("|%15s|",rs.getBigDecimal("Balance"));
				System.out.println("");
			}
			return true;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}

		return false;
	}

	@Override
	public boolean checkVerified(Customer customer) {
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = 
			conn.prepareStatement("SELECT Approval FROM User_Customer WHERE User_Name = ?");
			stmt.setString(1, customer.getUserName());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int i = rs.getInt("Approval");
				if(i == 1) {
					conn.close();return true;
				}
			}				
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}

		return false;
	}

	@Override
	public boolean createAccount(Customer customer, Scanner userInput) {
		try (Connection conn = establishConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL insert_Account(?,?)}");
			stmt.setString(1, customer.getUserName());
			System.out.println("Enter name for new account: ");
			String tempAcctName = userInput.nextLine();
			stmt.setString(2, tempAcctName);
			return stmt.executeUpdate() > 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
			
		return false;
	}

	@Override
	public boolean deleteAccount(Customer customer, Scanner userInput) {
		try (Connection conn = establishConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL delete_Account(?)}");
			System.out.println("Enter account number of account to be deleted: ");
			String tempAcctNumber = userInput.nextLine();			
			stmt.setString(1, tempAcctNumber);
			return stmt.executeUpdate() > 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}

		return false;
	}
	
	@Override
	public boolean enforceAccount(Customer customer, int accountId) {
		try (Connection conn = establishConnection.getConnection()){
			//boolean marker = false;
			PreparedStatement stmt = conn.prepareStatement("SELECT Account_Id FROM User_Account WHERE User_Name = ?");
			stmt.setString(1, customer.getUserName());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(accountId == rs.getInt("Account_Id")){
					return true;
				}
				
			}
			
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean checkBalance(int accountId, BigDecimal amount) {
		//Returns false if transaction is valid.
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement
					("SELECT Balance FROM User_Account WHERE Account_Id = ?");
			stmt.setInt(1, accountId);
			ResultSet rs = stmt.executeQuery();
			BigDecimal temp = new BigDecimal(0);
			while(rs.next()) {
				temp = rs.getBigDecimal("Balance");
			}
			if((temp.longValue() + amount.longValue()) < 0) {
				System.out.println((temp.longValue() + amount.longValue()));
				return false;
			}
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return true;
	}

	@Override
	public boolean approveCustomer(Scanner userInput) {
		try (Connection conn = establishConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall ("{CALL approve_Customer(?)}");
			System.out.println("Enter username of account you wish to approve:");
			String acct = userInput.nextLine();
			stmt.setString(1, acct);
			stmt.execute();
			return true;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean viewAccountTransactions(int acctNumber) {
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USER_TRANSACTION WHERE Account_Id =?");
			stmt.setInt(1, acctNumber);
			ResultSet rs = stmt.executeQuery();
			System.out.format("|%20s|","Transaction ID");
			System.out.format("|%20s|","Transaction Amount");
			System.out.format("|%20s|","Date");
			System.out.println("");
			while(rs.next()) {
				System.out.format("|%20s|",rs.getInt("Transaction_ID"));
				System.out.format("|%20s|",rs.getLong("Transaction_Amount"));
				System.out.format("|%15s|",rs.getDate("Transaction_Date_Time"));
				System.out.println("");
			}
			return stmt.executeUpdate() > 0;		   
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}



}
