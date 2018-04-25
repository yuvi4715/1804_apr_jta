package com.revature.ers.servelets;

import com.revature.ers.service.*;
import javax.servlet.http.HttpServletRequest;

public class RequestHelper{

    private static ERS_Service ers = new ERS_Service();
    public static Object process(HttpServletRequest request){
        ers.man_view_all_requests();
    	System.out.println(request.getRequestURI());
        switch(request.getRequestURI()){
            case "/ERS/html/FrontController":
                return "It got: /ERS/html/get.do";
            default:
                return "NOOOt";
        }
    }
}