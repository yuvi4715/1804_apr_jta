package Bank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao
{
	private static AccountDaoImpl instance;
	
	public static AccountDaoImpl getInstance()
	{
		if(instance == null)
		{
			instance = new AccountDaoImpl();
		}
		return instance;
	}
	
	
	@Override
	public boolean insertAdmin(AdminAccount admin) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO adminacc (username, passwords) VALUES (?, ?)");
			stmt.setString(1, admin.getUser());
			stmt.setString(2, admin.getPass());

			if (!stmt.execute())//returns number of rows modified
				return stmt.getUpdateCount() > 0;
		}
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean insertUser(UserAccount user) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO useracc (username, passwords, name_of_owner, balance, authorize) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1 , user.getUser());
			stmt.setString(2 , user.getPass());
			stmt.setString(3 , user.getName());
			stmt.setDouble(4 , user.getBalance());
			stmt.setInt(5 , (user.getAuth()? 1:0));
			
			if (!stmt.execute())//returns number of rows modified
				return stmt.getUpdateCount() > 0;
		}
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public UserAccount getUser(String user) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT username, passwords, name_of_owner, balance, authorize FROM useracc WHERE username = ?");
			stmt.setString(1, user);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				return new UserAccount(rs.getString("name_of_owner"), rs.getString("username"), rs.getString("passwords"), rs.getDouble("balance"), rs.getBoolean("authorize") );
			}
		}
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}

	@Override
	public AdminAccount getAdmin(String admin) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT username, passwords FROM adminacc WHERE username = ? ");
			stmt.setString(1, admin);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				return new AdminAccount(rs.getString("username"), rs.getString("passwords"));
			}
		}
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}

	@Override
	public boolean updateUser(UserAccount user) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE useracc SET passwords = ?, balance = ?, authorize = ? WHERE username = ?");
			stmt.setString(1, user.getPass());
			stmt.setDouble(2, user.getBalance());
			stmt.setInt(3, (user.getAuth()? 1:0));
			stmt.setString(4, user.getUser());
			return stmt.executeUpdate()>0;
		}
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}
	
	public List<UserAccount> getAllUsers()
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			List<UserAccount> users = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM useracc");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				System.out.println("Name: " + rs.getString("name_of_owner") + " username: " +  rs.getString("username") + " Authorized: " + Boolean.toString(rs.getBoolean("authorize")));
			}
		}
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}
	
	public boolean deleteUser(String user)
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM useracc WHERE username = ?");
			stmt.setString(1, user);

			return stmt.executeUpdate() > 0;
		}
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return false;
	}
}
