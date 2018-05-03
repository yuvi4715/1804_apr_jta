package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.ERSService;



public class ManagerController {
	public static String updateRequest(HttpServletRequest request) {
		// parse from req.getparameter
		// call handle request

		// get ID
		int reqID = Integer.parseInt(request.getParameter("reqID"));
		Request req = ERSService.getRequest(reqID);
		// get status
		String status = request.getParameter("status");
		// get Manager
		String mgrEmail = request.getParameter("managerEmail");
		System.out.println(mgrEmail);
		// parameters come from manager js
		ERSService.handleRequest(req, status, mgrEmail);
		return "update reimbursement successful";

	}
	
	
	
	
	

	public static String showPending(HttpServletRequest request) {
		List<Request> rl = ERSService.viewAllPending();
		String r = "";
		for (Request i : rl) {
			r = r + i + "\n";
		}
		System.out.println(r);
		return r;

	}
	
	public static String showResolved(HttpServletRequest request) {
		List<Request> rl = ERSService.viewAllResolved();
		String r = "";
		for (Request i : rl) {
			r = r + i + "\n";
		}

		return r;

	}
	
	public static String showEmployees(HttpServletRequest request) {
		List<Employee> el = ERSService.viewAllEmployees();
		String e = "";
		for (Employee i : el) {
			e = e + i + "\n";
		}

		return e;
	}






	public static String showOneEmployees(HttpServletRequest request) {
		String employee = request.getParameter("employeeEmail");
		List<Request> rl = ERSService.viewRequestsFrom(employee);
		String r = "";
		for (Request i : rl) {
			r = r + i + "\n";
		}

		return r;
	}
	
	
	
	
}
