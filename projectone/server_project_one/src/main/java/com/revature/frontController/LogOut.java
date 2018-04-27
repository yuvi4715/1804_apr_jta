package com.revature.frontController;

import java.io.IOException;

import javax.servlet.ServletException;

public class LogOut extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		response.getWriter().append("{\"Session\":\"ended\"}");
		if(request.getSession(false)!=null) 
			request.getSession(false).invalidate();
	}

}
