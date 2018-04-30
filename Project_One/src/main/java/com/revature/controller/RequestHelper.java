package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.HomeDelegate;
import com.revature.delegate.LoginDelegate;

public class RequestHelper {
	private HomeDelegate hd = new HomeDelegate();
	private LoginDelegate ld = new LoginDelegate();
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String switchString = req.getRequestURI().substring(req.getContextPath().length()+1);
		while(switchString.indexOf("/")>0) {
			switchString = switchString.substring(0, switchString.indexOf("/"));
		}
		switch(switchString) {
		case "home": hd.goHome(req, resp); break;
		case "login": if("POST".equals(req.getMethod())) {
			ld.login(req, resp);
		} else {
			ld.getPage(req, resp);
		} break;
		case "logout": ld.logout(req, resp); break;
		default: break;
		}
	}
}
