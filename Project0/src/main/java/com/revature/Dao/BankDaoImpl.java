package com.revature.Dao;
// This class is the implementation of the BankDAO interface

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.Model.Bank;
import com.revature.service.BankService;
import com.revature.util.ConnectionsWithPropertiesUtil;


public class BankDaoImpl implements BankDAO {
	// creating variable of instance making it a singleton
	private static BankDaoImpl instance;
	private BankDaoImpl() {}
	Scanner k = new Scanner(System.in);
	// ensuring there is only one instance of the interface and this class
	public static BankDAO getInstance() {
		if (instance ==null) {
			instance = new BankDaoImpl();
			
		}
		return instance;
	}
	
	
	// returns String based on user approval
	@Override
	public String isBankerApproved(Bank user) {
		String approved = "false";
		try (Connection conn =  ConnectionsWithPropertiesUtil.getConnection()) {
			if (user.getIsApproved() == "true") {
				approved = "true";
				return approved;
			} else if (user.getIsApproved() == null) {
				System.out.println("User is an admin");
				return "true";
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());
				
			}
		return approved;
		
	}
	
	// takes instance of bank user and inserts it into database
	@Override
	public boolean insertBanker(Bank user) {
		int index = 0;
		try (Connection conn =  ConnectionsWithPropertiesUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_banker(?,?,?,?,?,?,?,?)}");
			stmt.setString(++index, user.getFirstName());
			stmt.setString(++index, user.getLastName());
			stmt.setString(++index, user.getUserName());
			stmt.setString(++index, user.getPassword());
			stmt.setString(++index, user.getPrivilege());
			stmt.setString(++index, user.getIsApproved());
			stmt.setInt(++index, user.getCheckingBalance());
			stmt.setInt(++index, user.getSavingBalance());
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());
					
		}
		return false;
	}
	
	// returns boolean based on users privilege status
	@Override
	public boolean isBankerAdmin(Bank user) {
		 boolean isAdmin = false;
		try (Connection conn =  ConnectionsWithPropertiesUtil.getConnection()) {
			if (user.getPrivilege() == "admin") {
				isAdmin = true;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());
					
		}
		return isAdmin;
	}
	
	// returns a bank object based on username
	@Override
	public Bank getBankUser(String username) {
		try (Connection conn =  ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_account WHERE username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			// Can use if statement instead of while loop if you only expect one record
			if (rs.next()) {
				return new Bank(rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), 
						rs.getString("password"), rs.getString("account_privilege"),rs.getString("account_approved"), rs.getInt("checking_balance"),rs.getInt("savings_balance"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());
			
		}
		return null;
	}

	// returns all bankers into a list of bankers
	@Override
	public List<Bank> getAllBankers() {
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			List<Bank> bank = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_account");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bank.add(new Bank(rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"), rs.getString("account_privilege"), 
						rs.getString("account_approved"),rs.getInt("checking_balance"),rs.getInt("savings_balance")));
			}
			
			return bank;
			
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return null;
	}

	// unused for now. changes user's last name to muffin based on username
	@Override
	public boolean updateBankUser(String username) {
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET lastname = 'muffin' WHERE username = ?");
			stmt.setString(1, username);
			
			if (!stmt.execute()) {
				
				return stmt.getUpdateCount() > 0;
				
			}
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}

	// returns boolean  and deletes user based on  username
	@Override
	public boolean deleteBanker(String username) {
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM bank_account WHERE username = ?");
			stmt.setString(1, username);
			
			if (!stmt.execute()) {
					
				return stmt.getUpdateCount() > 0;
			}
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}

		return false;
	}

	// admin only method, returns boolan and validates user.
	@Override
	public boolean validateUser(String username) { // Method should only be available to admins
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET account_approved = 'true' WHERE username = ?");
			stmt.setString(1, username);
			
			
			return stmt.executeUpdate() > 0;
		
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}

		return false;
		
	}

	// deposit and withdrawal methods
	@Override
	public boolean depositChecking(Bank user, double amount) {
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET checking_balance = (checking_balance + ?) WHERE username = ?");
			stmt.setDouble(1, amount);
			stmt.setString(2, user.getUserName());
			
			return stmt.executeUpdate() > 0;
		
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}

		return false;
	}

	@Override
	public boolean depositSavings(Bank user, double amount) {
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET savings_balance = (savings_balance + ?) WHERE username = ?");
			stmt.setDouble(1, amount);
			stmt.setString(2, user.getUserName());
			
			return stmt.executeUpdate() > 0;
		
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}
	
	@Override
	public boolean withdrawSavings(Bank user, double amount) {
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET savings_balance = (savings_balance - ?) WHERE username = ?");
			stmt.setDouble(1, amount);
			stmt.setString(2, user.getUserName());
			
			return stmt.executeUpdate() > 0;
		
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean withdrawChecking(Bank user, double amount) {
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET checking_balance = (checking_balance - ?) WHERE username = ?");
			stmt.setDouble(1, amount);
			stmt.setString(2, user.getUserName());
			
			return stmt.executeUpdate() > 0;
		
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}

	// checks user credentials and returns banker if they are correct
	@Override
	public boolean logOn(String username, String password) {
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT username FROM bank_account WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			return stmt.executeUpdate() > 0;
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}
	
	// checks username availibility
	public boolean checkUsername(String username) { //used to determine if username already exists
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT username FROM bank_account WHERE username = ?");
			stmt.setString(1, username);
			return stmt.executeUpdate() > 0;
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}

	// admin process foe creating a user.
	public void adminInsertBanker() { // can insert both user and admin
		System.out.println("You wish to enter a new account!");
		System.out.println("Will the account be an admin? Enter yes, or no...");
		String adminInput;
		String userType = null; // set to null before use
		String userApproved = null;
		String fName;
		String lName;
		String uName;
		String pWord;
		
		boolean optionCompleted = false;
		do {
			adminInput = k.next();
			switch (adminInput.toLowerCase()) {
			case "yes":
				userType = "admin";
				System.out.println("The account will be an Admin, approval is not necessary");
				userApproved = null;
				optionCompleted = true;
				
				break;
			case "no" :
				userType = "user";
				System.out.println("The account will be a user. Since an admin is creating the account " 
						+ ", the user will automatically be approved.");
				userApproved = "true";
				optionCompleted = true;
				break;
				
			default:
				System.out.println("Invalid input please try again");
			}
		} while (optionCompleted == false);
		
		System.out.println("Please enter the first name.");
		fName = k.next();
		System.out.println("Please enter the last name.");
		lName = k.next();
		do { 
			System.out.println("Please enter the user name of the account.");
			uName = k.next();
			if (BankService.checkUsername(uName)){
				System.out.println("Username is already taken, please try again");
			}
			else {
				System.out.println("Username is availible");
				break;
			}
		} while(true);
		
		System.out.println("username is: " + uName);
		System.out.println("Please enter the password for the account");
		pWord = k.next();
		
		Bank tempUser = new Bank(fName, lName, uName, pWord, userType, userApproved, 0, 0);
		insertBanker(tempUser);
		System.out.println("A new " + userType + " with the username " + 
		uName + " has been added");
		System.out.println("Going back to main menu...");
			
	}
	
	// user process of creating a new account
	public void userInsertBanker() { // can insert both user and admin
		System.out.println("You have selected to create a new account!");
		System.out.println("Please remember that in order to use your new account you must wait for approval!");
		String userType = "user"; // set to null before use
		String userApproved = "false";
		String fName;
		String lName;
		String uName;
		String pWord;
	
		System.out.println("Please enter the first name.");
		fName = k.next();
		System.out.println("Please enter the last name.");
		lName = k.next();
		do { 
			System.out.println("Please enter the user name of the account.");
			uName = k.next();
			if (BankService.checkUsername(uName)){
				System.out.println("Username is already taken, please try again");
			}
			else {
				System.out.println("Username is availible");
				break;
			}
		} while(true);
		
		System.out.println("username is: " + uName);
		System.out.println("Please enter the password for the account");
		pWord = k.next();
		
		Bank tempUser = new Bank(fName, lName, uName, pWord, userType, userApproved, 0, 0);
		insertBanker(tempUser);
		System.out.println("A new " + userType + " with the username " + 
		uName + " has been added");
		System.out.println("Going back to main menu...");
	}


}
