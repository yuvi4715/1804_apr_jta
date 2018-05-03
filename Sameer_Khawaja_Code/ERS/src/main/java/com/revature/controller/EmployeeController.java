package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.ERSService;

public class EmployeeController {

	public static String updateInfo(HttpServletRequest request) {
		
				String fn  = request.getParameter("firstname");
				String ln = request.getParameter("lastname");
				String em = request.getParameter("email");
				String un = request.getParameter("username");
				String pw = request.getParameter("password");
				Employee emp = new Employee(0, fn, ln, em, un, pw);
				System.out.println(emp);
				ERSService.updateEmployee(emp);
				return "update reimbursement successful";
	}

	public static String logout(HttpServletRequest req) {
		System.out.println("logging out");
		req.setAttribute("logout", true);
		return "logout";
	}

	public static String submit(HttpServletRequest req) {
		// parse from req.getparameter
		// call handle request

		// get Purpose
		String purp = req.getParameter("purp");
		// get amount
		Double amount = Double.parseDouble(req.getParameter("amount"));
		// get Employee
		String empEmail = req.getParameter("employeeEmail");
		System.out.println(empEmail);
		// parameters come from manager js
		
		
		ERSService.submitRequest(empEmail, amount, purp);
		return "update reimbursement successful";
	}

	public static String viewPending(HttpServletRequest req) {
		String empEmail = req.getParameter("email");
		System.out.println(empEmail);
		List<Request> rl = ERSService.viewPending(empEmail);
		String r = "";
		for (Request i : rl) {
			r = r + i + "\n";
		}

		return r;
	}

	public static String viewResolved(HttpServletRequest req) {
		String empEmail = req.getParameter("email");
		List<Request> rl = ERSService.viewResolved(empEmail);
		String r = "";
		for (Request i : rl) {
			r = r + i + "\n";
		}

		return r;
	}

	public static String viewEmpInfo(HttpServletRequest req) {
		String username = req.getParameter("employeeUsername");
		System.out.println(username);
		Employee emp = ERSService.employeeInfo(username);
		

		return emp.toString();
	}
	
	

}
