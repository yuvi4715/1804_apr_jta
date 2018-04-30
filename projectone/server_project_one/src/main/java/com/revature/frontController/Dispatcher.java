package com.revature.frontController;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class Dispatcher {
	final static Logger log = Logger.getLogger(Dispatcher.class);

	private Dispatcher() {
	}

	public static FrontCommand getCommand(String s) {

		log.info("Command = " + s);
		if (s == null)
			return new UnknownCommand();
		if (s.equalsIgnoreCase("GetRequestReceipts"))
			return new GetRequestReceipts();
		else if (s.equalsIgnoreCase("ProcessLoginPost")) {
			return new ProcessLoginPost();
		} else if (s.equalsIgnoreCase("GetAllEmployees")) {
			return new GetAllEmployees();
		} else if (s.equalsIgnoreCase("LogOut")) {
			return new LogOut();
		} else if (s.equalsIgnoreCase("UploadReinbursementReceipt")) {
			return new UploadReinbursementReceipt();
		} else if (s.equalsIgnoreCase("UploadEmployee")) {
			return new UploadEmployee();
		} else if (s.equalsIgnoreCase("UpdateReinbursementReceipt")) {
			return new UpdateReinbursementReceipt();
		} else if (s.equalsIgnoreCase("SearchCommand")) {
			return new SearchCommand();
		}
		return new UnknownCommand();
	}
}
