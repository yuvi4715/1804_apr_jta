package com.revature.service;

import java.util.List;

import com.revature.dao.ERSDao;
import com.revature.dao.ERSDaoImp;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;

public class ERSService {
	private static ERSDao dao = new ERSDaoImp();

	// EMPLOYEE
	public static boolean findEmployee(String username, String password) {
		return dao.findEmployee(username, password);
	} // -An Employee can login

	public static Employee employeeInfo(String username) {
		return dao.employeeInfo(username);
	}// -An Employee can view their information

	public static boolean submitRequest(String empEmail, Double amount, String purpose) {
		return dao.submitRequest(empEmail, amount, purpose);
	}// -An Employee can submit a reimbursement request
		// change String to img type

	public boolean uploadImage(String img) {
		return dao.uploadImage(img);
	}// -An Employee can upload an image of his/her receipt as part of the
		// reimbursement request

	public static List<Request> viewPending(String email) {
		return dao.viewPending(email);
	}// -An Employee can view their pending reimbursement requests(dao)

	public static List<Request> viewResolved(String email) {
		return dao.viewResolved(email);
	}// -An Employee can view their resolved reimbursement requests

	public boolean insertEmployee(Employee emp) {
		return dao.insertEmployee(emp);
	}

	public static boolean updateEmployee(Employee emp) {
		return dao.updateEmployee(emp);
	}// -An Employee can update their information
		// MANAGER

	public static boolean findManager(String username, String password) {
		return dao.findManager(username, password);
	} // -A Manager can login

	public static Manager managerInfo(String username) {
		return dao.managerInfo(username);
	}

	public static boolean handleRequest(Request req, String approvalStatus, String mgrEmail) {
		return dao.handleRequest(req, approvalStatus, mgrEmail);
	}// -A Manager can approve/deny pending reimbursement requests

	public static List<Request> viewAllPending() {
		return dao.viewAllPending();
	}// -A Manager can view all pending requests from all employees
		// change String to img type

	public String viewReceiptImg(Request req) {
		return dao.viewReceiptImg(req);
	}// -A Manager can view images of the receipts from reimbursement requests

	public static List<Request> viewAllResolved() {
		return dao.viewAllResolved();
	}// -A Manager can view all resolved requests from all employees and see which
		// manager resolved it

	public static List<Employee> viewAllEmployees() {
		return dao.viewAllEmployees();
	}// -A Manager can view all Employees

	public static List<Request> viewRequestsFrom(String string) {
		return dao.viewRequestsFrom(string);
	}// -A Manager can view reimbursement requests from a single Employee

	public static Request getRequest(int reqID) {
		return dao.getRequest(reqID);

	}

}
