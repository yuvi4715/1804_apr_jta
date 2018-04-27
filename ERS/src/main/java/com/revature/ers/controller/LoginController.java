package com.revature.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ers.model.ERS_User;
import com.revature.ers.service.ERS_Service;

public class LoginController{
    public static String login(HttpServletRequest request){
        //If it's a GET we just return the view.
		// if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
		// 	return "login.jsp";
		// }
		
		//POST logic
		ERS_User loggedUser = ERS_Service.getERS_Service().getUser(request.getParameter("email"), request.getParameter("password"));
		
		// Wrong Credentials
		if(loggedUser == null) {
			return "login.jsp";
		}
		else {
			/* Storing loggedCustomer to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			request.getSession().setAttribute("loggedUser", loggedUser);
			
			//Forward user to hit another controller
			return "/home.do";
		}
    }
}