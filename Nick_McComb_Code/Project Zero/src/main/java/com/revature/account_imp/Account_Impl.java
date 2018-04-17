package com.revature.account_imp;

import java.sql.*;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.util.MyConnection;


public class Account_Impl implements Account {

	final static Logger log = Logger.getLogger(Account_Impl.class);
	
	@Override
	public boolean checkName(String check) {
		try(Connection conn = MyConnection.getConnection()){
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}
	
	@Override
	public double checkBalance(int id) {
		try(Connection conn = MyConnection.getConnection()){
		
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return 0;
	}

	@Override
	public synchronized boolean deposit(int id, double amount) {
		log.info("Deposit attempted by user " + id);
		if(amount < 0) {
			System.out.println("Error - do not attempt to deposit negative amounts of money.");
			log.warn("User attempted to deposit negative sum.");
			return false;
		}
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL deposit(?, ?)}");
			stmt.setInt(1, id);
			stmt.setDouble(2, amount);
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("User " + id + " successfully deposited $" + amount);
			} else {
				log.error("Deposit failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("Deposit error");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}

	@Override
	public synchronized boolean withdrawal(int id, double amount) {
		log.info("Withdrawal attempted by user " + id);
		if(amount < 0) {
			System.out.println("Error: do not attempt to withdraw a negative sum.");
			log.warn("User attempted to withdraw a negative sum.");
			return false;
		}
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL withdrawal(?, ?)}");
			stmt.setInt(1, id);
			stmt.setDouble(2, amount);
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("User " + id + " withdrew $" + amount);
			} else {
				log.error("Withdrawal failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("Withdrawal error");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}

	@Override
	public synchronized boolean transfer(int id1, int id2, double amount) {
		if(amount < 0) {
			System.out.println("Error: do not attempt to transfer a negative sum.");
			log.warn("User attempted to transfer a negative sum.");
			return false;
		}
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL transfer(?, ?, ?)}");
			stmt.setInt(1, id1);
			stmt.setInt(2, id2);
			stmt.setDouble(3, amount);
			int result = stmt.executeUpdate();
			if(result>0) {
				log.info("user " + id1 + " successfully transferred $" + amount + " to user " + id2);
			} else {
				log.error("Transfer failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("Transfer error");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}

	@Override
	public boolean passwordChange(int id, String new_pw) {
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL change_password(?, ?)}");
			stmt.setInt(1, id);
			stmt.setString(2, new_pw);
			log.info("Password change attempted");
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("User" + id + " successfully changed their password." );
			} else {
				log.error("Password Change failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("Password change error.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}

	@Override
	public boolean firstNameChange(int id, String new_f_name) {
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL change_first_name(?, ?)}");
			stmt.setInt(1, id);
			stmt.setString(2, new_f_name);
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("User" + id + " successfully changed their first name." );
			} else {
				log.error("First name Change failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("First name change failure");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}

	@Override
	public boolean lastNameChange(int id, String new_l_name) {
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL change_last_name(?, ?)}");
			stmt.setInt(1, id);
			stmt.setString(2, new_l_name);
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("User" + id + " successfully changed their last name." );
			} else {
				log.error("Last name Change failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("Something went wrong changing their last name");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}

	@Override
	public boolean usernameChange(int id, String new_un) {
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL change_username(?, ?)}");
			stmt.setInt(1, id);
			stmt.setString(2, new_un);
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("User" + id + " successfully changed their username." );
			} else {
				log.error("username Change failed");
			}
			return result > 0;
		} catch (SQLException e) {			
			log.error("Something went wrong changing their username");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}

	@Override
	public User getUserInfo(String username) {
		try(Connection conn = MyConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE username=?");
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getInt("id"), rs.getInt("balance"), rs.getString("firstname"), rs.getString("lastname"),
								rs.getString("username"), rs.getString("password"),rs.getInt("verified"), rs.getInt("admin"));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return null;
	}

	@Override
	public boolean closeAccount(int id) {
		log.info("Closing account " + id);
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL close_account(?)}");
			stmt.setInt(1, id);
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("Account closed successful.");
			} else {
				log.error("Account closing failed.");
			}
			return result>0;
		} catch (SQLException e) {
			log.error("Error closing account.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}		
		return false;
	}

	@Override
	public boolean openAccount(int balance, String firstname, String lastname, String username, String password,
			int verified, int admin) {
		log.info("Opening new account.");
		int index = 0;
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL new_user(?, ?, ?, ?, ?, ?, ?)}");
			stmt.setString(++index, firstname);
			stmt.setString(++index, lastname);
			stmt.setString(++index, username);
			stmt.setString(++index, password);
			stmt.setInt(++index, verified);
			stmt.setInt(++index, balance);
			stmt.setInt(++index, admin);

			return stmt.executeUpdate() > 0;
		} catch(SQLException e) {
			log.error("Error creating new account.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	public boolean verify(int id) {
		log.info("Verifying user " + id);
		try(Connection conn = MyConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL verify(?)}");
			stmt.setInt(1, id);
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("Verification successful.");
			} else {
				log.error("User verification failed.");
			}
			return result>0;
		} catch (SQLException e) {
			log.error("Error verifying user.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
}
