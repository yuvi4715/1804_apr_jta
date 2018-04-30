package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Ticket;
import com.revature.util.ConnectionUtil;

public class TicketDaoImpl implements TicketDao {

	private static TicketDaoImpl instance;
	
	private TicketDaoImpl() {
		
	}
	
	public static TicketDaoImpl getInstance() {
		
		if (instance == null) {
			instance = new TicketDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public Ticket createTicket(double amount, String reason, String email) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO ticket (id, amount, status, request_date, purpose," + 
					" emp_email) VALUES (null, " + amount + ", 'pending', sysdate, '" + reason + "', '" + email + "')");
			
			
			stmt.execute();
			
			stmt = conn.prepareStatement("SELECT * FROM ticket WHERE emp_email = ? AND amount = ? AND purpose = ?");
			stmt.setString(1, email);
			stmt.setDouble(2, amount);
			stmt.setString(3, reason);
			
			ResultSet rs = stmt.executeQuery();
			
			Ticket ticket;
			
			if(rs.next()) {
				
				int id = rs.getInt("id");
				double amountRet = rs.getDouble("amount");
				String status = rs.getString("status");
				String reqDate = rs.getDate("request_date").toString();
				String reasonRet = rs.getString("purpose");
				String empEmail = rs.getString("emp_email");
				
				ticket = new Ticket(id, amountRet, reasonRet, reqDate, "N/A", status, empEmail, "N/A");
				
			}else {
				
				ticket = new Ticket("Failed to create ticket");
			}
			
			return ticket;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
				
		return new Ticket("Failed to create ticket");
	}
	
	public Ticket approveDeny(int id, String email, boolean approve) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt;
			if (approve) {
				stmt = conn.prepareStatement("UPDATE ticket SET status = 'approved', manager_email = '" 
						+ email + "', review_date = sysdate WHERE id = ?");
			} else {
				stmt = conn.prepareStatement("UPDATE ticket SET status = 'denied', manager_email = '" 
						+ email + "', review_date = sysdate WHERE id = ?");
			}
			stmt.setInt(1, id);
			
			stmt.execute();
			
			stmt = conn.prepareStatement("SELECT * FROM ticket WHERE id = ?");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Ticket ticket;
			
			if(rs.next()) {
				
				double amountRet = rs.getDouble("amount");
				String status = rs.getString("status");
				String reqDate = rs.getDate("request_date").toString();
				String reasonRet = rs.getString("purpose");
				String empEmail = rs.getString("emp_email");
				
				String revDate;
				String managerEmail;
				
				if (rs.getDate("review_date") == null) {
					revDate = "N/A";
				} else {
					revDate = rs.getDate("review_date").toString();
				}
				
				if (rs.getString("manager_email") == null) {
					managerEmail = "N/A";
				} else {
					managerEmail = rs.getString("manager_email");
				}
				
				ticket = new Ticket(id, amountRet, reasonRet, reqDate, revDate, status, empEmail, managerEmail);
				
			}else {
				
				ticket = new Ticket("Failed to update ticket");
			}
			
			return ticket;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
				
		return new Ticket("Failed to update ticket");
	}
	
	public ArrayList<Ticket> getAllTickets() {
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ticket");
			
			
			ResultSet rs = stmt.executeQuery();
			
			Ticket ticket;
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				double amountRet = rs.getDouble("amount");
				String status = rs.getString("status");
				String reqDate = rs.getDate("request_date").toString();
				String reasonRet = rs.getString("purpose");
				String empEmail = rs.getString("emp_email");
				
				String revDate;
				String managerEmail;
				
				if (rs.getDate("review_date") == null) {
					revDate = "N/A";
				} else {
					revDate = rs.getDate("review_date").toString();
				}
				
				if (rs.getString("manager_email") == null) {
					managerEmail = "N/A";
				} else {
					managerEmail = rs.getString("manager_email");
				}
				
				ticket = new Ticket(id, amountRet, reasonRet, reqDate, revDate, status, empEmail, managerEmail);
				
				tickets.add(ticket);
			}
			
