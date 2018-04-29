package com.revature.ers.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxHelper{
    public static String process(HttpServletRequest request, HttpServletResponse response){
        System.out.println("URI is: " + request.getRequestURI());
        switch(request.getRequestURI()){
            case "/ERS/html/certreq.ajax":
                return AjaxController.empViewCertainReq(request, response);
            case "/ERS/html/insertreq.ajax":
                return AjaxController.insertReq(request, response);
            case "/ERS/html/modifyuser.ajax":
                return AjaxController.modifyUser(request, response);
            case "/ERS/html/getuser.ajax":
                return AjaxController.getUser(request, response);
            default:
                return "/html/404.html";
        }
    }
}