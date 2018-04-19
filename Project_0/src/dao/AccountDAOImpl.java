package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import accounts.AdminAccount;
import accounts.UserAccount;



public class AccountDAOImpl implements AccountDAO
{
	final static Logger logger = Logger.getLogger(AccountDAOImpl.class);
	
	private static AccountDAOImpl instance;
	private AccountDAOImpl() {}
	
	
	public static AccountDAOImpl getInstance()
	{
		if(instance == null)
		{
			instance = new AccountDAOImpl();
		}
		return(instance);
	}

	
	//Implementations for the UserAccount methods:
	@Override
	public boolean insertUserAccount(UserAccount acct)
	{
		logger.info("Now attempting to add " + acct.getHolder() + "'s user account to the database...");
		logger.info("Now attempting to add " + acct.getHolder() + "'s user account to the database...");
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO UserAccount (acctNumber, acctPassword, balance, name, approved) VALUES (?, ?, ?, ?, ?)");
			stmt.setLong(1, acct.getAcctNumber());
			stmt.setString(2, acct.getPassword());
			stmt.setDouble(3,acct.getBalance());
			stmt.setString(4, acct.getHolder());
			stmt.setInt(5, acct.getApproved());
			stmt.executeUpdate();
			
			System.out.println(acct.getHolder() + "'s user account was successfully added to the database.");
			logger.info(acct.getHolder() + "'s user account was successfully added to the database.");
			System.out.println("***Your account number is " + acct.getAcctNumber());
			return(true);
		}
		catch(SQLException sqle)
		{
			logger.info("An SQLException was caught.");
			logger.info(sqle.getMessage());
			logger.info("SQL State: " + sqle.getSQLState());
			logger.info("Error Code: " + sqle.getErrorCode());
		}
		