			return tickets;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return tickets;
	}
	
	public ArrayList<Ticket> getAllTicketsPending() {
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ticket WHERE status = 'pending'");
			
			
			ResultSet rs = stmt.executeQuery();
			
			Ticket ticket;
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				double amountRet = rs.getDouble("amount");
				String status = rs.getString("status");
				String reqDate = rs.getDate("request_date").toString();
				String reasonRet = rs.getString("purpose");
				String empEmail = rs.getString("emp_email");
				
				String revDate;
				String managerEmail;
				
				if (rs.getDate("review_date") == null) {
					revDate = "N/A";
				} else {
					revDate = rs.getDate("review_date").toString();
				}
				
				if (rs.getString("manager_email") == null) {
					managerEmail = "N/A";
				} else {
					managerEmail = rs.getString("manager_email");
				}
				
				ticket = new Ticket(id, amountRet, reasonRet, reqDate, revDate, status, empEmail, managerEmail);
				
				tickets.add(ticket);
			}
			
			return tickets;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return tickets;
	}

	public ArrayList<Ticket> getAllTicketsReviewed() {
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ticket WHERE status != 'pending'");
			
			
			ResultSet rs = stmt.executeQuery();
			
			Ticket ticket;
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				double amountRet = rs.getDouble("amount");
				String status = rs.getString("status");
				String reqDate = rs.getDate("request_date").toString();
				String reasonRet = rs.getString("purpose");
				String empEmail = rs.getString("emp_email");
				
				String revDate;
				String managerEmail;
				
				if (rs.getDate("review_date") == null) {
					revDate = "N/A";
				} else {
					revDate = rs.getDate("review_date").toString();
				}
				
				if (rs.getString("manager_email") == null) {
					managerEmail = "N/A";
				} else {
					managerEmail = rs.getString("manager_email");
				}
				
				ticket = new Ticket(id, amountRet, reasonRet, reqDate, revDate, status, empEmail, managerEmail);
				
				tickets.add(ticket);
			}
			
			return tickets;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return tickets;
	}
	
	public ArrayList<Ticket> getAllTicketsFor(String user) {
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ticket WHERE emp_email = ?");
			stmt.setString(1, user);
			
			ResultSet rs = stmt.executeQuery();
			
			Ticket ticket;
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				double amountRet = rs.getDouble("amount");
				String status = rs.getString("status");
				String reqDate = rs.getDate("request_date").toString();
				String reasonRet = rs.getString("purpose");
				String empEmail = rs.getString("emp_email");
				
				String revDate;
				String managerEmail;
				
				if (rs.getDate("review_date") == null) {
					revDate = "N/A";
				} else {
					revDate = rs.getDate("review_date").toString();
				}
				
				if (rs.getString("manager_email") == null) {
					managerEmail = "N/A";
				} else {
					managerEmail = rs.getString("manager_email");
				}
				
				ticket = new Ticket(id, amountRet, reasonRet, reqDate, revDate, status, empEmail, managerEmail);
				
				tickets.add(ticket);
			}
			
			return tickets;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return tickets;
	}
	
	public ArrayList<Ticket> getAllTicketsForPending(String user) {
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ticket WHERE emp_email = ? AND status = 'pending'");
			stmt.setString(1, user);
			
			ResultSet rs = stmt.executeQuery();
			
			Ticket ticket;
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				double amountRet = rs.getDouble("amount");
				String status = rs.getString("status");
				String reqDate = rs.getDate("request_date").toString();
				String reasonRet = rs.getString("purpose");
				String empEmail = rs.getString("emp_email");
				
				String revDate;
				String managerEmail;
				
				if (rs.getDate("review_date") == null) {
					revDate = "N/A";
				} else {
					revDate = rs.getDate("review_date").toString();
				}
				
				if (rs.getString("manager_email") == null) {
					managerEmail = "N/A";
				} else {
					managerEmail = rs.getString("manager_email");
				}
				
				ticket = new Ticket(id, amountRet, reasonRet, reqDate, revDate, status, empEmail, managerEmail);
				
				tickets.add(ticket);
			}
			
			return tickets;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return tickets;
	}

	public ArrayList<Ticket> getAllTicketsForReviewed(String user) {
		
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ticket WHERE emp_email = ? AND status != 'pending'");
			stmt.setString(1, user);
			
			ResultSet rs = stmt.executeQuery();
			
			Ticket ticket;
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				double amountRet = rs.getDouble("amount");
				String status = rs.getString("status");
				String reqDate = rs.getDate("request_date").toString();
				String reasonRet = rs.getString("purpose");
				String empEmail = rs.getString("emp_email");
				
				String revDate;
				String managerEmail;
				
				if (rs.getDate("review_date") == null) {
					revDate = "N/A";
				} else {
					revDate = rs.getDate("review_date").toString();
				}
				
				if (rs.getString("manager_email") == null) {
					managerEmail = "N/A";
				} else {
					managerEmail = rs.getString("manager_email");
				}
				
				ticket = new Ticket(id, amountRet, reasonRet, reqDate, revDate, status, empEmail, managerEmail);
				
				tickets.add(ticket);
			}
			
			return tickets;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return tickets;
	}
}
