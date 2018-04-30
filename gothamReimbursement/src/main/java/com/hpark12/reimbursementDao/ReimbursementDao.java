package com.hpark12.reimbursementDao;

import com.hpark12.reimbursementModel.User;
import org.json.JSONArray;


public interface ReimbursementDao {

    boolean createUser(User user);

    boolean createAdmin(User user);

    boolean addReimbursement(User user, double amount, String purpose);

    boolean approveReimbursement(User user, int reimbursement_Id, int approval);

    User loginUser(String email, String password);

    JSONArray viewPending(User user);

    JSONArray viewApproved(User user);

    JSONArray viewAllPending(User user);

    JSONArray viewAllApproved(User user);

    JSONArray allEmployees();
}
