package com.revature.ers.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.ers.controller.HomeController;
import com.revature.ers.controller.LoginController;

public class RequestHelper{
    public static String process(HttpServletRequest request){
        switch(request.getRequestURI()){
            case "/ERS/html/login.do":
                return LoginController.login(request);
            case "/ERS/html/home.do":
                return HomeController.home(request);
            case "/ERS/html/logout.do":
                return LoginController.logout(request);
            default:
                return "/html/404.html";
        }
    }
}