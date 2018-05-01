package com.revature.DAO;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;


import com.revature.model.Request;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;




public class UserDAOImpl implements UserDAO{
	final static Logger log = Logger.getLogger(UserDAOImpl.class);
	private static UserDAOImpl instance;
	private UserDAOImpl() {}
	
	public static UserDAO getInstance() {
		if (instance ==null) {
			instance = new UserDAOImpl();
			log.warn("singleton instance loaded");
		}
		return instance;
	}

	@Override
	public boolean logOn(String username, String password) {
		log.info("log in attempted made, LogOn called");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT username FROM employee WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			return stmt.executeUpdate() > 0;
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
			log.warn("exception thrown and caught");
		}
		return false;
	}


	@Override
	public boolean checkUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT username FROM employee WHERE username = ?");
			stmt.setString(1, username);
			return stmt.executeUpdate() > 0;
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean submitRequest(String email, int amount, String purpose) {
		log.info("A user submited a request!");
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{ CALL insert_request(?,?,'','pending',?)}");
			stmt.setInt(1, amount);
			stmt.setString(2, email);
			stmt.setString(3, purpose);
			return stmt.executeUpdate() > 0;
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean updateUser(String email, String firstname, String lastname, String password) {
		log.warn("User has updated information. Password was changed!");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE employee SET firstname = ?, lastname = ?, password = ? WHERE email = ?");
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, password);
			stmt.setString(4, email);
			
			if (!stmt.execute()) {
				
				return stmt.getUpdateCount() > 0;
				
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());
			
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() { // manager only
		log.info("A manager has started the retrieval of all users");
		try (Connection conn =  ConnectionUtil.getConnection()) {
			List<User> user = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE position = ?");
			stmt.setString(1, "employee");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user.add(new User(rs.getString("email"),rs.getString("firstname"),
						rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("position")));
			}
			return user;
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Request> getAllRequests() { // manager only
		log.info("A manager has started the retrieval of all requests");
		try (Connection conn =  ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request");
			ResultSet rs = stmt.executeQuery();
			// Can use if statement instead of while loop if you only expect one record
			while (rs.next()) {
				requests.add(new Request(rs.getInt("requestamount"), rs.getString("requester"), 
						rs.getString("reviewedby"), rs.getString("status"), rs.getString("purpose")));
			}
			return requests;
		}catch (SQLException sqle) {
				System.err.println(sqle.getMessage());
				System.err.println("SQL State: " + sqle.getSQLState());
				System.err.println("Error code: " + sqle.getErrorCode());
				
		}
		return null;
	}

	@Override
	public List<Request> getPendingRequests(String email) {
		log.info("An employee has started the retrieval of all pending requests");
		try (Connection conn =  ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester = ? AND status = ?");
			stmt.setString(1, email);
			stmt.setString(2, "pending");
			ResultSet rs = stmt.executeQuery();
			// Can use if statement instead of while loop if you only expect one record
			while (rs.next()) {
				requests.add(new Request(rs.getInt("requestamount"), rs.getString("requester"), 
						rs.getString("reviewedby"), rs.getString("status"), rs.getString("purpose")));
			}
			return requests;
		}catch (SQLException sqle) {
				System.err.println(sqle.getMessage());
				System.err.println("SQL State: " + sqle.getSQLState());
				System.err.println("Error code: " + sqle.getErrorCode());
				
		}
		return null;
	}

	@Override
	public List<Request> getResolvedRequests(String email) {
		log.info("An employee has started the retrieval of all resolved requests");
		try (Connection conn =  ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester = ? AND status <> 'pending'");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			// Can use if statement instead of while loop if you only expect one record
			while (rs.next()) {
				requests.add(new Request(rs.getInt("requestamount"), rs.getString("requester"), 
						rs.getString("reviewedby"), rs.getString("status"), rs.getString("purpose")));
			}
			return requests;
		}catch (SQLException sqle) {
				System.err.println(sqle.getMessage());
				System.err.println("SQL State: " + sqle.getSQLState());
				System.err.println("Error code: " + sqle.getErrorCode());
				
		}
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequests() { //manager only
		log.info("A manager has started the retrieval of all users");
		try (Connection conn =  ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status = ? OR status = ?");
			stmt.setString(1, "approved");
			stmt.setString(2, "denied");
			
	
			ResultSet rs = stmt.executeQuery();
			// Can use if statement instead of while loop if you only expect one record
			while (rs.next()) {
				requests.add(new Request(rs.getInt("requestamount"), rs.getString("requester"), 
						rs.getString("reviewedby"), rs.getString("status"), rs.getString("purpose")));
			}
			return requests;
		}catch (SQLException sqle) {
				System.err.println(sqle.getMessage());
				System.err.println("SQL State: " + sqle.getSQLState());
				System.err.println("Error code: " + sqle.getErrorCode());
				
		}
		return null;
	}
	
	@Override
	public List<Request> getAllPendingRequests() {
		log.info("A manager has started the retrieval of all users");
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status = ?");
			stmt.setString(1, "pending");

			ResultSet rs = stmt.executeQuery();
			// Can use if statement instead of while loop if you only expect one record
			while (rs.next()) {
				requests.add(new Request(rs.getInt("requestamount"), rs.getString("requester"),
						rs.getString("reviewedby"), rs.getString("status"), rs.getString("purpose")));
			}
			return requests;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());

		}
		return null;
	}

	@Override
	public List<Request> getEmployeeRequests(String email) { // manager only
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			// Can use if statement instead of while loop if you only expect one record
			while (rs.next()) {
				requests.add(new Request(rs.getInt("requestamount"), rs.getString("requester"),
						rs.getString("reviewedby"), rs.getString("status"), rs.getString("purpose")));
			}
			return requests;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());

		}
		log.warn("get employees returned null. incorrect email was given.");
		return null;

	}

	@Override
	public User getUser(String username, String password) {
		log.info("user login event has occurred");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			// Can use if statement instead of while loop if you only expect one record
			if (rs.next()) {
				return new User(rs.getString("email"), rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("username"), rs.getString("password"), rs.getString("position"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());

		}
		return null;
	}

	@Override
	public boolean isManager(String email) {
		log.info("session validation for Manager has occured");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT username FROM employee WHERE email = ? AND position = 'manager'");
			stmt.setString(1, email);
			return stmt.executeUpdate() > 0;
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean respondToRequest(String email, int amount, String requester, String response) {
		log.info("An manager has requested to resolve a request.");
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE request SET reviewedBy = ?, status = ? WHERE requestAmount = ? AND requester = ?");
			stmt.setString(1, email);
			stmt.setString(2, response);
			stmt.setInt(3, amount);
			stmt.setString(4, requester);
		
			if (!stmt.execute()) {
				
				return stmt.getUpdateCount() > 0;
				
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());
			
		}
		return false;
	}


}
