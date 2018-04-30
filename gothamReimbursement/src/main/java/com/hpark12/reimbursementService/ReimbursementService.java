package com.hpark12.reimbursementService;

import com.hpark12.reimbursementModel.*;
import com.hpark12.reimbursementDao.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReimbursementService {

    private static ReimbursementDao dao = new ReimbursementDaoImplementation();

    public static boolean createUser(User user) {
        return dao.createUser(user);
    }

    public static boolean createAdmin(User user) {
        return dao.createAdmin(user);
    }

    public static boolean addReimbursement(User user, double amount, String purpose) {
        return dao.addReimbursement(user, amount, purpose);
    }

    public static boolean approveReimbursement(User user, int reimbursement_Id, int approval) {
        return dao.approveReimbursement(user, reimbursement_Id, approval);
    }

    public static User loginUser(String email, String password) {
        return dao.loginUser(email, password);
    }

    public static JSONArray viewPending(User user) {
        return dao.viewPending(user);
    }

    public static JSONArray viewApproved(User user) {
        return dao.viewApproved(user);
    }

    public static JSONArray viewAllPending(User user) {
        return dao.viewAllPending(user);
    }

    public static JSONArray viewAllApproved(User user) {
        return dao.viewAllApproved(user);
    }

    public static JSONArray allEmployees() { return dao.allEmployees(); }

}
