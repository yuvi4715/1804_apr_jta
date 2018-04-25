package com.revature.dao;

import com.revature.model.Users;

import java.util.List;

import com.revature.model.Reimbursements;


public interface ExpenseReimbursementDAO {

	public boolean insert_users(Users users_id);
	public boolean insert_requests(Reimbursements reimb_request);
	public boolean modify_requests(Reimbursements reimb_request, Users users_id);
	public boolean modify_users(Users users_id);
	
	
	//Employee
	public List<Reimbursements> emp_view_pending_requests(Users users_id, int reimb_status);
	public List<Reimbursements> emp_view_resolved_requests(Users users_id, int reimb_status);

	//Manager
	public List<Reimbursements> man_view_all_requests();
	public List<Reimbursements> man_view_pending_requests(int status);
	public List<Reimbursements> man_view_emp_requests(int reimb_requester);

}
