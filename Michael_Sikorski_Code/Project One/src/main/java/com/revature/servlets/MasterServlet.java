/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  MasterServlet for the Project 1 RRS (Reimbursement Request System)
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().write(new ObjectMapper().writeValueAsString(RequestHelper.process(request,response)));
	}

}
