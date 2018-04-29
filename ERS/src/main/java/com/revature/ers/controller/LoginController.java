package com.revature.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ers.model.ERS_User;
import com.revature.ers.service.ERS_Service;

public class LoginController{
    public static String login(HttpServletRequest request){
		System.out.println("I got here");
        //If it's a GET we just return the view.
		if(request.getMethod().equals("GET")) {
			return "login.html";
		}
		
		//POST logic
		ERS_User loggedUser = ERS_Service.getERS_Service().getUser(request.getParameter("email"), request.getParameter("password"));
		
		// Wrong Credentials
		if(loggedUser == null) {
			return "login.html";
		}
		else {
			System.out.println("I got a user!");
			/* Storing loggedUser to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			request.getSession().setAttribute("loggedUser", loggedUser);
			//Forward user to hit another controller
			return "home.do";
		}
	}
	
	public static String logout(HttpServletRequest request){
		request.getSession().removeAttribute("loggedUser");
		return "login.html";
	}
}