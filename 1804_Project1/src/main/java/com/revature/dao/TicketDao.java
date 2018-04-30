package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Ticket;

public interface TicketDao {

	public Ticket createTicket(double amount, String reason, String email);
	public ArrayList<Ticket> getAllTickets();
	public ArrayList<Ticket> getAllTicketsPending();
	public ArrayList<Ticket> getAllTicketsReviewed();
	public ArrayList<Ticket> getAllTicketsFor(String user);
	public ArrayList<Ticket> getAllTicketsForPending(String user);
	public ArrayList<Ticket> getAllTicketsForReviewed(String user);
	public Ticket approveDeny(int id, String email, boolean approve);
}
