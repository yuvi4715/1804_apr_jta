package com.system.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.system.controller.UserController;
import com.system.model.Request;



public class RequestHelper {

	final static Logger logger = Logger.getLogger(RequestHelper.class);
	public static JSONArray process(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//return null;
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("username") + ""+session.getAttribute("userid"));
		
		switch(request.getRequestURI())
		{
		case "/reimbursement_system/login.do":
			String w = String.valueOf(request.getAttribute("status"));
			System.out.println("in request helper" + request.getAttribute("username") + request.getAttribute("password") + String.valueOf(request.getAttribute("role")) + w);
			logger.info("loging in ");
			return UserController.login(String.valueOf(request.getAttribute("username")), String.valueOf(request.getAttribute("password")), String.valueOf(request.getAttribute("role")), w);
		case "/reimbursement_system/createreq.do":
			logger.info("creating new request");
			Request r = new Request();
			r.setRequestdetails(String.valueOf(request.getAttribute("reqdetails")));
			String y = String.valueOf(request.getAttribute("reqamount"));
			System.out.println(String.valueOf(request.getAttribute("reqdetails")));
			System.out.println(y);
			int o = Integer.parseInt(y);
		    int  u =  (Integer) session.getAttribute("userid");
			r.setReqamount(o);
			System.out.println(o + " " + u + request.getParameter("requestdetails"));
			return UserController.createrequest(r, u);
			
		case "/reimbursement_system/updateRequest.do":
			System.out.println(String.valueOf(request.getAttribute("requestid")));
			String q = String.valueOf(request.getAttribute("requestid"));
			String i = String.valueOf(request.getAttribute("status"));
			int t = Integer.parseInt(q);
			int b = (Integer) session.getAttribute("userid");
			return UserController.updateRequest(t, i, b);
			
		default:
			return null;
		}
		
	}

	
}
