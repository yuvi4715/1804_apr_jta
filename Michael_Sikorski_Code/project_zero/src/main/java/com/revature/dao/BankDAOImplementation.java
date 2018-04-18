package com.revature.dao;

import java.sql.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.application.ConnectionWithProperties;
import com.revature.application.Project0;

public class BankDAOImplementation implements BankDAO {

	private static Scanner in = new Scanner(System.in);
	private static final Logger log = Logger.getLogger(Project0.class);

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
					System.err.println("That account is already verified or does not exist");
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
			if (rs.absolute(1)) {
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
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO bank_transaction VALUES (?,1,sysdate,?)");
					stmt.setDouble(1, amount);
					stmt.setString(2, username);

					PreparedStatement stmt2 = conn.prepareStatement("UPDATE bank_user SET balance=? WHERE username=?");
					stmt.setDouble(1, (available - amount));
					stmt.setString(2, username);

					if (stmt.executeUpdate() > 0) {
						log.info(username + "'s withdrawal was added to the transaction table");
						if (stmt2.executeUpdate() > 0) {
							log.info(username + " withdrew $" + amount + " from their account");
							System.out.println("The transaction was successful!");
						} else {
							log.error("A transaction was added to the database, but " + username + "'s account did not get updated");
						}
						log.info(username + " withdrew " + amount + " from their account");
					} else {
						log.error(username + " tried withdrawing from their account, but the transaction failed");
						System.err.println("There was a problem withdrawing from your account. Please try again.");
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
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO bank_transaction VALUES (?,1,sysdate,?)");
				stmt.setDouble(1, deposit);
				stmt.setString(2, username);

				PreparedStatement stmt2 = conn.prepareStatement("UPDATE bank_user SET balance=? WHERE username=?");
				stmt2.setDouble(1, (getBalance(username) + deposit));
				stmt2.setString(2, username);
				if (stmt.executeUpdate() > 0) {
					log.info(username + "'s deposit was added to the transaction table");
					if (stmt2.executeUpdate() > 0) {
						log.info(username + " deposited $" + deposit + " into their account");
						System.out.println("The transaction was successful!");
					} else {
						log.error("A transaction was added to the database, but " + username + "'s account did not get updated");
					}
					log.info(username + " deposited " + deposit + " into their account");
				} else {
					log.error(username + " tried depositing into their account, but the transaction failed");
					System.err.println("There was a problem depositing into your account. Please try again.");
				}
			} catch(SQLException sqle) {
				System.err.println(sqle.getMessage());
				System.err.println("SQL State: " + sqle.getSQLState());
				System.err.println("Error Code: " + sqle.getErrorCode());
				log.error(sqle.getMessage() + " - " +sqle.getSQLState() + " - " + sqle.getErrorCode());
			}
		} catch(NumberFormatException nfe) {
			System.err.println("That is not a valid amount!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
