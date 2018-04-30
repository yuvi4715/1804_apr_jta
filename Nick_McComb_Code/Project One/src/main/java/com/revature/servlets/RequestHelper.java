package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.Reimbursement_Impl;
import com.revature.services.AdminService;
import com.revature.services.LoginService;
import com.revature.services.ReadingService;
import com.revature.services.SubmissionService;


public class RequestHelper {
	final static Logger log = Logger.getLogger(Reimbursement_Impl.class);

	public static Object process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("Starting request handling " + req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/ProjectOne/userLogin.do":
			log.info("User " + req.getParameter("empLog") + " is trying to log in.");
			LoginService.userLogin(req, resp);
			break;
		case "/ProjectOne/adminLogin.do":
			log.info("Administrator  " + req.getParameter("admLog") + " is trying to log in.");
			LoginService.adminLogin(req, resp);
			break;
		case "/ProjectOne/makeEmployee.do":
			log.info("RequestHelper Creating new employee with email " + req.getParameter("empEmail"));
			LoginService.new_emp(req.getParameter("empFN"), req.getParameter("empLN"),
					req.getParameter("empEmail"),req.getParameter("empPass") );
			break;
		case "/ProjectOne/makeAdmin.do":
			LoginService.new_admin(req.getParameter("fname"), req.getParameter("lname"),
					req.getParameter("email"),req.getParameter("pw") );
			break;
		case "/ProjectOne/allRequests.do":
			AdminService.getAllRequests(req, resp);
			break;
		case "/ProjectOne/allPendingRequests.do":
			AdminService.getPendingRequests(req, resp);
			break;
		case "/ProjectOne/allResolvedRequests.do":
			AdminService.getResolvedRequests(req, resp);
			break;
		case "/ProjectOne/makeRequest.do":
			log.info("User attempted to create a reimbursement ticket.");
			SubmissionService.submitRequest(req, resp);
			break;
		case "/ProjectOne/resolveRequest.do":
			AdminService.resolve(req, resp);
			break;
		case "/ProjectOne/pendingRequests.do":
			log.info("Getting Pending requests");
			return ReadingService.getPendingRequests(req, resp);
		case "/ProjectOne/resolvedRequests.do":
			log.info("Getting Resolved requests");
			return ReadingService.getResolvedRequests(req, resp);
		case "/ProjectOne/logout.do":
			LoginService.logout(req, resp);
		default: 
		}
		return "Hello";
	}
}
