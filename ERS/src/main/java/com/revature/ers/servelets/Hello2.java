package com.revature.ers.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Hello2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Document</title></head><body><h2>This is Hello2</h2></body></html>");
	}

}
