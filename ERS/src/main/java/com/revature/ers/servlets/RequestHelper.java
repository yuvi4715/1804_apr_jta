package com.revature.ers.servlets;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper{
    public static String process(HttpServletRequest request){
        switch(request.getRequestURI()){
            case "/ERS/html/login.do":
            // return LoginController.login(request);
            case "ERS/html/home.do":
            // return HomeController.home(request);
            default:
                return "404.html";
        }
    }
}