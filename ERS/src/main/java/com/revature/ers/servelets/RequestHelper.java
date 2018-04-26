package com.revature.ers.servelets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.ers.dao.ERSDAO;
import com.revature.ers.dao.ERSDAOImpl;
import com.revature.ers.model.Request;

public class RequestHelper{
    public static Object process(HttpServletRequest request){
        ERSDAO dao = ERSDAOImpl.getERSDAOImpl();
		List<Request> requestList = dao.man_view_all_requests();
		for (Request requests : requestList) {
			System.out.println(requests.toString());
        }
        
        
        switch(request.getRequestURI()){
            case "/ERS/html/FrontController":
                return "It got: /ERS/html/get.do";
            default:
                return "NOOOt";
        }
    }
}