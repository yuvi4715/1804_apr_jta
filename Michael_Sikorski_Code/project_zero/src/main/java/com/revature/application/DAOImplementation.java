package com.revature.application;

import java.sql.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class DAOImplementation implements DAO {

	private static Scanner in = new Scanner(System.in);
	private static final Logger log = Logger.getLogger(Project0.class);

	private static DAOImplementation instance;

	private DAOImplementation() {}

	public static DAOImplementation getInstance() {
		if (instance == null) {
			instance = new DAOImplementation();
		}
		return instance;
	}

	@Override
	public void showAllAccounts() {
		try(Connection conn = ConnectionWithProperties.getConnection()) {
			log.info("An admin viewed all accounts");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("username: "+rs.getString(1) + 
						" - admin: " + (rs.getInt(3) == 1?"yes":"no") + 
						" - verified: " + (rs.getInt(5) == 1?"yes":"no") +
						" - email: " + rs.getString(6));
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
			log.error(sqle.getMessage() + " - " +sqle.getSQLState() + " - " + sqle.getErrorCode());
		}
	}

	@Override
	public void approveAccounts() {
		try(Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE is_verified='0'");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				boolean isAdmin = rs.getInt("is_admin")==1?true:false;
				System.out.println("username: " + rs.getString("username") + " - admin: " + isAdmin + " - email: " + rs.getString("email"));
				while (rs.next()) {
					isAdmin = rs.getInt("is_admin")==1?true:false;
					System.out.println("username: " + rs.getString("username") + " - admin: " + isAdmin + " - email: " + rs.getString("email"));
				}
			}
			else {
				System.out.println("There are no accounts pending approval");
				return;
			}

			System.out.print("Enter username you would like to approve (or q to exit): ");
			String s = in.nextLine();
			if (s.equals("q")) {
				return;
			} else {
				stmt = conn.prepareStatement("UPDATE bank_user SET is_verified=1 WHERE username=?");
				stmt.setString(1, s);
				if (stmt.executeUpdate() > 0) {
					log.info("An admin approved the following username: " + s);
					System.out.println(s + " has been approved");
				} else {
					System.err.println("That account does not exist or is already verified");
				}
			}			
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
			log.error(sqle.getMessage() + " - " +sqle.getSQLState() + " - " + sqle.getErrorCode());
		}
		return;
	}

	@Override
	public void showAllTransactions() {
		try(Connection conn = ConnectionWithProperties.getConnection()) {
			log.info("An admin viewed all transactions");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_transaction");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("amount: " + rs.getDouble(1) + 
						" -  type: " + (rs.getInt(2) == 0?"withdrawal":"deposit") + 
						" - date: " + (rs.getDate(3).toString()) +
						" - user: " + rs.getString(4));
				while (rs.next()) {
					System.out.println("amount: " + rs.getDouble(1) + 
							" -  type: " + (rs.getInt(2) == 0?"withdrawal":"deposit") + 
							" - date: " + (rs.getDate(3).toString()) +
							" - user: " + rs.getString(4));
				}
			} else {
				System.out.println("There are no transactions to display");
			}
			System.out.println();
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
			log.error(sqle.getMessage() + " - " +sqle.getSQLState() + " - " + sqle.getErrorCode());
		}
	}

	@Override
	public double getBalance(String username) {
		double balance = -1;
		try(Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT balance FROM bank_user WHERE username = ?");
			stmt.setString(1, username);
			if (stmt.execute()) {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					balance = rs.getDouble("balance");
				}
				return balance;
			}
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
			log.error(sqle.getMessage() + " - " +sqle.getSQLState() + " - " + sqle.getErrorCode());
		}
		return balance;
	}

	@Override
	public void withdraw(String username) {
		Double available = getBalance(username);
		System.out.print("Enter withdrawal amount (current balance is $" + available + "): ");
		String input = in.nextLine();
		try {
			Double amount = Double.parseDouble(input);
			if (amount > available) {
				System.err.println("You can't withdraw an amount greater than your balance!\n");
			} else {
				try(Connection conn = ConnectionWithProperties.getConnection()) {					
					PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET balance=? WHERE username=?");
					stmt.setDouble(1, (available - amount));
					stmt.setString(2, username);
					if (stmt.executeUpdate() > 0) {
						stmt = conn.prepareStatement("INSERT INTO bank_transaction VALUES (?,0,sysdate,?)");
						stmt.setDouble(1, amount);
						stmt.setString(2, username);
						if (stmt.executeUpdate() < 1) {
							System.err.println("There was a problem with the transaction");
						} else {
							System.out.println("Transaction was successful!\n");
							log.info(username + " withdrew " + amount + " from their account");
						}
					} else {
						System.err.println("Oops! There was a problem with your request!");
						log.error("There was a problem withdrawing from " + username + "'s account");
					}
				} catch(SQLException sqle) {
					System.err.println(sqle.getMessage());
					System.err.println("SQL State: " + sqle.getSQLState());
					System.err.println("Error Code: " + sqle.getErrorCode());
					log.error(sqle.getMessage() + " - " +sqle.getSQLState() + " - " + sqle.getErrorCode());
				}
			}
		} catch(NumberFormatException nfe) {
			System.err.println("That is not a valid amount!");
		}
	}

	@Override
	public void deposit(String username) {
		Double deposit;
		System.out.print("Enter deposit amount: ");
		String input = in.nextLine();
		try {
			deposit = Double.parseDouble(input);
			try(Connection conn = ConnectionWithProperties.getConnection()) {					
				PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET balance=? WHERE username=?");
				stmt.setDouble(1, (getBalance(username) + deposit));
				stmt.setString(2, username);
				if (stmt.executeUpdate() > 0) {
					stmt = conn.prepareStatement("INSERT INTO bank_transaction VALUES (?,1,sysdate,?)");
					stmt.setDouble(1, deposit);
					stmt.setString(2, username);
					if (stmt.executeUpdate() < 1) {
						System.err.println("There was a problem with the transaction");
					} else {
						System.out.println("Transaction was successful!\n");
						log.info(username + " deposited " + deposit + " into their account");
					}
				} else {
					System.err.println("Oops! There was a problem with your request!");
					log.error("There was a problem depositing into " + username + "'s account");
				}
			} catch(SQLException sqle) {
				System.err.println(sqle.getMessage());
				System.err.println("SQL State: " + sqle.getSQLState());
				System.err.println("Error Code: " + sqle.getErrorCode());
				log.error(sqle.getMessage() + " - " +sqle.getSQLState() + " - " + sqle.getErrorCode());
			}
		} catch(NumberFormatException nfe) {
		System.err.println("That is not a valid amount!");
	}

}
}
