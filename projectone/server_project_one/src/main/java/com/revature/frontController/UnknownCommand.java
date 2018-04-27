package com.revature.frontController;

import java.io.IOException;

import javax.servlet.ServletException;

public class UnknownCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		response.getWriter().append("Comand Not Understood");
	}

}
