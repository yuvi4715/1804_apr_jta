package com.revature.ers.servelets;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper{

    public static Object process(HttpServletRequest request){
        switch(request.getRequestURI()){
            case "/ERS/html/FrontController":
                return "It got: /ERS/html/get.do";
            default:
                return "NOOOt";
        }
    }
}