package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.EmployeeService;
import com.revature.service.TicketService;

public class RequestHelper {

public static Object process(HttpServletRequest req) {
				
		switch (req.getRequestURI()) {
			case "/1804_Project1/login.do": 
					return EmployeeService.login(req.getParameter("email"), req.getParameter("pass"));
			case "/1804_Project1/managerLogin.do": 
				return EmployeeService.managerLogin(req.getParameter("email"), req.getParameter("pass"));
			case "/1804_Project1/createTicket.do":
					return TicketService.createTicket(Double.parseDouble(req.getParameter("amount")), 
						req.getParameter("reason"), req.getParameter("email"));
			case "/1804_Project1/approveDeny.do":
				System.out.println(Boolean.parseBoolean(req.getParameter("approve")));
				return TicketService.approveDeny(Integer.parseInt(req.getParameter("id")), 
					req.getParameter("email"), Boolean.parseBoolean(req.getParameter("approve")));
			case "/1804_Project1/getAllTickets.do":
					return TicketService.getAllTickets();
			case "/1804_Project1/getAllTicketsPending.do":
				return TicketService.getAllTicketsPending();
			case "/1804_Project1/getAllTicketsReviewed.do":
				return TicketService.getAllTicketsReviewed();
			case "/1804_Project1/getAllTicketsFor.do":
				return TicketService.getAllTicketsFor(req.getParameter("email"));
			case "/1804_Project1/getAllTicketsForPending.do":
				return TicketService.getAllTicketsForPending(req.getParameter("email"));
			case "/1804_Project1/getAllTicketsForReviewed.do":
				return TicketService.getAllTicketsForReviewed(req.getParameter("email"));
			default:
				return null;
		}
	}
}
