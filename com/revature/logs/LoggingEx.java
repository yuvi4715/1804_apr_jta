package com.revature.logs;

import org.apache.log4j.Logger;

public class LoggingEx {
	final static Logger logger = Logger.getLogger(LoggingEx.class);
	
	public static void main(String[] args) {
//		System.out.println("logging..");
		logger.info("logging");
		logger.warn("logging");
		logger.error("logging");
		logger.debug("logging");
	}
}
