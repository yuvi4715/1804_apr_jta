package com.revature.service;

import java.util.List;

import com.revature.dao.ExpenseReimbursementDAO;
import com.revature.dao.ExpenseReimbursementDAOImple;
import com.revature.model.Reimbursements;
import com.revature.model.Users;

public class ExpenseReimbursementService {

	private static ExpenseReimbursementDAO caller = new ExpenseReimbursementDAOImple();
	
	
    public boolean insert_users(Users users_id){
        return caller.insert_users(users_id);
    }

    public boolean insert_requests(Reimbursements reimb_request){
        return caller.insert_requests(reimb_request);
    }

    public boolean modify_requests(Reimbursements reimb_request, Users users_id){
        if(users_id.getIsManager() == 1)
            return caller.modify_requests(reimb_request, users_id);
        else 
            return false;
    }

    public boolean modify_users(Users users_id){
        return caller.modify_users(users_id);
    }

    public List<Reimbursements> emp_view_certain_requests(Users users_id, int reimb_status){
        return caller.emp_view_pending_requests(users_id, reimb_status);
    }

    public List<Reimbursements> man_view_all_requests(){
        return caller.man_view_all_requests();
    }

    public List<Reimbursements> man_view_certain_requests(int reimb_status){
        return caller.man_view_pending_requests(reimb_status);
    }

    public List<Reimbursements> man_view_emp_requests(int requester){
        return caller.man_view_emp_requests(requester);
    }
	
	
}
