package com.revature.http;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.db.DatabaseSingletonImpl;
import com.revature.frontController.Dispatcher;
import com.revature.frontController.FrontCommand;

/**
 * Servlet implementation class frontController
 */
public class FrontControllerServlet extends HttpServlet {
	final static Logger log = Logger.getLogger(FrontControllerServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public FrontControllerServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Method", "*");
		
		log.info("-------- new request ---------");
		log.info("- Headers -");
		Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
        	String key = (String) headerNames.nextElement();
        	log.info(key+" "+request.getHeader(key));
        }
        log.info("- Parameters -");
		Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
        	String key = (String)paramNames.nextElement();
        	log.info(key+" "+request.getParameter(key));
        }
        log.info("- Attributes -");
		Enumeration attribNames = request.getAttributeNames();
        while (attribNames.hasMoreElements()) {
        	String key = (String)attribNames.nextElement();
        	log.info(key+" "+request.getAttribute(key));
        }
		FrontCommand command = Dispatcher.getCommand(request.getHeader("command"));
		command.init(getServletContext(), request, response);
		command.process();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("POST");
		doGet(request, response);
	}

}
