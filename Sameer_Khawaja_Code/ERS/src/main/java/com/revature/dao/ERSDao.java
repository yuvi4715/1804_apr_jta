package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;

public interface ERSDao {
	// EMPLOYEE
	public boolean findEmployee(String username, String password); //-An Employee can login
	public Employee employeeInfo(String username);// -An Employee can view their information
	public boolean submitRequest(String empEmail, Double amount, String purpose);//-An Employee can submit a reimbursement request
	//change String to img type
	public boolean uploadImage(String img);//-An Employee can upload an image of his/her receipt as part of the reimbursement request
	public List<Request> viewPending(String email);//-An Employee can view their pending reimbursement requests(dao)
	public List<Request> viewResolved(String email);//-An Employee can view their resolved reimbursement requests
	public boolean insertEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);//-An Employee can update their information
	// MANAGER
	public boolean findManager(String username, String password); //-A Manager can login
	public Manager managerInfo(String username);
	public Request getRequest(int reqID);
	public boolean handleRequest(Request req, String approvalStatus, String mgrEmail);//-A Manager can approve/deny pending reimbursement requests
	public List<Request> viewAllPending();//-A Manager can view all pending requests from all employees
	//change String to img type
	public String viewReceiptImg(Request req);//-A Manager can view images of the receipts from reimbursement requests
	public List<Request> viewAllResolved();//-A Manager can view all resolved requests from all employees and see which manager resolved it
	public List<Employee> viewAllEmployees();//-A Manager can view all Employees
	public List<Request> viewRequestsFrom(String email);//-A Manager can view reimbursement requests from a single Employee
	}
//change login so that only one request is made to server, if exists, return login and type of user


//-An Employee can view the Employee Homepage
//-An Employee can logout
//-A Manager can view the Manager Homepage
//-A Manager can logout
//-An Employee receives an email when one of their reimbursement requests is resolved (optional)
//-A Manager can register an Employee, which sends the Employee an email with their username and temp password (optional)