		System.out.println(acct.getHolder() + "'s user account was NOT successfully added to the database.");
		logger.info(acct.getHolder() + "'s user account was NOT successfully added to the database.");
		return(false);
	}

	@Override
	public UserAccount getUserAccount(long acctNumber)
	{
		logger.info("Now attempting to retrieve user account number " + acctNumber + "...");
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT name, acctPassword, acctNumber, balance, approved FROM UserAccount WHERE acctNumber = ?");
			stmt.setLong(1, acctNumber);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			UserAccount userAcct = new UserAccount(rs.getString("name"), rs.getString("acctPassword"), rs.getLong("acctNumber"), rs.getDouble("balance"), rs.getInt("approved"));
			System.out.println(userAcct.getHolder() + "'s user account was successfully retrieved.");
			logger.info(userAcct.getHolder() + "'s user account was successfully retrieved.");
			return(userAcct);
		}
		catch(SQLException sqle)
		{
			logger.info("An SQLException was caught.");
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		}
		
		logger.info("User account number " + acctNumber + " was NOT successfully retrieved.");
		return(null);
	}
	
	@Override
	public UserAccount getUserAccount(String name)
	{
		logger.info("Now attempting to retrieve " + name + "'s user account...");
		boolean isValid=false;
		String input;
		long longInput=0;
		Scanner in;
		PreparedStatement stmt;
		ResultSet rs;
		UserAccount userAcct;
		while(!isValid)
		{
			try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
			{
				isValid=true;
				stmt = conn.prepareStatement("SELECT name, acctPassword, acctNumber, balance, approved FROM UserAccount WHERE name = ?");
				stmt.setString(1, name);
				rs = stmt.executeQuery();
				
				rs.next();
				userAcct = new UserAccount(rs.getString("name"), rs.getString("acctPassword"), rs.getLong("acctNumber"), rs.getDouble("balance"), rs.getInt("approved"));
				
				in = new Scanner(System.in);
				if(userAcct.getHolder() == null)
				{
					isValid=false;
					logger.info("There are no user accounts associated with the provided name.  Please enter your account number or try entering your name again, if you mistyped it:");
				}
				else
				{
					try
					{
						//If everything goes perfectly, an SQLException will be thrown here because the statement returned a single, non-null UserAccount
						if(rs.next())
						{
							isValid=false;
							logger.info("There are multiple user accounts associated with the provided name.  Please enter your account number:");
						}
						else
						{
							logger.info(userAcct.getHolder() + "'s user account has been retrieved successfully.");
							return(userAcct);
						}
					}
					catch(SQLException sqle)
					{
						logger.info(userAcct.getHolder() + "'s user account has been retrieved successfully.");
						return(userAcct);
					}
				}
				
				input=in.nextLine();
				
				try
				{
					longInput=Long.parseLong(input);
					return(getUserAccount(longInput));
				}
				catch(Exception e)
				{
					return(getUserAccount(input));
				}
			}
			catch(SQLException sqle)
			{
				System.out.println("An SQLException was caught.");
				System.err.println(sqle.getMessage());
				System.err.println("SQL State: " + sqle.getSQLState());
				System.err.println("Error Code: " + sqle.getErrorCode());
			}
		}
		
		logger.info(name + "'s user account was NOT successfully retrieved.");
		return(null);
	}

	@Override
	public ArrayList<UserAccount> getAllUserAccounts()
	{
		logger.info("Now attempting to acquire all user accounts...");
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			ArrayList<UserAccount> userAccts = new ArrayList<UserAccount>();
			PreparedStatement stmt = conn.prepareStatement("SELECT name, acctPassword, acctNumber, balance, approved FROM UserAccount");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				userAccts.add(new UserAccount(rs.getString("name"), rs.getString("acctPassword"), rs.getLong("acctNumber"), rs.getDouble("balance"), rs.getInt("approved")));
			}
			
			logger.info("All user accounts were successfully acquired.");
			return(userAccts);
		}
		catch(SQLException sqle)
		{
			System.out.println("An SQLException was caught.");
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		logger.info("User accounts were NOT successfully acquired.");
		return(null);
	}

	@Override
	public boolean updateUserAccount(UserAccount acct)
	{
		logger.info("Now attempting to update " + acct.getHolder() + "'s user account...");
		int updated=-1;
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE UserAccount SET name = ?, acctPassword = ?, balance = ?, approved = ? WHERE acctNumber = ?");
			stmt.setString(1, acct.getHolder());
			stmt.setString(2, acct.getPassword());
			stmt.setDouble(3, acct.getBalance());
			stmt.setInt(4, acct.getApproved());
			stmt.setLong(5, acct.getAcctNumber());
			updated=stmt.executeUpdate();
			
			//executeUpdate() returns 0 for SQL statements that return nothing (the above SQL statement should return nothing)
			//if(updated == 0)
			//{
				System.out.println(acct.getHolder() + "'s user account was updated successfully.");
				return(true);
			//}
		}
		catch(SQLException sqle)
		{
			System.out.println("An SQLException was caught.");
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		logger.info(acct.getHolder() + "'s user account was updated successfully.");
		return(false);
	}

	@Override
	public boolean deleteUserAccount(UserAccount acct)
	{
		System.out.println("Now attempting to delete " + acct.getHolder() + "'s user account...");
		int updated=-1;
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM UserAccount WHERE acctNumber = ?");
			stmt.setLong(1, acct.getAcctNumber());
			updated=stmt.executeUpdate();
			
			if(updated == 0)
			{
				System.out.println(acct.getHolder() + "'s user account was deleted successfully.");
				return(true);
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("An SQLException was caught.");
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		System.out.println(acct.getHolder() + "'s user account was NOT successfully deleted.");
		return(false);
	}

	
	//Implementations for the AdminAccount methods:
	@Override
	public boolean insertAdminAccount(AdminAccount acct)
	{
		logger.info("Now attempting to add " + acct.getHolder() + "'s admin account to the database...");
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO AdminAccount (acctNumber, acctPassword, name, approved) VALUES (?, ?, ?, ?)");
			stmt.setLong(1, acct.getAcctNumber());
			stmt.setString(2, acct.getPassword());
			stmt.setString(3, acct.getHolder());
			stmt.setInt(4, 0);
			stmt.executeUpdate();
			
			logger.info(acct.getHolder() + "'s admin account was successfully added to the database.");
			return(true);
		}
		catch(SQLException sqle)
		{
			System.out.println("An SQLException was caught.");
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		logger.info(acct.getHolder() + "'s admin account was NOT successfully added to the database.");
		return(false);
	}

	@Override
	public AdminAccount getAdminAccount(long acctNumber)
	{
		logger.info("Now attempting to retrieve admin account number " + acctNumber + "...");
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT acctNumber, name, acctPassword, approved FROM AdminAccount WHERE acctNumber = ?");
			stmt.setLong(1, acctNumber);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			AdminAccount adminAcct = new AdminAccount(rs.getString("name"), rs.getString("acctPassword"), rs.getLong("acctNumber"), rs.getInt("approved"));
			logger.info(adminAcct.getHolder() + "'s admin account was successfully retrieved.");
			return(adminAcct);
		}
		catch(SQLException sqle)
		{
			System.out.println("An SQLException was caught.");
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		logger.info("Admin account number " + acctNumber + " was NOT successfully retrieved.");
		return(null);
	}
	
	@Override
	public AdminAccount getAdminAccount(String name)
	{
		logger.info("Now attempting to retrieve " + name + "'s admin account...");
		boolean isValid=false;
		String input;
		long longInput=0;
		Scanner in;
		PreparedStatement stmt;
		ResultSet rs;
		AdminAccount adminAcct;
		while(!isValid)
		{
			try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
			{
				isValid=true;
				stmt = conn.prepareStatement("SELECT name, acctPassword, acctNumber, approved FROM AdminAccount WHERE name = ?");
				stmt.setString(1, name);
				rs = stmt.executeQuery();
				
				rs.next();
				adminAcct = new AdminAccount(rs.getString("name"), rs.getString("acctPassword"), rs.getLong("acctNumber"), rs.getInt("approved"));
				
				in = new Scanner(System.in);
				if(adminAcct.getHolder() == null)
				{
					isValid=false;
					logger.info("There are no admin accounts associated with the provided name.  Please enter your account number or try entering your name again, if you mistyped it:");
				}
				else
				{
					try
					{
						//If everything goes perfectly, an SQLException will be thrown here because the statement returned a single, non-null UserAccount
						if(rs.next())
						{
							isValid=false;
							logger.info("There are multiple admin accounts associated with the provided name.  Please enter your account number:");
						}
						else
						{
							logger.info(adminAcct.getHolder() + "'s admin account has been retrieved successfully.");
							return(adminAcct);
						}
					}
					catch(SQLException sqle)
					{
						logger.info(adminAcct.getHolder() + "'s admin account has been retrieved successfully.");
						return(adminAcct);
					}
				}
				
				input=in.nextLine();
				
				try
				{
					longInput=Long.parseLong(input);
					return(getAdminAccount(longInput));
				}
				catch(Exception e)
				{
					return(getAdminAccount(input));
				}
			}
			catch(SQLException sqle)
			{
				System.out.println("An SQLException was caught.");
				System.err.println(sqle.getMessage());
				System.err.println("SQL State: " + sqle.getSQLState());
				System.err.println("Error Code: " + sqle.getErrorCode());
			}
		}
		
		logger.info(name + "'s admin account was NOT successfully retrieved.");
		return(null);
	}

	@Override
	public ArrayList<AdminAccount> getAllAdminAccounts()
	{
		logger.info("Now attempting to acquire all admin accounts...");
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			ArrayList<AdminAccount> adminAccts = new ArrayList<AdminAccount>();
			PreparedStatement stmt = conn.prepareStatement("SELECT name, acctPassword, acctNumber, approved FROM AdminAccount");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				adminAccts.add(new AdminAccount(rs.getString("name"), rs.getString("acctPassword"), rs.getLong("acctNumber"), rs.getInt("approved")));
			}
			
			logger.info("All admin accounts were successfully acquired.");
			return(adminAccts);
		}
		catch(SQLException sqle)
		{
			System.out.println("An SQLException was caught.");
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		logger.info("Admin accounts were NOT successfully acquired.");
		return(null);
	}

	@Override
	public boolean updateAdminAccount(AdminAccount acct)
	{
		logger.info("Now attempting to update " + acct.getHolder() + "'s admin account...");
		int updated=-1;
		try(Connection conn = ConnectionsWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE AdminAccount SET name = ?, acctPassword = ?, approved = ? WHERE acctNumber = ?");
			stmt.setString(1, acct.getHolder());
			stmt.setString(2,  acct.getPassword());
			stmt.setInt(3, acct.getApproved());
			stmt.setLong(4, acct.getAcctNumber());
			updated=stmt.executeUpdate();
			
			if(updated == 0)
			{
				logger.info(acct.getHolder() + "'s admin account was updated successfully.");
				return(true);
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("An SQLException was caught.");
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		logger.info(acct.getHolder() + "'s admin account was updated successfully.");
		return(false);
	}
}
