package com.hpark12.delegate;

import com.hpark12.reimbursementModel.User;

import javax.servlet.http.HttpServletRequest;

public class HomeController {
    public static String home(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("currentUser");
        if(user.getIsManager() == 1)
            return "ManagerHome.html";
        else
            return "UserHome.html";
    }
}