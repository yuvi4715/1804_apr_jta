package revature.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserPage{
	static Scanner log = new Scanner(System.in);
	static int loginType;
	static int logout;
	static UserPage user = new UserPage();
	public static void User() {
		
		System.out.println("Welcome to Customer Sign-in Page.");
		System.out.println("Select you option \n1 for Log-In. \n2 for Sign-Up. \nEnter your option : ");
		do {
			loginType = log.nextInt();
			if(loginType == 1) {
				System.out.println("Enter your Credentials");
				
				System.out.println("Enter your UserName : ");
				String userName = log.next();
				
				System.out.println("Enter your Password : ");
				String password = log.next();
				
				//System.out.println("UserName - " + userName +"\nPassword - " + password);
				int index = 0;
				try (Connection conn = dbConnection.getConnection()) {
					PreparedStatement stmt = conn.prepareStatement("SELECT userId, name, depositAmount FROM userInfo WHERE userName = ? AND userPassword = ? AND adminApprovalStatus=? ");
					stmt.setString(++index, userName);
					stmt.setString(++index, password);
					stmt.setString(++index, "yes");
					
					ResultSet rs = stmt.executeQuery();
					System.out.println("Your account Details");
					if(rs.next()) {
						System.out.println("Name - " + rs.getString("name"));
						System.out.println("Balance - " + rs.getInt("depositAmount") + "$");
						
						System.out.println("1 for Logout \n2 for Withdraw \n3 for Deposit");
						logout = log.nextInt();
						if(logout == 1) {
							MainAppPage.main(null);
						}else if(logout == 2) {
							int d = rs.getInt("depositAmount");
							String name = rs.getString("name");
							int userId = rs.getInt("userId");
							user.withdraw(d, name, userId);
						}else {
							int d = rs.getInt("depositAmount");
							String name = rs.getString("name");
							int userId = rs.getInt("userId");
							user.deposit(d,name, userId);
						}
						
					}else {
						System.out.println("Your account is Not Approved..!!!");
						MainAppPage.main(null);
					}
				} catch (SQLException sqle) {
					System.err.println(sqle.getMessage());
					System.err.println("SQL State: " + sqle.getSQLState());
					System.err.println("Error Code: " + sqle.getErrorCode());
				}
				
			}else {
				if(loginType == 2) {
					System.out.println("Enter your Information");
					System.out.println("Name : ");
					String name = log.next();
					System.out.println("Address : ");
					String address = log.next();
					System.out.println("Phone-Numer : ");
					int phoneNum = log.nextInt();
					System.out.println("Amount to Deposit : ");
					int deposit = log.nextInt();
					System.out.println("User-Name : ");
					String userName = log.next();
					System.out.println("Password : ");
					String password = log.next();
	
					user.savingData(name, address, phoneNum, deposit, userName, password);
					
				}else {
					System.out.println("Select a valid user option");
				}
			}
			}while(loginType >2);
			log.close();
	}
	
	

	public void savingData(String name,String address, int phone, int deposit, String username, String password) {
		
		System.out.println("Name : " + name);
		System.out.println("Address : " + address);
		System.out.println("Phone-Numer : " + phone);
		System.out.println("Amount to Deposit : " + deposit);
		System.out.println("User-Name : " + username);
		System.out.println("Password : " + password);
		int index = 0;
		try(Connection conn = dbConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO userInfo "
					+ "(name, userName, userPassword, address, phone, depositAmount, adminApprovalStatus) VALUES (?, ?, ?,?,?,?,?)");
			//stmt.setInt(++index, 0);
			stmt.setString(++index, name);
			stmt.setString(++index, username);
			stmt.setString(++index, password);
			stmt.setString(++index, address);
			stmt.setInt(++index, phone);
			stmt.setInt(++index, deposit);
			stmt.setString(++index, "no");
			if (!stmt.execute())
				MainAppPage.main(null);
			
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}	
	}
	
	public void withdraw(int d, String name, int userId) {
		
		int currentAmount = d;
		String username = name.toLowerCase();
		int id = userId;
		System.out.println("Enter the amount you want to withdraw from your account ");
		int w = log.nextInt();
		int afterWith = d-w;
		System.out.println("Your Account Balance is " + afterWith + "$");
		
		int index = 0;
		try(Connection conn = dbConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("Update userInfo SET depositAmount = "+ afterWith +"  where userId = " + id);
			//stmt.setInt(++index, afterWith);
			if (!stmt.execute());
				System.out.println("inserted");
				System.out.println("1 for Logout \n2 for Withdraw \n3 for Deposit");
				logout = log.nextInt();
				if(logout == 1) {
					MainAppPage.main(null);
				}else if(logout == 2) {
					user.withdraw(afterWith, username, id);
				}else {
					user.deposit(afterWith, name, id);
				}
				
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}	
	}
	
	private void deposit(int d, String name, int userId) {
		int currentAmount = d;
		String username = name.toLowerCase();
		int id = userId;
		System.out.println("Enter the amount you want to Deposit from your account ");
		int w = log.nextInt();
		int afterDeposit = d+w;
		System.out.println("Your Account Balance is " + afterDeposit + "$");
		
		int index = 0;
		try(Connection conn = dbConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("Update userInfo SET depositAmount = "+ afterDeposit +"  where userId = " + id);
			//stmt.setInt(++index, afterWith);
			if (!stmt.execute());
				//System.out.println("inserted");
				System.out.println("1 for Logout \n2 for Withdraw \n3 for Deposit");
				logout = log.nextInt();
				if(logout == 1) {
					MainAppPage.main(null);
				}else if(logout == 2) {
					user.withdraw(afterDeposit, username, id);
				}else {
					user.deposit(d,name, userId);
				}
				
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}	
		
	}

}
