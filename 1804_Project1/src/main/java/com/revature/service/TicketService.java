package com.revature.service;

import java.util.ArrayList;

import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.model.Ticket;

public class TicketService {

private static TicketDao dao = TicketDaoImpl.getInstance();
	
	public static Ticket createTicket(double amount, String reason, String email) {
		return dao.createTicket(amount, reason, email);
	}
	
	public static Ticket approveDeny(int id, String email, boolean approve) {
		return dao.approveDeny(id, email, approve);
	}
	
	public static ArrayList<Ticket> getAllTickets() {
		return dao.getAllTickets();
	}
	
	public static ArrayList<Ticket> getAllTicketsPending() {
		return dao.getAllTicketsPending();
	}
	
	public static ArrayList<Ticket> getAllTicketsReviewed() {
		return dao.getAllTicketsReviewed();
	}
	
	public static ArrayList<Ticket> getAllTicketsFor(String user) {
		return dao.getAllTicketsFor(user);
	}
	
	public static ArrayList<Ticket> getAllTicketsForPending(String user) {
		return dao.getAllTicketsForPending(user);
	}
	
	public static ArrayList<Ticket> getAllTicketsForReviewed(String user) {
		return dao.getAllTicketsForReviewed(user);
	}
}
