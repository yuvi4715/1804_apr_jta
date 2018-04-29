package com.revature.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ers.model.ERS_User;

public class HomeController{
    public static String home(HttpServletRequest request){
        ERS_User user = (ERS_User) request.getSession().getAttribute("loggedUser");
        if(user.getIsManager() == 1)
            return "homeMan.html";
        else
            return "homeEmp.html";
    }
}