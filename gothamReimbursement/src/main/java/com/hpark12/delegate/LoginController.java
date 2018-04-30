package com.hpark12.delegate;

import com.hpark12.reimbursementModel.User;
import com.hpark12.reimbursementService.ReimbursementService;
import com.hpark12.util.logUtil;

import javax.servlet.http.HttpServletRequest;

public class LoginController{
    public static String login(HttpServletRequest req){

        logUtil.log.info("inside logincontroller");
        if(req.getMethod().equals("GET")) {
            return "welcome.html";
        }

        String userEmail = req.getParameter("inputEmail");
        String userPassword = req.getParameter("inputPassword");

        User user = ReimbursementService.loginUser(userEmail, userPassword);
        logUtil.log.info(user);

        if(user == null) {
            return "welcome.html";
        }
        else {
            //Session management
            req.getSession().setAttribute("currentUser", user);
            return "home.do";
        }
    }

    public static String logout(HttpServletRequest request){
        request.getSession().removeAttribute("currentUser");
        return "login.html";
    }
}