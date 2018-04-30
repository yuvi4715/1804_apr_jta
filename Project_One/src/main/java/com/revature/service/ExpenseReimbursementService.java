package com.revature.service;

import java.util.List;

import com.revature.dao.ExpenseReimbursementDAO;
import com.revature.dao.ExpenseReimbursementDAOImple;
import com.revature.model.Reimbursements;
import com.revature.model.Users;

public class ExpenseReimbursementService {

	private static ExpenseReimbursementDAO caller = new ExpenseReimbursementDAOImple();
	
	public static List<Reimbursements> get_reimbursements_by_email(String email) {
		return caller.get_reimbursements_by_email(email);
	}
		
	
	public static boolean man_update_requests(Reimbursements update) {
		return caller.man_update_requests(update);
	}

	
    public static boolean insert_users(Users users_id){
        return caller.insert_users(users_id);
    }

    public static boolean insert_request(Reimbursements reimb_request){
        return caller.insert_request(reimb_request);
    }

    public static boolean modify_requests(Reimbursements reimb_request, Users users_id){
        if(users_id.getIsManager() == 1)
            return caller.modify_requests(reimb_request, users_id);
        else 
            return false;
    }

    public static boolean modify_users(Users users_id){
        return caller.modify_users(users_id);
    }

    public static List<Reimbursements> emp_view_certain_requests(Users users_id, String reimb_status){
        return caller.emp_view_pending_requests(users_id, reimb_status);
    }

    public static List<Reimbursements> man_view_all_requests(){
        return caller.man_view_all_requests();
    }

    public static List<Reimbursements> man_view_certain_requests(String reimb_status){
        return caller.man_view_pending_requests(reimb_status);
    }

    public static List<Reimbursements> man_view_emp_requests(int requester){
        return caller.man_view_emp_requests(requester);
    }
    
    public static Users getUser(Users users_id) {
    	System.out.println(users_id.getPassword());
    	System.out.println(users_id.getEmail());

    	return caller.getUser(users_id);
    	
    }
	
    public static void main(String[] args) {
		Users user = new Users(0, null, "123456", null, null, "ramnery@revature.com", 0);
		user = getUser(user);
		System.out.println(user.toString());
		
		
	}
	
}
