package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionWithProperties;

public class UsersAccountsDaoImpl implements AccountsDao, UsersDao{
	private static UsersAccountsDaoImpl instance;
	private UsersAccountsDaoImpl() {}
	public static UsersAccountsDaoImpl getInstance() {
		if(instance ==null) {
			instance = new UsersAccountsDaoImpl();
		}
		return instance;
	}
	public boolean insertUsersBean(UsersBean user) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(userid,password,type,approve) VALUES(?,?,?,?)");
			stmt.setInt(1, user.getUsersBeanId());
			stmt.setString(2,user.getpassword());
			stmt.setString(3,user.gettype());
			stmt.setString(4, user.getapprove());
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public UsersBean getUsersBean(int id) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT password, type, approve FROM users WHERE userid = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				UsersBean temp= new UsersBean(rs.getString(1),rs.getString(2),rs.getString(3));
				temp.setUsersBeanId(id);
				return temp;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<UsersBean> getAllUsersBean() {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<UsersBean> users = new ArrayList<>();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT userid, password, type, approve FROM users");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				UsersBean temp = new UsersBean(rs.getString(2),rs.getString(3),rs.getString(4));
				temp.setUsersBeanId(rs.getInt(1));
				users.add(temp);
			}
			return users;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}
	
	public List<Integer> getUnapprovedUsers(){
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<Integer> users = new ArrayList<>();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT userid FROM users WHERE approve = 'False'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				users.add(rs.getInt(1));
			}
			return users;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public boolean updateUsersBean(UsersBean user) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("UPDATE users Set password=?, type=?, approve=? WHERE userid = ?");
			stmt.setString(1,user.getpassword());
			stmt.setString(2,user.gettype());
			stmt.setString(3, user.getapprove());
			stmt.setInt(4, user.getUsersBeanId());
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean deleteUsersBean(int u) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<Integer> acc = getUserAccounts(u);
			for(int i:acc) {
				deleteAccountsBean(i);
			}
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM users where userid = ?");
			stmt.setInt(1, u);
			return stmt.executeUpdate()>0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	public List<Integer> getUserAccounts(int UserId) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<Integer> accounts= new ArrayList<Integer>();
			PreparedStatement stmt = conn.prepareStatement("SELECT accountid FROM useraccounts WHERE userid = ?");
			stmt.setInt(1, UserId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				accounts.add(rs.getInt(1));
			}
			return accounts;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}
	
	public boolean createUserAccountRelationship(int UserId, int AccountId) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO useraccounts (userid,accountid) VALUES(?,?)");
			stmt.setInt(1, UserId);
			stmt.setInt(2, AccountId);
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean insertAccountsBean(AccountBean AccountsBean) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO accounts(accountid,status,balance,limit,type) VALUES(?,?,?,?,?)");
			stmt.setInt(1, AccountsBean.getAccountBeanId());
			stmt.setString(2, AccountsBean.getStatus());
			stmt.setInt(3, AccountsBean.getBalance());
			stmt.setInt(4, AccountsBean.getLimit());
			stmt.setString(5, AccountsBean.getType());
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public AccountBean getAccountsBean(int id) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT status, balance, limit, type FROM accounts WHERE accountid = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				AccountBean temp = new AccountBean(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
				temp.setAccountBeanId(id);
				return temp;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<AccountBean> getAllAccountsBeans() {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<AccountBean> accounts= new ArrayList<>();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT accountid, status, balance, limit, type FROM accounts");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				AccountBean temp = new AccountBean(rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				temp.setAccountBeanId(rs.getInt(1));
				accounts.add(temp);
			}
			return accounts;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public boolean updateAccountsBean(AccountBean AccountsBean) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("UPDATE accounts Set status=?, balance=?, limit=?, type =? WHERE accountid = ?");
			stmt.setString(1, AccountsBean.getStatus());
			stmt.setInt(2, AccountsBean.getBalance());
			stmt.setInt(3, AccountsBean.getLimit());
			stmt.setString(4, AccountsBean.getType());
			stmt.setInt(5,AccountsBean.getAccountBeanId());
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean deleteAccountsBean(int a) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM useraccounts WHERE accountid =?");
			PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM accounts where accountid = ?");
			stmt1.setInt(1, a);
			stmt2.setInt(1, a);
			stmt1.executeUpdate();
			return stmt2.executeUpdate()>0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public int getMaxUsersBeanId() {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT MAX(userid) FROM users");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return 0;
	}

	public int getMaxAccountsBeanId() {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT MAX(accountid) FROM accounts");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return 0;
	}

}
