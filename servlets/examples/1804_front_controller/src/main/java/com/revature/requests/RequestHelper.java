package com.revature.requests;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Bank;
import com.revature.services.DepositService;

public class RequestHelper {
	
	public static Object process(HttpServletRequest req) {
//		System.out.println(req.getRequestURI());
//		System.out.println(req.getRequestURL());
		System.out.println(req.getParameter("user"));
		switch (req.getRequestURI()) {
			case "/1804_front_controller/welcome.html": 
				return DepositService.getBalance(new Bank(100,"Checking"), req.getParameter("user"));
			case "/1804_front_controller/display.do":
				return DepositService.returnArrayList();
			default: 
				return DepositService.getBalance(new Bank(0,"No Balance"), req.getParameter("user"));
		}	
	}
}
