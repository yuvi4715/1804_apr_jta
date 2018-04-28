package com.revature.ers.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.*;

public class AjaxServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public AjaxServlet(){
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
		
		response.getWriter().write(
				new ObjectMapper().writeValueAsString(AjaxHelper.process(request, response)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
		
		response.getWriter().write(
				new ObjectMapper().writeValueAsString(AjaxHelper.process(request, response)));
    }

}