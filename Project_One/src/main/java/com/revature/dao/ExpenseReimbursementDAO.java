package com.revature.dao;

import com.revature.model.Users;

import java.util.List;

import com.revature.model.Reimbursements;


public interface ExpenseReimbursementDAO {

	public boolean insert_users(Users users_id);
	public boolean modify_users(Users users_id);
	public boolean insert_requests(Reimbursements reimb_request);
	public boolean insert_request(Reimbursements r);
	public boolean modify_requests(Reimbursements reimb_request, Users users_id);
	public List<Reimbursements> get_reimbursements_by_email(String email);
	
	
	//Employee
	public List<Reimbursements> emp_view_pending_requests(Users users_id, String reimb_status);
	public List<Reimbursements> emp_view_resolved_requests(Users users_id, String reimb_status);

	//Manager
	public List<Reimbursements> man_view_all_requests();
	public boolean man_update_requests(Reimbursements update);

	
	
	public List<Reimbursements> man_view_pending_requests(String status);
	public List<Reimbursements> man_view_emp_requests(int reimb_requester);
	public Users getUser(Users users_id);
}
