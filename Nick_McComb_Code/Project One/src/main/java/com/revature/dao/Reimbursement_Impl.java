package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Request;
import com.revature.models.User;
import com.revature.util.ProjectConnection;	


public class Reimbursement_Impl implements Reimbursement_Dao{

	final static Logger log = Logger.getLogger(Reimbursement_Impl.class);
	
	public boolean addUser(String fname, String lname, String email, String pw) {
		log.info("Employee account creation attempted, connecting to database");
		try(Connection conn = ProjectConnection.getConnection()){
			log.info("Connection Successful");
			CallableStatement stmt = conn.prepareCall("{CALL new_user(?, ?, ?, ?)}");
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, email);
			stmt.setString(4, pw);
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("Employee account created for " + fname + " " + lname + " at email " + email);
			} else {
				log.error("Failure creating new employee account");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("employee account creation error.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean addAdmin(String fname, String lname, String email, String pw) {
		log.info("Admin account creation attempted");
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL new_admin(?, ?, ?, ?)}");
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, email);
			stmt.setString(4, pw);
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("Admin Account created for " + fname + " " + lname + " at email " + email);
			} else {
				log.error("Failure creating new admin account");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("admin account creation error.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean addRequest(double amount, int id, String purpose) {
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL new_request(?, ?, ?)}");
			stmt.setDouble(1, amount);
			stmt.setInt(2, id);
			stmt.setString(3, purpose);
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("New reimbursement request successfully submitted");
			}
			else {
				log.error("Request submission failed");
			}
			return result>0;
		} catch (SQLException e) {
			log.error("Request submission error.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean changeUserName(int id, String fname, String lname) {
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL change_user_name(?, ?, ?)}");
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setInt(3, id);
			log.info("User name change attempted");
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("User" + id + " successfully changed their name." );
			} else {
				log.error("User name Change failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("User name change error.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean changeUserPassword(int id, String pw) {
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL change_user_pw(?, ?)}");
			stmt.setInt(2, id);
			stmt.setString(1, pw);
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

	public boolean changeAdminName(int id, String fname, String lname) {
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL change_admin_name(?, ?, ?)}");
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setInt(3, id);
			log.info("Admin name change attempted");
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("Admin" + id + " successfully changed their name." );
			} else {
				log.error("Admin Name Change failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("Admin name change error.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean changeAdminPassword(int id, String pw) {
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL change_admin_pw(?, ?)}");
			stmt.setInt(2, id);
			stmt.setString(1, pw);
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

	public List<User> getAllUsers() {
		return null;
	}

	public List<User> getAllAdmins() {

		return null;
	}

	public List<Request> getAllRequests() {
		try(Connection conn = ProjectConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request");
			List<Request> tor = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				tor.add(new Request(rs.getInt("id"), rs.getInt("requester"), rs.getInt("handler"), rs.getInt("img_id"),
							rs.getDouble("amount"), rs.getString("status"), rs.getString("purpose"), rs.getString("handler_comment")));
			}
			return tor;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<Request> getMyResolvedRequests(int id) {
		try(Connection conn = ProjectConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request WHERE requester=? "
							+ "AND NOT (status='Pending')");
			stmt.setInt(1, id);
			List<Request> tor = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				tor.add(new Request(rs.getInt("id"), rs.getInt("requester"), rs.getInt("handler"), rs.getInt("img_id"),
							rs.getDouble("amount"), rs.getString("status"), rs.getString("purpose"), rs.getString("handler_comment")));
			}
			return tor;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<Request> getMyPendingRequests(int id) {
		try(Connection conn = ProjectConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request WHERE requester=? "
							+ "AND status='Pending'");
			stmt.setInt(1, id);
			List<Request> tor = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				tor.add(new Request(rs.getInt("id"), rs.getInt("requester"), rs.getInt("handler"), rs.getInt("img_id"),
							rs.getDouble("amount"), rs.getString("status"), rs.getString("purpose"), rs.getString("handler_comment")));
			}
			return tor;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<Request> getPendingRequests() {
		try(Connection conn = ProjectConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request WHERE status='Pending'");
			List<Request> tor = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				tor.add(new Request(rs.getInt("id"), rs.getInt("requester"), rs.getInt("handler"), rs.getInt("img_id"),
							rs.getDouble("amount"), rs.getString("status"), rs.getString("purpose"), rs.getString("handler_comment")));
			}
			return tor;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<Request> getResolvedRequests() {
		try(Connection conn = ProjectConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request WHERE NOT (status='Pending')");
			List<Request> tor = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				tor.add(new Request(rs.getInt("id"), rs.getInt("requester"), rs.getInt("handler"), rs.getInt("img_id"),
							rs.getDouble("amount"), rs.getString("status"), rs.getString("purpose"), rs.getString("handler_comment")));
			}
			return tor;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<Request> getRequestsByUser(int id) {

		return null;
	}

	@Override
	public boolean resolve(String status, String comment, int adminId, int requestId) {
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL resolve(?, ?, ?, ?)}");
			stmt.setString(1, status);
			stmt.setString(2, comment);
			stmt.setInt(3, adminId);
			stmt.setInt(4, requestId);
			log.info("Request status change attempted");
			int result = stmt.executeUpdate();
			if(result > 0) {
				log.info("Admin" + adminId + " successfully resolved request #" + requestId );
			} else {
				log.warn("Request handling failed");
			}
			return result > 0;
		} catch (SQLException e) {
			log.error("Request handling error.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	@Override
	public User userLogin(String un, String pw) {
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("SELECT * FROM reimbursement_user WHERE email=? AND pw=?");
			stmt.setString(1, un);
			stmt.setString(2, pw);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			log.error("Error logging in user.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		log.error("Failed to log in user.");
		return null;
	}

	@Override
	public User adminLogin(String un, String pw) {
		try(Connection conn = ProjectConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("SELECT * FROM admin WHERE email=? AND pw=?");
			stmt.setString(1, un);
			stmt.setString(2, pw);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			log.error("Error logging in administrator.");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		log.error("Failed to log in administrator.");
		return null;
	}



}
