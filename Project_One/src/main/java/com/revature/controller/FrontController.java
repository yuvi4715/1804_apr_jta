package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 3479236907455377769L;
	
	private RequestHelper rh = new RequestHelper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getRequestURI().substring(req.getContextPath().length())
				.startsWith("/static/")) {
			super.doGet(req, resp);
		} else {
			rh.process(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
