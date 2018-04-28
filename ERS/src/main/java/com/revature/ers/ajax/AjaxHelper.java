package com.revature.ers.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxHelper{
    public static String process(HttpServletRequest request, HttpServletResponse response){
        switch(request.getRequestURI()){
            case "/ERS/html/test.ajax":
                return AjaxController.getUser(request, response);
            default:
                return "/html/404.html";
        }
    }
}