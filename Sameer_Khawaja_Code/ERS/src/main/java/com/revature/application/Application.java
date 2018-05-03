package com.revature.application;

import java.util.Scanner;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.model.User;
import com.revature.service.ERSService;

public class Application {

	// TODO
	// add proper dates to requests
	// create state machine
	// need to know request id before handling requests
	//need to know employee email to see their requests
	// NOTE: APPROVED PENDING DENIED ARE THE KEYWORDS

	public static void main(String[] args) {
		//User user = login();
		//System.out.println(user.toString());
		
		
//		//1
//		System.out.println(ERSService.findManager("q", "q"));
//		//2
//		Manager m = new Manager();
//		m =ERSService.managerInfo(m, "q", "q");
//		System.out.println(m.toString());
//		
		
		
		//3
		//int reqID = 53;
		//Request rq = ERSService.getRequest(reqID);
		//System.out.println(ERSService.handleRequest(rq, "APPROVED", m));
		
		//4
//		System.out.println(ERSService.viewRequestsFrom("l@t"));
		
		
		
		
		
		
		//3
//		Request req = new Request(0, 10000, e.getEmail(), null, "DENIED", "img", "purpose", "4/1/17", null);
//		System.out.println(req.toString());
//		System.out.println(ERSService.submitRequest(req));
		
		//4
		
		//5
		//System.out.println(ERSService.viewPending(e));
		
		//6
		//System.out.println(ERSService.viewResolved(e));
		
		
//		Manager mgr = new Manager();
		
//		mgr =ERSService.managerInfo(mgr, "q", "q");
		

//		
//		
//		
//		System.out.println(ERSService.handleRequest(req, "APPROVED", mgr));
	}

//	private static User login() {
//		User user = null;
//		@SuppressWarnings("resource")
//		Scanner reader = new Scanner(System.in);
//		System.out.print("Enter your username: ");
//		String username = reader.next();
//		System.out.print("Enter your password: ");
//		String password = reader.next();
//
//		User mgr = new Manager();
//		User emp = new Employee();
//		if (ERSService.findEmployee(username, password)) {
//			emp = ERSService.employeeInfo((Employee) emp, username, password);
//			System.out.println(emp.toString());
//			return emp;
//		} else if (ERSService.findManager(username, password)) {
//			mgr = ERSService.managerInfo((Manager) mgr, username, password);
//			System.out.println(mgr.toString());
//			return mgr;
//		} else {
//			System.out.println("Invalid Username/Password");
//		}
//
//		return user;
//	}

}

// Methods
//
// Who is this id
// information about a request based on id
// what requests did i make
// what requests did i approve
//
//

// Expense Reimbursement System (ERS) - Presentation on first day of - Week 5
// -An Employee can login (dao)
// -An Employee can view the Employee Homepage
// -An Employee can logout
// -An Employee can submit a reimbursement request (dao)
// -An Employee can upload an image of his/her receipt as part of the
// reimbursement request (hard / do last)(dao)
// -An Employee can view their pending reimbursement requests(dao)
// -An Employee can view their resolved reimbursement requests(dao)
// -An Employee can view their information (dao)
// -An Employee can update their information (dao)
// -An Employee receives an email when one of their reimbursement requests is
// resolved (optional)
// -A Manager can login(dao)
// -A Manager can view the Manager Homepage
// -A Manager can logout
// -A Manager can approve/deny pending reimbursement requests(dao)
// -A Manager can view all pending requests from all employees (dao)
// -A Manager can view images of the receipts from reimbursement requests (hard
// /do last) (dao)
// -A Manager can view all resolved requests from all employees and see which
// manager resolved it(dao)
// -A Manager can view all Employees(dao)
// -A Manager can view reimbursement requests from a single Employee(dao)
// ------------------------------------------------------------------
// -A Manager can register an Employee, which sends the Employee an email with
// their username and temp password (optional)
// -An Employee can reset their password (Optional - tied with above functional
// requirement)
// Technologies:
// -Java 1.8
// -JSPs (optional), JSTL(optional)
// -Servlets
// -JDBC
// -SQL
// -PL/SQL
// -HTML/CSS/Javascript
// -Bootstrap
// -AJAX (required in atleast 2 functionalities)
// -JUnit
// -log4j
// Environment:
// -Tomcat
// -Oracle 11g Database (AWS RDS)
// -Eclipse/Spring Tools Suite
// -SQL Developer