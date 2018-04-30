package com.hpark12.reimbursementDao;

import com.hpark12.reimbursementModel.User;
import com.hpark12.reimbursementService.ReimbursementService;
import org.json.JSONObject;

public class Test {

    public static void main(String[] args) {

        User user = ReimbursementService.loginUser("Batman@gmail.com", "Gotham");

        //System.out.println(ReimbursementService.addReimbursement(user, 100000, "Batarangs"));

        System.out.println(ReimbursementService.viewPending(user));

        String test = ReimbursementService.viewAllPending(user).toString();

        System.out.println(test);


    }
}
